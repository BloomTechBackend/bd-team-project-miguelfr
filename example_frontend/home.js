

//const projectForm = document.querySelector("#create-project-form");
const projectListTable = document.querySelector("#list-project-table");

window.onload = async function(evt) {
  evt.preventDefault();
  console.log("Getting Projects Data...");
  axios.get("https://62xhyw6tad.execute-api.us-west-2.amazonaws.com/dev/projects")
  .then((res) => {
    console.log(res.data);
    populateProjecsTable(res.data.teamList,res.data.projectList);
  })
}

function populateProjecsTable(teamList, projectList) {
  let tbody = projectListTable.createTBody(); 
  for (let i = 0; i < projectList.length; i++) {
    let row = tbody.insertRow();

    //Project Number
    let numberCell = row.insertCell(); 
    let text = document.createTextNode(i+1);
    numberCell.appendChild(text);
    //Project Title
    let titleCell = row.insertCell();
    text = document.createTextNode(projectList[i].title);
    titleCell.appendChild(text);
    //Team Name
    let teamNameCell = row.insertCell();
    text = document.createTextNode(teamList[i].name);
    teamNameCell.appendChild(text);
    //Project Details and Update
    let cell = row.insertCell();
    let detailA = document.createElement("a");
    let updateA = document.createElement("a");
    detailText = document.createTextNode("Details  ");
    updateText = document.createTextNode("Update");
    detailA.setAttribute('href', `./detail.html?id=${projectList[i].id}`)
    detailA.appendChild(detailText);
    updateA.setAttribute('href', `./update.html?id=${projectList[i].id}`)
    updateA.appendChild(updateText);
    cell.appendChild(detailA);
    cell.appendChild(updateA);

  }
}
