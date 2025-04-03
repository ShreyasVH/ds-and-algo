const axios = require('axios');

const { post } = require('./api');
const fs = require('fs');

(async () => {
	let problems = [];

	let total = 1;
	let offset = 0;
	const pageSize = 50;
	let totalPages = 99999;

	let sectionProblems = [];

	while (offset < total) {
		const url = 'https://leetcode.com/graphql/';
		console.log(offset, total);

		const payload = {
		    "query": "\n    query problemsetQuestionList($categorySlug: String, $limit: Int, $skip: Int, $filters: QuestionListFilterInput) {\n  problemsetQuestionList: questionList(\n    categorySlug: $categorySlug\n    limit: $limit\n    skip: $skip\n    filters: $filters\n  ) {\n    total: totalNum\n    questions: data {\n      acRate\n      difficulty\n      freqBar\n      frontendQuestionId: questionFrontendId\n      isFavor\n      paidOnly: isPaidOnly\n      status\n      title\n      titleSlug\n      topicTags {\n        name\n        id\n        slug\n      }\n      hasSolution\n      hasVideoSolution\n    }\n  }\n}\n    ",
		    "variables": {
		        "categorySlug": "all-code-essentials",
		        "skip": offset,
		        "limit": pageSize,
		        "filters": {}
		    },
		    "operationName": "problemsetQuestionList"
		};

		const response = (await post(url, payload)).data;
		// console.log(response);
		const responseData = response.data; 

	    if (offset == 0) {
	    	total = responseData.problemsetQuestionList.total;
	    }

	    const results = responseData.problemsetQuestionList.questions.map(result => {
	    	const problemUrl = `https://leetcode.com/problems/${result.titleSlug}`;
	    	const problemName = result.title;
	    	const id = result.frontendQuestionId;
	    	const difficulty = result.difficulty;
	    	const isPaid = result.paidOnly;

	    	return {
	    		id,
	    		problemName,
	    		problemUrl,
	    		difficulty,
	    		isPaid
	    	};
	    });

	    problems = problems.concat(results);

	    offset += pageSize;
	}

	const filePath = 'allProblems.json';
    fs.writeFileSync(filePath, JSON.stringify(problems, null, ' '));
})();