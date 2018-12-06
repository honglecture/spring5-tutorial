window.addEventListener("load", ()=>{

    let loginForm = document.querySelector("#login-form");
    let loginButton = loginForm.querySelector(".login-button");
    let joinButton = loginForm.querySelector(".join-button");

    joinButton.onclick = ()=>{
        location.href = "join";
    };

});