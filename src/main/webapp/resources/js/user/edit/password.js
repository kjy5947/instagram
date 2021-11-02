
 
 
var idResult = false;
console.log("제대로 로딩됨");

function checkAll(){
    var joinBtn = document.getElementById('join-btn');
    var firstpwd = document.getElementById('firstPwd').value;
    var secondpwd = document.getElementById('secondPwd').value;

	if(document.getElementById('firstPwd').checkValidity() &&
	 document.getElementById('secondPwd').checkValidity() &&
	 (firstpwd === secondpwd)
	  ){
		joinBtn.disabled = false;
	} else {
		joinBtn.disabled = true;
	}
};

