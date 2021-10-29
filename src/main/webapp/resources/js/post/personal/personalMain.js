function popup(obj){
   var op = document.getElementsByClassName(obj)[0];
   op.style.display = "flex";   
   
   console.log("hello info");
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
	    console.log("지금 잘되고 있는거 맞냐?");
	
		
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


function profileEdit(){
   
   console.log("hello info");
   var strr = window.location.href;
   console.log(" is this OK?" + strr);
   var params = strr.indexOf("home");
 	var xx = strr.substring(params+4);
 	location.replace("/instagram/users" + xx);
}


function clickme(){

   console.log("why are you click me?");
}


/////////////////////////////////////////////////////////////Content

const postBtn = document.getElementById('post');
const bookMarkBtn = document.getElementById('bookMark');
const taggedBtn = document.getElementById('tagged');

const postContentOut = document.getElementById('postContentOut');
const taggedContentOut = document.getElementById('taggedContentOut');


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
	
	text.innerHTML += '<i class="fas fa-heart"/>&nbsp&nbsp' + likeCnt + '&nbsp&nbsp&nbsp&nbsp';
	text.innerHTML +='<i class="fas fa-comment fa-flip-horizontal"></i>&nbsp&nbsp';
	text.innerHTML += commentCnt 
	
	newDiv.appendChild(newImg);
	newTextDiv.appendChild(text);
	
	newDiv.appendChild(newTextDiv);
	contentOut.appendChild(newDiv);
	
	
	newDiv.addEventListener('click', (e) => {
		popupDiv.classList.remove('hide')
		showSlides(1);
	});
	
	
	
	
	// create post popup
	
	const popupDiv = document.createElement('div');
	popupDiv.setAttribute('id', 'popupWrapper' + postJoinImage.pid);
	popupDiv.setAttribute('class', 'hide');
	
	const popupContainer = document.createElement('div');
	popupContainer.setAttribute('class', 'popupContainer');
	
	const popupSlider = document.createElement('div');
	popupSlider.setAttribute('class', 'popupSilder');
	
	let imageLength = 0;
	
	imagesList.forEach(function(images){
		images.forEach(function(image) {
			if(image.pid == postJoinImage.pid) {
					const imgWrap = document.createElement('div');
					imgWrap.setAttribute('class', 'imgWrap');
					
					const popupimg = document.createElement('img');
					popupimg.src = image.pimg;
					
					imgWrap.appendChild(popupimg);
					popupSlider.appendChild(imgWrap);
					imageLength++;
			}
			
		});
	});
	
	popupContainer.appendChild(popupSlider);
	popupDiv.appendChild(popupContainer);
	

	const leftarrowBtn = document.createElement('div');
	const rightarrowBtn = document.createElement('div');
	
	
	if(imageLength >= 2) {
		
		leftarrowBtn.setAttribute('class', 'leftarrowBtn');
		leftarrowBtn.innerHTML = '<i class="fas fa-chevron-circle-left"></i>';
	
		rightarrowBtn.setAttribute('class', 'rightarrowBtn');
		rightarrowBtn.innerHTML = '<i class="fas fa-chevron-circle-right"></i>';
	
		popupSlider.appendChild(leftarrowBtn);
		popupSlider.appendChild(rightarrowBtn)
	}
	
	
	// POPUP COMMNET
	
	const popupCommentContainer = document.createElement('div');
	popupCommentContainer.setAttribute('class', 'popupCommentContainer');
	// popup comment userInfo
	const postingUser = document.createElement('div');
	postingUser.setAttribute('class', 'postingUser');
	// userImg
	const userImg = document.createElement('img');
	userImg.src = userProfileImg;	
	postingUser.appendChild(userImg);
	// user name
	const postingUname = document.createElement('div');
	postingUname.setAttribute('class', 'postingUname');
	postingUname.innerHTML = "<a href='"+window.location.protocol+ "//" +window.location.host +"/insta/post/personal?uname=" + uname + "'>" + uname +"</a>&nbsp&nbsp";
	
	
	//follow Button
	
	postingUname.innerHTML += "•";
	
	const followBtn = document.createElement('button');
	followBtn.setAttribute('id', 'followBtn' + postJoinImage.pid);
	
	// followBtn decide
	const followBtnDecideXhttp = new XMLHttpRequest();			
	followBtnDecideXhttp.addEventListener('readystatechange', (e) => {
		const readyState = e.target.readyState;
		const httpStatus = e.target.status;
		
		if(readyState == 4 && httpStatus == 200) {
			const followList =  JSON.parse(e.target.responseText);
			if(followList.length >= 1) {
				followBtn.innerHTML = "팔로잉";
				followBtn.setAttribute('class', 'following');
			} else {
				followBtn.innerHTML = "팔로우";
			}
		}
	});
		
	followBtnDecideXhttp.open('POST', '/insta/postRest/FollowDecide', true);

	followBtnDecideXhttp.setRequestHeader('content-type', 'application/json;charset=UTF-8');
	
	const follow = {
		fid: null,
		// cookie user_id
		from_user: loginUserId,
		to_user: userId,
		follow_time: null,
		follow_condition : null
	}
		
	followBtnDecideXhttp.send(JSON.stringify(follow));
	
	
	postingUname.appendChild(followBtn)
	postingUser.appendChild(postingUname);
	
	popupCommentContainer.appendChild(postingUser);
	
	// popup comments
	const postComments = document.createElement('ul');
	postComments.setAttribute('class', 'postComments');
	
	postComments.style.listStyle = 'none';
	// userImg
	const postCommentsOwn = document.createElement('li');
	postCommentsOwn.setAttribute('class', 'postCommentsLi');
	const userImg2 = document.createElement('img');
	userImg2.src = userProfileImg;
	postCommentsOwn.appendChild(userImg2);
	// username + comment
	const postingUnameComment = document.createElement('div');
	postingUnameComment.setAttribute('class', 'postingUnameComment');
	postingUnameComment.innerHTML = "<a href='"+window.location.protocol+ "//" +window.location.host +"/insta/post/personal?uname=" + uname + "'>" + uname +"</a>&nbsp&nbsp" +postJoinImage.pcontents;
	postCommentsOwn.appendChild(postingUnameComment);
	
	postComments.appendChild(postCommentsOwn);
	
	// otheruser comments
	
	commentManageList.forEach(function(commentManages) {
		commentManages.forEach(function(commentManage) {
			if(commentManage.pid == postJoinImage.pid) {
				const xhttp = new XMLHttpRequest();			
				xhttp.addEventListener('readystatechange', (e) => {
					const readyState = e.target.readyState;
					const httpStatus = e.target.status;
					
					if(readyState == 4 && httpStatus == 200) {
						const commentUser =  JSON.parse(e.target.responseText);
						
						// add other user img 
						const otherUserComment = document.createElement('li');
						otherUserComment.setAttribute('class', 'otherUserComment');
						const otherUserImg = document.createElement('img');
						otherUserImg.src = commentUser.profile_img;
						otherUserComment.appendChild(otherUserImg);
						
						// add other user name + comment
						const otherUserUnameComment = document.createElement('div');
						otherUserUnameComment.setAttribute('class', 'otherUserUnameComment');
						otherUserUnameComment.innerHTML = "<a href='"+window.location.protocol+ "//" +window.location.host +"/insta/post/personal?uname=" + commentUser.uname + "'>" + commentUser.uname +"</a>&nbsp&nbsp" + commentManage.contents;
						otherUserComment.appendChild(otherUserUnameComment);
	
						postComments.appendChild(otherUserComment);
					}
						
				});
				xhttp.open('POST', '/insta/postRest/commentGetUser', true);
				xhttp.setRequestHeader('content-type', 'application/json;charset=UTF-8');
				xhttp.send(JSON.stringify(commentManage));
			}
		});
	});
	
	
	popupCommentContainer.appendChild(postComments);
	
	// comment footer
	const commentFooter = document.createElement('div');
	commentFooter.setAttribute('class', 'commentFooter');
	
	const viewLikeCnt = document.createElement('div');
	viewLikeCnt.setAttribute('class', 'viewLikeCnt');
	viewLikeCnt.innerHTML = "좋아요 &nbsp;" + likeCnt + "개"
	
	const leaveCommentDiv = document.createElement('div');
	leaveCommentDiv.setAttribute('class', 'leaveCommentDiv');
	
	const leaveComment = document.createElement('input');
	leaveComment.setAttribute('class', 'leaveComment');
	leaveComment.setAttribute('type', 'text');
	leaveComment.setAttribute('placeholder', '댓글 달기...');
	
	
	
	const leaveCommentBtn = document.createElement('button');
	leaveCommentBtn.setAttribute('class', 'leaveCommentBtn');
	leaveCommentBtn.setAttribute('type', 'button');
	leaveCommentBtn.disabled = true;
	leaveCommentBtn.innerHTML = "게시"
	
	commentFooter.appendChild(viewLikeCnt);
	leaveCommentDiv.appendChild(leaveComment);
	leaveCommentDiv.appendChild(leaveCommentBtn);
	
	commentFooter.appendChild(leaveCommentDiv);
	popupCommentContainer.appendChild(commentFooter)
	
	
	popupContainer.appendChild(popupCommentContainer);
	document.body.appendChild(popupDiv);
	
	// leave comment action 아무것도 입력 안하면 '게시' 버튼 비활성화 
	leaveComment.onkeyup = function() {
		 if(leaveComment.value=="") { 
            leaveCommentBtn.disabled =true;
        } else { 
			leaveCommentBtn.disabled = false;
        }
	}
	
	// 게시 버튼 누를시 액션 commentBtn action
	leaveCommentBtn.addEventListener('click', (e) => {
				const xhttp = new XMLHttpRequest();			
				xhttp.addEventListener('readystatechange', (e) => {
					const readyState = e.target.readyState;
					const httpStatus = e.target.status;
					
					if(readyState == 4 && httpStatus == 200) {
						const commentUser =  JSON.parse(e.target.responseText);
						
						// add other user img 
						const otherUserComment = document.createElement('li');
						otherUserComment.setAttribute('class', 'otherUserComment');
						const otherUserImg = document.createElement('img');
						otherUserImg.src = commentUser.profile_img;
						otherUserComment.appendChild(otherUserImg);
						
						// add other user name + comment
						const otherUserUnameComment = document.createElement('div');
						otherUserUnameComment.setAttribute('class', 'otherUserUnameComment');
						otherUserUnameComment.innerHTML = "<a href='"+window.location.protocol+ "//"+window.location.host +"/insta/post/personal?uname=" + commentUser.uname + "'>" + commentUser.uname +"</a>&nbsp&nbsp" + commentManage.contents;
						otherUserComment.appendChild(otherUserUnameComment);
	
						postComments.appendChild(otherUserComment);
					}
						
				});
				xhttp.open('POST', '/insta/postRest/leaveComment', true);
				xhttp.setRequestHeader('content-type', 'application/json;charset=UTF-8');
				
				const commentManage = {
					cid: null,
					pid: ''+postJoinImage.pid,
					user_id: ''+loginUserId,
					contents: ''+leaveComment.value
				};
				
				xhttp.send(JSON.stringify(commentManage));
				
				leaveComment.value = "";
	});
	
	// followBtn action
	followBtn.addEventListener("click", (e) => {
		const xhttp = new XMLHttpRequest();			
		xhttp.addEventListener('readystatechange', (e) => {
			const readyState = e.target.readyState;
			const httpStatus = e.target.status;
			
			if(readyState == 4 && httpStatus == 200) {
				if(followBtn.innerHTML == "팔로잉") {
					followBtn.innerHTML = "팔로우";
					followBtn.classList.remove('following');
				} else {
					followBtn.innerHTML = "팔로잉";
					followBtn.classList.add('following');
				}
				
			}
		});
		
		if(followBtn.innerHTML == "팔로우") {
			xhttp.open('POST', '/insta/postRest/addfollow', true);
		} else if(followBtn.innerHTML == "팔로잉") {
			xhttp.open('POST', '/insta/postRest/deleteFollow', true);
		}
		xhttp.setRequestHeader('content-type', 'application/json;charset=UTF-8');
		
		const follow = {
			fid: null,
			// cookie user_id
			from_user: loginUserId,
			to_user: userId,
			follow_time: null,
			follow_condition : null
			}
			
			xhttp.send(JSON.stringify(follow));
		
	});
	
	
	
	// post popup slide action
	let slideIndex = 1;
	
	function showSlides(n) {
		let slides = document.getElementsByClassName("imgWrap");
		if (n > imageLength) {
			slideIndex = 1
		}    
 		if (n < 1) {
			slideIndex = imageLength
		}
 		for (i = 0; i < imageLength; i++) {
     		slides[i].style.display = "none";  
 		}
		slides[slideIndex-1].style.display = "flex";
	}
	
	function plusSlides(n){
    	showSlides(slideIndex += n);
	}
  
	
	leftarrowBtn.addEventListener('click', function () {
    	plusSlides(-1);
	});
	
	rightarrowBtn.addEventListener('click', function () {
    	plusSlides(1);
	});
	
	// 다른곳 클릭하면 팝업창 닫기
	
	document.addEventListener('mouseup', function(e) {	
    	if (!popupContainer.contains(e.target)) {
      		 popupDiv.classList.add('hide');
    	}
	});
	
	
	
	
	
	
	
	
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



      
