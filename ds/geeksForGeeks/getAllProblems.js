const axios = require('axios');

const { get } = require('./api');
const fs = require('fs');

(async () => {
	let problems = [];

	let total = 0;
	let page = 1;
	const pageSize = 20;
	let totalPages = 99999;

	let sectionProblems = [];

	while (page <= totalPages) {
		const url = 'https://practiceapi.geeksforgeeks.org/api/vr/problems/?pageMode=explore&page=' + page + '&sortBy=latest';
		console.log(url);

		let response = (await get(url, {})).data;
		// console.log(response);

	    if (page === 1) {
	    	total = response.total;
    		totalPages = Math.ceil(total / pageSize);
    		console.log(total);
    		console.log(totalPages);
	    }

	    const results = response.results.map(result => {
	    	const problemUrl = result.problem_url;
	    	const problemName = result.problem_name;
	    	const id = result.id;
	    	const difficulty = result.difficulty;

	    	return {
	    		id,
	    		problemName,
	    		problemUrl,
	    		difficulty
	    	};
	    });

	    problems = problems.concat(results);

	    page++;
	}

	const filePath = 'problems.txt';
    fs.writeFileSync(filePath, JSON.stringify(problems, null, ' '));
})();