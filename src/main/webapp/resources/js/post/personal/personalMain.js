
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
   $("#userProfileImage").click();
 
   $("#userProfileImage").on("change", (e) => {
      let f = e.target.files[0];

      if (!f.type.match("image.*")) {
         alert("이미지를 등록해야 합니다.");
         return 0;
      }
	 var edited = document.userProfileImageForm;
     edited.method = "POST";
     edited.action = "personal";
     edited.enctype = "multipart/form-data";
     edited.submit();
	
      // 사진 전송 성공시 이미지 변경
      let reader = new FileReader();
      reader.onload = (e) => {
         $("#basicUserProfileImage").attr("src", e.target.result);
         $("#userProfileImage").attr("value", e.target.result);
         console.log(document.getElementById("userProfileImage").value);
      }
    reader.readAsDataURL(f); // 이 코드 실행시 reader.onload 실행됨.
	});
}


/////////////////////////////////////////////////////////////content

const postBtn = document.getElementById('post');
const bookMarkBtn = document.getElementById('bookMark');
const taggedBtn = document.getElementById('tagged');

const param = 'uname=' +uname;

const postContentOut = document.getElementById('postContentOut');
const taggedContentOut = document.getElementById('taggedContentOut');

function clickme(){

	console.log("why are you click me?");
}

const addToContentOut  =  (postJoinImage, contentOut) => {
	

	
	const file = postJoinImage.pimg;
	
	let likeCnt = 0;
	let commentCnt = 0;
	
	likeManageList.forEach(function(likeManages){
		
		likeManages.forEach(function(likeManage){
			if(postJoinImage.pid == likeManage.pid) {
				likeCnt = likeCnt + 1;				
			}	
		});
		
	});
	
	commentManageList.forEach(function(commentManages){
		
		commentManages.forEach(function(commentManage){
			if(postJoinImage.pid == commentManage.pid) {
			commentCnt = commentCnt + 1;				
			}
		});
	});
	
	const newImg = document.createElement('img');
	newImg.src = file;
	
	const newDiv = document.createElement('div');
	newDiv.setAttribute('class', 'contentOutPost');
	
	const newTextDiv = document.createElement('div');
	newTextDiv.setAttribute('class', 'textDiv');
	
	const text = document.createElement('div');
	newTextDiv.setAttribute('class', 'divinText');
	
	text.innerHTML += '<i class="fas fa-heart"/>&nbsp&nbsp' + likeCnt + '&nbsp&nbsp&nbsp&nbsp';
	text.innerHTML +='<i class="fas fa-comment fa-flip-horizontal"></i>&nbsp&nbsp';
	text.innerHTML += commentCnt 
	 
	newDiv.appendChild(newImg);
	newTextDiv.appendChild(text);
	newDiv.appendChild(newTextDiv);
	contentOut.appendChild(newDiv);
	
	
	
	//const reader = new FileReader();
	
	//	reader.readAsDataURL(file);
	
	//reader.onload = function() {
		//const newDiv = document.createElement('div');	
		//newDiv.setAttribute('class', 'contentOutPost');
		//newDiv.style = `background : url(${reader.result});`
	//}
	
}

postJoinImageList.forEach(function(postJoinImage){
		addToContentOut(postJoinImage, postContentOut);
});	

taggedPostJoinImageList.forEach(function(taggedPostJoinImage){
		addToContentOut(taggedPostJoinImage, taggedContentOut);
});

function BtnEventListener(e) {
	
	let btn = postBtn; 
	
	try {
		btn = document.getElementById(e.target.id);
	} catch(error) {
		btn = postBtn
	}
	
	btnCssReset(postBtn);
	btnCssReset(bookMarkBtn);
	btnCssReset(taggedBtn);
	
	btn.style.color = "black";
	btn.style.borderTop = "1px solid black";
	
	if(btn == postBtn) {
		postContentOut.style.display = 'flex';
		taggedContentOut.style.display = 'none';	
	} else if(btn == taggedBtn) {
		postContentOut.style.display = 'none';
		taggedContentOut.style.display = 'flex';	
	}
	
			
}

postBtn.addEventListener('click', BtnEventListener);
bookMarkBtn.addEventListener('click', BtnEventListener);
taggedBtn.addEventListener('click', BtnEventListener);

function btnCssReset(btn) {
	btn.style.color = "gray";
	btn.style.borderTop = "gray";
	
}














