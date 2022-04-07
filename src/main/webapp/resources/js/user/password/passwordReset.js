/**
 * 
 */

const inputBtn = document.getElementById('inputBtn');
const inputForm = document.getElementById('inputForm');
const out = document.getElementById('out');
var content = document.getElementById('content');
const h3 = document.getElementById('h3');
		
const addToPopup = (user) => {
		h3.innerHTML = "SMS 전송함";
		out.innerHTML = "<div>계정에 다시 로그인할 수 있는 링크가 포함된 SMS를</div>"+user.uemail+"에 보내드렸습니다.";		
}

const showPopup  = () => {	
const xhttp = new XMLHttpRequest();

xhttp.addEventListener('readystatechange', (e) => {
				const readyState = e.target.readyState;
				const httpStatus = e.target.status;
				
				if(readyState == 4 && httpStatus == 200) {
					try {
						addToPopup(JSON.parse(e.target.responseText))
					} catch(error) {
						h3.innerHTML = "오류";
						out.innerHTML = "이메일, 전화번호 또는 사용자 이름을 잘못 입력하셨습니다.";
					}
					
				}
			});	
			
xhttp.open('POST', '/insta/passwordReset', true);
xhttp.setRequestHeader('content-type', 'application/json;charset=UTF-8');

const inputKey = document.getElementById('inputKey').value;

xhttp.send(JSON.stringify(inputKey));

const popup = document.querySelector('#popup');
popup.classList.add('has-filter');
popup.classList.remove('hide');

}

function closePopup() {
	const popup = document.querySelector('#popup');
  popup.classList.add('hide');
	h3.innerHTML = "알림";
	out.innerHTML = "잠시만 기다려 주세요...";
}

inputBtn.addEventListener('click', showPopup);

