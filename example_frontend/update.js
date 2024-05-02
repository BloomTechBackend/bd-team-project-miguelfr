const projectForm = document.querySelector("#update-project-form");
const url = window.location.href;
const urlParts = url.split('=');
const id = urlParts[urlParts.length - 1];

projectForm.onsubmit = async function(evt) {
  evt.preventDefault();
  const projectRequest = {
    "id": document.querySelector("#project-id").value,
    "title": document.querySelector("#title").value,
    "description": document.querySelector("#description").value,
    "course": document.querySelector("#course").value,
    "gitUrl": document.querySelector("#gitUrl").value,
    "websiteUrl": document.querySelector("#websiteUrl").value,
    "year": document.querySelector("#year").value,
    "teamName": document.querySelector("#teamName").value,
    "dev1": document.querySelector("#dev1").value,
    "dev2": document.querySelector("#dev2").value,
    "dev3": document.querySelector("#dev3").value,
    "dev4": document.querySelector("#dev4").value,
  }
  axios.put(`https://62xhyw6tad.execute-api.us-west-2.amazonaws.com/dev/projects/${id}`, projectRequest)
  .then((res) => {
    console.log(res);
    //window.location.reload();
    window.location.href = '/home.html';
  })
  .catch(error => {
    console.error('Error', error);
  });
}

window.onload = async function(evt) {
  evt.preventDefault();
  const project = {
    "id": id
  }
  console.log("Getting the Project ...");
  axios.get(`https://62xhyw6tad.execute-api.us-west-2.amazonaws.com/dev/projects/${id}`,project)
  .then((res) => {
    console.log(res.data);
    populateProjectData(res.data.team,res.data.project);
  })
}


function populateProjectData(team,project) {
  document.querySelector("#title").value = project.title;
  document.querySelector("#description").value = project.description;
  document.querySelector("#course").value = project.course;
  document.querySelector("#gitUrl").value = project.gitUrl;
  document.querySelector("#websiteUrl").value = project.websiteUrl;
  document.querySelector("#year").value = project.year;
  document.querySelector("#teamName").value = team.name;
  document.querySelector("#dev1").value = team.dev1;
  document.querySelector("#dev2").value = team.dev2;
  document.querySelector("#dev3").value = team.dev3;
  document.querySelector("#dev4").value = team.dev4;
  document.querySelector("#project-id").value = project.id;
}
