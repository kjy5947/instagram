/**
 * 
 */

var checkResult = document.getElementsByClassName("check")[0].checked;
var valv = document.getElementsByClassName("check")[0].getAttribute('id');
console.log("valv데스요 : " + valv);
if(document.getElementsByClassName("check")[0].getAttribute('id') == "Y/"){
    document.getElementsByClassName("check")[0].checked = true;
}else{
    document.getElementsByClassName("check")[0].checked = false;
    
}


function profileUpload(){

	var fileInput = document.getElementById("userProfileImage");
	fileInput.click();
	
	fileInput.addEventListener("change", (e)=>{
	
		let f = e.target.file[0];
		
		if(!f.type.match("image.*")){
			alert("이미지를 등록해야 합니다.");
			return 0;
		}
		
		 var editedForm = document.userProfileImage;
		 editedForm.enctype = "multipart/form-data";
	     editedForm.submit();
	    });
}