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
 		var fileInput = document.getElementById("userProfileImage");
 		fileInput.click();
	 
	   fileInput.addEventListener("change", (e) => {
	   
	      let f = e.target.files[0];

	      if (!f.type.match("image.*")) {
	         alert("이미지를 등록해야 합니다.");
	         return 0;
	      }
	    var editedForm = document.userProfileImageForm;
	     editedForm.enctype = "multipart/form-data";
	     editedForm.submit();
	   
	      // 사진 전송 성공시 이미지 변경
	      let reader = new FileReader();
	      var selectedImage = document.getElementById("basicUserProfileImage");
	      var editedfile = document.getElementById("userProfileImage");
	      reader.onload = (e) => {
	         selectedImage.setAttribute("src", e.target.result);
	         editedfile.setAttribute("value", e.target.result);
	         console.log(document.getElementById("userProfileImage").value);
	      }
	    reader.readAsDataURL(f); // 이 코드 실행시 reader.onload 실행됨.
	   });
	}


function profileEdit(){
   
	var strr = window.location.href;

	var params = strr.indexOf("home");
	var xx = strr.substring(params+4);
 	location.replace("/instagram/users" + xx);
}

function passwordEdit(){

	var fullUrl = window.location.href;

	var params = fullUrl.indexOf("home");
	var username = fullUrl.substring(params+4);
 	location.replace("/instagram/password" + username);
}


function clickme(){

   console.log("why are you click me?");
}

      
