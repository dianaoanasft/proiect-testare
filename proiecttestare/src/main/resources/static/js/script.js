

let loginForm = document.querySelector('.header .login-form');

document.querySelector('#login-btn').onclick = () => {
    loginForm.classList.toggle('active');
    navbar.classList.remove('active');
}

let navbar = document.querySelector('.header .navbar');

window.onscroll = () => {
    loginForm.classList.remove('active');
    navbar.classList.remove('active');

    if (window.scrollY > 0) {
        document.querySelector('.header').classList.add('active');
    } else {
        document.querySelector('.header').classList.remove('active');
    }
}

window.onload = () => {
    if (window.scrollY > 0) {
        document.querySelector('.header').classList.add('active');
    } else {
        document.querySelector('.header').classList.remove('active');
    }
}

document.querySelector("#submitButton").onclick = () => {

    let name = document.getElementById("name").value;
    document.getElementById("name").value = "";

    let email = document.getElementById("email").value;
    document.getElementById("email").value = "";

    let number = document.getElementById("number").value;
    document.getElementById("number").value = "";

    let textArea = document.getElementById("textArea").value;
    document.getElementById("textArea").value = "";

    document.getElementById("saved-name").innerHTML = "Name: " + name;
    document.getElementById("saved-email").innerHTML = "Email: " + email;
    document.getElementById("saved-number").innerHTML = "Phone number: " + number;

    document.getElementById("confirmationPopup").style.display = "block";
}

document.querySelector("#ok-btn").onclick = () => {
    document.getElementById("confirmationPopup").style.display = "none";
}
