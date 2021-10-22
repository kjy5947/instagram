
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

/////////////////////////////////////////////////////////////content

const postBtn = document.getElementById('post');
const videoBtn = document.getElementById('video');
const bookMarkBtn = document.getElementById('bookMark');
const taggedBtn = document.getElementById('tagged');
const uname = document.getElementById('uname').innerHTML;
const param = 'uname=' +uname;
const contentBtn = document.getElementsByClassName('contentBtn');
const contentOut = document.getElementById('contentOut');



const addToContentOut  =  (postJoinImages) => {
	
		
	
	const file = postJoinImages.pimg;
	
	const newImg = document.createElement('img');
	newImg.src = file;
	
	const newDiv = document.createElement('div');
	newDiv.setAttribute('class', 'contentOutPost');
	newDiv.appendChild(newImg);
	contentOut.appendChild(newDiv);
	
	//const reader = new FileReader();
	
	//	reader.readAsDataURL(file);
	
	//reader.onload = function() {
		//const newDiv = document.createElement('div');	
		//newDiv.setAttribute('class', 'contentOutPost');
		//newDiv.style = `background : url(${reader.result});`
	//}
	
}


function BtnEventListener(e) {
	
	contentOut.innerHTML ="";
		let btn = postBtn; 
	try {
		btn = document.getElementById(e.target.id);
	} catch(error) {
		btn = postBtn
	}
	
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
				
				const postJoinImageList  =  JSON.parse(e.target.responseText);
				
				console.log(getAttrub);
				postJoinImageList.forEach(function(postJoinImages){
				addToContentOut(postJoinImages);
			});	
		}				
	});
			if(btn == postBtn) {
				xhttp.open('POST', '/insta/postRest/getPost', true);
			} else if (btn == videoBtn) {
				xhttp.open('POST', '/insta/postRest/getPost', true);
			} else if (btn == bookMarkBtn) {
				xhttp.open('POST', '/insta/postRest/getPost', true);
			} else if (btn == taggedBtn) {
				xhttp.open('POST', '/insta/postRest/getPost', true);
			}
			
			xhttp.setRequestHeader('content-type', "application/x-www-form-urlencoded");
			
			xhttp.send(param);
			
}

postBtn.addEventListener('click', BtnEventListener);
videoBtn.addEventListener('click', BtnEventListener);
bookMarkBtn.addEventListener('click', BtnEventListener);
taggedBtn.addEventListener('click', BtnEventListener);

window.onload = BtnEventListener();

function btnCssReset(btn) {
	btn.style.color = "gray";
	btn.style.borderTop = "gray";
	
}














