/**
 * 
 */

var checkResult = document.getElementsByClassName("check")[0].checked;
var valv = document.getElementsByClassName("check")[0].getAttribute('id');
console.log("valv데스요 : " + valv);
if(document.getElementsByClassName("check")[0].getAttribute('id') == "Y"){
    document.getElementsByClassName("check")[0].checked = true;
}else{
    document.getElementsByClassName("check")[0].checked = false;
    
}

function moveMine(){

	var strr = window.location.href;

	var params = strr.indexOf("users");
	var xx = strr.substring(params+5);
 	location.replace("/insta/home" + xx);
}


function prfUpload(){

	console.log("파일 업로드!");
   var fileInput = document.getElementById("userProfileImage");
   fileInput.click();
   
   fileInput.addEventListener("change", (e)=>{
   
    /*
      let f = e.target.file[0];
      
     이미지파일로 안골랐을때에 처리내용
      if(!f.type.match("image.*")){
         alert("이미지를 등록해야 합니다.");
         return 0;
      }
      끝 
     */
        console.log("파일 업로드!1");
        var editedForm = document.userProfileImageForm;
        editedForm.enctype = "multipart/form-data";
        editedForm.submit();
        
        
        /* 사진 전송시 과정 */
	      let reader = new FileReader();
	      var selectedImage = document.getElementById("basicUserProfileImage");
	      var editedfile = document.getElementById("userProfileImage");
	      reader.onload = (e) => {
	         selectedImage.setAttribute("src", e.target.result);
	         editedfile.setAttribute("value", e.target.result);
	         console.log(document.getElementById("userProfileImage").value);
	         reader.readAsDataURL(f); // 이 코드 실행시 reader.onload 실행됨.
	      }
    });
}