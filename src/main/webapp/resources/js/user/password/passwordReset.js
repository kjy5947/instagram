/**
 * 
 */

const inputBtn = document.getElementById('inputBtn');
const inputForm = document.getElementById('inputForm');
const out = document.getElementById('out');

const addToPopup = (user) => {
	out.innerHTML = user.uemail;
}

const showPopup  = () => {	
const xhttp = new XMLHttpRequest();

xhttp.addEventListener('readystatechange', (e) => {
				const readyState = e.target.readyState;
				const httpStatus = e.target.status;
				
				if(readyState == 4 && httpStatus == 200) {
					addToPopup(JSON.parse(e.target.responseText));
				}
			});	
			
xhttp.open('POST', '/insta/passwordReset', true);
xhttp.setRequestHeader('content-type', 'application/json;charset=UTF-8');
console.log(document.getElementById('inputKey').value);

const inputKey = document.getElementById('inputKey').value;

xhttp.send(JSON.stringify(inputKey));	
	
const popup = document.querySelector('#popup');
popup.classList.add('has-filter');
popup.classList.remove('hide');

}

function closePopup() {
	const popup = document.querySelector('#popup');
  popup.classList.add('hide');
}

inputBtn.addEventListener('click', showPopup);

