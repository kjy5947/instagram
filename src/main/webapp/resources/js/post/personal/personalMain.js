


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
		

