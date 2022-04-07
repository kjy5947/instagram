/**
 * 
 */
var str = window.location.href;
var url = location.origin + '/insta/home/' + str.substring(37, str.length);

history.pushState(null, null, null);

history.pushState(null,null,str.substring(37, str.length));
//history.back();


const passwordForm = document.getElementById('passwordForm');
const alertDanger = document.getElementById('alert-danger');
const alertSuccess = document.getElementById('alert-success');


passwordForm.addEventListener("submit", function(evt) {
	
const pwd = document.getElementById('pwd').value;
const pwdCheck = document.getElementById('pwdCheck').value;
	if(pwd != pwdCheck) {
        evt.preventDefault();
        window.history.back();
		alertDanger.style.display = "block";
		alertSuccess.style.display = "none";
	
} else {
	
}
    });