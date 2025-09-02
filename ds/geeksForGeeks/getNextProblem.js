const fs = require('fs');

(async () => {
	const filePath = 'allProblems.json';
	const problems = JSON.parse(fs.readFileSync(filePath).toString());
	console.log(`All: ${problems.length}`);

	problems.sort((a, b) => (a.id - b.id));

	const allFiles = fs.readdirSync('.');
	const javaFiles = allFiles.filter(file => file.match(/Problem\d+[.]java/) !== null);
	const solvedProblems = javaFiles.map(fileName => parseInt(fileName.replace('Problem', '').replace('.java', '')));
	console.log(`Solved: ${solvedProblems.length}`);

	for (const problem of problems) {
		const id = problem.id;
		const difficulty = problem.difficulty;
		if (!solvedProblems.includes(id) && 'Hard' !== difficulty) {
			console.log(id);
			console.log(problem.problemUrl);
			console.log(difficulty);
			break;
		}
	}
})();