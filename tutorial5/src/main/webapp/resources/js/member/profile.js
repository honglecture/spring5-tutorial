window.addEventListener("load", ()=>{

    let profileSection = document.querySelector("#profile-section");
    let logoutButton = profileSection.querySelector(".logout-button");
    
    let cancelButton = profileSection.querySelector(".cancel-button");

    logoutButton.onclick = ()=>{
        location.href = "logout";
    };
    
    cancelButton.onclick = ()=>{
        location.href = "/index";
    };

});