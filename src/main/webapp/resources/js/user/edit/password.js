/*

 function checkId(){
    var uname = $('#uname').val();
    
    if(!document.getElementById('uname').checkValidity()){
	    $('.uname_already').css("display", "none");
	    idResult = false;
    } else {
    	$.ajax({
	        url:'/insta/idCheck', //Controller에서 인식할 주소
	        type:'post',
	        data:{uname:uname},
	        success:function(cnt){
	        	if(cnt < 1){ // 사용 가능한 아이디 
	                $('.uname_already').css("display", "none");
	                idResult = true;
	            } else { // 이미 존재하는 아이디
	                $('.uname_already').css("display","inline-block");
	                idResult = false;
	            }
	        },
	        error:function(){
	            alert("사용자 이름 확인 중 에러가 발생했습니다.");
	        }
	    });
    }
    checkAll();
};

 */
 
 
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

