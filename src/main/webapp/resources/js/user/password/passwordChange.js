/**
 * 
 */


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