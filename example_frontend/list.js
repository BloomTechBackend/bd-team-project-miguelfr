const playlistForm = document.querySelector("#create-playlist-form");
const playlistsList = document.querySelector("#playlists");

window.onload = async function(evt) {
  evt.preventDefault();
  console.log("Getting All Projects...");
  axios.get("https://62xhyw6tad.execute-api.us-west-2.amazonaws.com/dev/projects")
  .then((res) => {
    console.log(res.data);
    populateProjectList(res.data.teamList,res.data.projectList);
  })
}

function populateProjectList(teamList, projectList) {

  for (let team of teamList) {
    let li = document.createElement("li");
    let a = document.createElement("a");
    let text = document.createTextNode(team.name);

    a.setAttribute('href', `./playlist.html?id=${team.id}`);

    a.appendChild(text);
    li.appendChild(a);
    playlistsList.appendChild(li);
  }
}
