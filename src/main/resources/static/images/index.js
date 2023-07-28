function windowScroll() {
    const e = document.getElementById("navbar");
    e && (document.body.scrollTop >= 50 || document.documentElement.scrollTop >= 50 ? e.classList.add("nav-sticky") : e.classList.remove("nav-sticky"))
}
function validateForm() {
    var name = document.forms["myForm"]["name"].value;
    var email = document.forms["myForm"]["email"].value;
    var subject = document.forms["myForm"]["subject"].value;
    var message = document.forms["myForm"]["comments"].value;

    if (name === "" || email === "" || subject === "" || message === "") {
        document.getElementById("error-msg").innerText = "Please fill out all required fields.";
        return false;
    }
    return true;
}
function fadeIn() {
    var e = document.getElementById("error-msg")
      , t = 0
      , r = setInterval(function() {
        t < 1 ? (t += .5,
        e.style.opacity = t) : clearInterval(r)
    }, 200)
}
function toggleSwitcher() {
    var e = document.getElementById("style-switcher");
    "-189px" === e.style.left ? e.style.left = "-0px" : e.style.left = "-189px"
}
function setColor(e) {
    document.getElementById("color-opt").href = "./css/colors/" + e + ".css",
    toggleSwitcher(!1)
}
window.addEventListener("scroll", e=>{
    e.preventDefault(),
    windowScroll()
}
),
feather.replace();


function windowScroll() {
    const e = document.getElementById("navbar");
    e && (document.body.scrollTop >= 50 || document.documentElement.scrollTop >= 50 ? e.classList.add("nav-sticky") : e.classList.remove("nav-sticky"))
}

window.addEventListener("scroll", e=>{
    e.preventDefault(),
    windowScroll()
}
),
feather.replace();