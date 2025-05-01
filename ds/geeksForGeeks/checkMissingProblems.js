const fs = require('fs');
const path = require('path');

const problemMapFilePath = path.resolve(__dirname, '../problemMap.json');
const problemMap = JSON.parse(fs.readFileSync(problemMapFilePath).toString());
// console.log(problemMap);
const geeksProblems = Object.values(problemMap).reduce((list, curr) => {
	if(curr.geeksForGeeks)
	{
		list.push(curr.geeksForGeeks);
	}
	return list;
}, []);
// console.log(geeksProblems);

let allFiles = fs.readdirSync('./');

const files = allFiles.filter(file => file.match(/^Problem(\d)+[.]java/) != null);

const missing = [];
for (const file of files) {
	const problem = parseInt(file.replace('Problem', '').replace('.java', ''));
	if (!geeksProblems.includes(problem)) {
		missing.push(problem);
	}
}

console.log(missing);