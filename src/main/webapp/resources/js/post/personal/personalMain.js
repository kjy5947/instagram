


function popup(obj){
	var op = document.getElementsByClassName(obj)[0];
	op.style.display = "flex";	
}

function closePopup(obj) {
	var op = document.getElementsByClassName(obj)[0];
	op.style.display = "none";	
}

function modalImage(){

	var op = document.getElementsByClassName("modal-image")[0];
	op.style.display="none";
	
	
}

function profileUpload() {
   var slct = document.getElementById("userProfileImage");
   slct.click();

   slct.addEventListener("change", (e) => {
      let f = e.target.files[0];
	
      if (!f.type.match("image.*")) {
         alert("이미지를 등록해야 합니다.");
         return 0;
      }

      
      let reader = new FileReader();
      var slct2 = document.getElementById("basicUserProfileImage");
      reader.onload = (e) => {
      	console.log(f);
      	slct2.setAttribute('src', e.target.result);
      }
      reader.readAsDataURL(f); // 이 코드 실행시 reader.onload 실행됨.
   });
}

// content

const postBtn = document.getElementById('post');
const videoBtn = document.getElementById('video');
const bookMarkBtn = document.getElementById('bookMark');
const taggedBtn = document.getElementById('tagged');
const userId = document.getElementById('user_id').innerHTML;
const param = 'userId=' +userId;
const contentBtn = document.getElementsByClassName('contentBtn');

function btnCssChange(e) {

	const btn = document.getElementById(e.target.id);
	
	btnCssReset(postBtn);
	btnCssReset(videoBtn);
	btnCssReset(bookMarkBtn);
	btnCssReset(taggedBtn);
	btn.style.color = "black";
	btn.style.borderTop = "1px solid black";
	
	const xhttp = new XMLHttpRequest();			
	xhttp.addEventListener('readystatechange', (e) => {
		
		const readyState = e.target.readyState;
		const httpStatus = e.target.status;
				
				if(readyState == 4 && httpStatus == 200) {
					addToTableOut(JSON.parse(e.target.responseText));
				}
						
			});
			
			xhttp.open('POST', '/insta/postRest/getPost', true);
			
			xhttp.setRequestHeader('content-type', "application/x-www-form-urlencoded");

			xhttp.send(param);
}

postBtn.addEventListener('click', btnCssChange);
videoBtn.addEventListener('click', btnCssChange);
bookMarkBtn.addEventListener('click', btnCssChange);
taggedBtn.addEventListener('click', btnCssChange);


function btnCssReset(btn) {
	btn.style.color = "gray";
	btn.style.borderTop = "gray";
	
}














