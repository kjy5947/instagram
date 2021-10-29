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

      
