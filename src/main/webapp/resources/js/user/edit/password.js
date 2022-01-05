
var str = window.location.href;
console.log(window.location.origin);
console.log(str.substring(0, 36));
console.log(str.substring(37, str.length));
// username뽑기
console.log(str.indexOf('password')); 

var url = location.origin + '/insta/home/' + str.substring(37, str.length);

window.onpopstate = function(e){

}

history.pushState(null,null,str.substring(37, str.length));
history.back();
//
//console.log("내 이동할 url" + url);
//history.pushState(null, null, url);


 
console.log(window.location.href);
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

