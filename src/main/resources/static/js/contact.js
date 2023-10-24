import { apiCall } from "./apiCall.js";

window.contactFormSubmit = contactFormSubmit;

async function contactFormSubmit() {

var e = document.forms.myForm.name.value
      , t = document.forms.myForm.email.value
      , r = document.forms.myForm.subject.value
      , n = document.forms.myForm.number.value
      , m = document.forms.myForm.comments.value;
    if (document.getElementById("error-msg").style.opacity = 0,
    document.getElementById("error-msg").innerHTML = "",
    "" == e || null == e)
        return document.getElementById("error-msg").innerHTML = "<div class='alert alert-danger error_message'>*Please enter a Name*</div>",
        fadeIn(),
        !1;
    if ("" == t || null == t)
        return document.getElementById("error-msg").innerHTML = "<div class='alert alert-danger error_message'>*Please enter a Email*</div>",
        fadeIn(),
        !1;
    if ("" == r || null == r)
        return document.getElementById("error-msg").innerHTML = "<div class='alert alert-danger error_message'>*Please enter a Subject*</div>",
        fadeIn(),
        !1;
    if ("" == n || null == n)
        return document.getElementById("error-msg").innerHTML = "<div class='alert alert-danger error_message'>*Please enter a number*</div>",
        fadeIn(),
        !1;
    if ("" == m || null == m)
        return document.getElementById("error-msg").innerHTML = "<div class='alert alert-danger error_message'>*Please enter a Comments*</div>",
        fadeIn(),
        !1;
    const name = document.getElementById("name").value;
    const contactInfo = document.getElementById("email").value;
    const message = document.getElementById("subject").value;
    const number = document.getElementById("number").value;
    const comments = document.getElementById("comments").value;
    const url = '/contact/send';
    const headers = {
        'Content-Type': 'application/json'
    };

    const body = {
        name: name,
        contactInfo: contactInfo,
        number: number,
        comments: comments,
        body: message
    };
    const result = await apiCall(url, "POST", headers, body);
    const json = await result.json();
    const contactFormSuccessElement = document.getElementById("ContactFormSuccess");
    const contactFormErrorElement = document.getElementById("ContactFormError");
    if (result.status === 200) {
        contactFormSuccessElement.style.display = "flex";
        contactFormErrorElement.style.display = "none";
    } else {
        contactFormSuccessElement.style.display = "none";
        contactFormErrorElement.style.display = "flex";
        contactFormErrorElement.textContent = json.reason;
        if (result.status !== 406) {
            alert(`Error in sending message, refresh. If this problem persists, contact me.\n\nReason: ${json.reason}`);
        }
    }
}

