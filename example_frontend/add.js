const projectForm = document.querySelector("#create-project-form");
//const playlistsList = document.querySelector("#playlists");

projectForm.onsubmit = async function(evt) {
  evt.preventDefault();
  const projectRequest = {
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
  axios.post("https://62xhyw6tad.execute-api.us-west-2.amazonaws.com/dev/projects", projectRequest)
  .then((res) => {
    console.log(res);
    //window.location.reload();
    window.location.href = '/list.html';
  })
  .catch(error => {
    console.error('Error', error);
  });
}


/*
window.onload = async function(evt) {
  evt.preventDefault();
  console.log("Getting Playlist Data...");
  axios.get("https://svebsuap66.execute-api.us-west-2.amazonaws.com/prod/playlists", {
    authorization: {
      'x-api-key': 'K7CHRL6aqt1C6eGJ9EHyFaZCn86G0fyI2sTZKSkW'
    }
  }).then((res) => {
    console.log(res.data);
    populatePlaylists(res.data.playlists);
  })
}

function populatePlaylists(playlistData) {

  for (let playlist of playlistData) {
    let li = document.createElement("li");
    let a = document.createElement("a");
    let text = document.createTextNode(playlist.name);

    a.setAttribute('href', `./playlist.html?id=${playlist.id}`);

    a.appendChild(text);
    li.appendChild(a);
    playlistsList.appendChild(li);
  }
}*/
