const tableBody = document.querySelector("#table-body");
const url = window.location.href;
const urlParts = url.split('=');
const id = urlParts[urlParts.length - 1];

window.onload = async function(evt) {
  evt.preventDefault();
  const project = {
    "id": id
  }
  console.log("Getting the Project ...");
  axios.get(`https://62xhyw6tad.execute-api.us-west-2.amazonaws.com/dev/projects/${id}`,project)
  .then((res) => {
    console.log(res.data);
    populateProjectDetails(res.data.team,res.data.project);
  })
}

function populateProjectDetails(team,project) {
  const rowTitle = document.createElement('tr');
  rowTitle.innerHTML = `<th>Title</th><td>${project.title}</td>`
  tableBody.appendChild(rowTitle);

  const rowTeamName = document.createElement('tr');
  rowTeamName.innerHTML = `<th>Team name</th><td>${team.name}</td>`
  tableBody.appendChild(rowTeamName);

  const rowDescription = document.createElement('tr');
  rowDescription.innerHTML = `<th>Description</th><td>${project.description}</td>`
  tableBody.appendChild(rowDescription);

  const rowCourse = document.createElement('tr');
  rowCourse.innerHTML = `<th>Course</th><td>${project.course}</td>`
  tableBody.appendChild(rowCourse);

  const rowYear = document.createElement('tr');
  rowYear.innerHTML = `<th>Year</th><td>${project.year}</td>`
  tableBody.appendChild(rowYear);

  const rowGitUrl = document.createElement('tr');
  rowGitUrl.innerHTML = `<th>Git Url</th><td>${project.gitUrl}</td>`
  tableBody.appendChild(rowGitUrl);

  const rowWebSiteUrl = document.createElement('tr');
  rowWebSiteUrl.innerHTML = `<th>Wesite Url</th><td>${project.websiteUrl}</td>`
  tableBody.appendChild(rowWebSiteUrl);

  const rowDev1 = document.createElement('tr');
  rowDev1.innerHTML = `<th>Developer 1</th><td>${team.dev1}</td>`
  tableBody.appendChild(rowDev1);

  const rowDev2 = document.createElement('tr');
  rowDev2.innerHTML = `<th>Developer 2</th><td>${team.dev2}</td>`
  tableBody.appendChild(rowDev2);

  const rowDev3 = document.createElement('tr');
  rowDev3.innerHTML = `<th>Developer 3</th><td>${team.dev3}</td>`
  tableBody.appendChild(rowDev3);

  const rowDev4 = document.createElement('tr');
  rowDev4.innerHTML = `<th>Developer 4</th><td>${team.dev4}</td>`
  tableBody.appendChild(rowDev4);
  
}
