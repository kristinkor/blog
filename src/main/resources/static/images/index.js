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