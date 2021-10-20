/**
 * 
 */
 function checkId(){
    var uname = $('#uname').val(); //id값이 "id"인 입력란의 값을 저장
    console.log(document.getElementById('uname').checkValidity());
    document.getElementById('uname').validity = false;
    $('#uname').addClass(":invalid");
    const regex = /^[a-z0-9_]+$/;
    if(!regex.test(uname)){
    	console.log("pattern에 걸림: " + regex.test(uname));
    	$('.pattern_failed').css("display","inline-block");
	    $('.uname_already').css("display","inline-block");
    } else {
    	$('.pattern_failed').css("display","none");
    	$.ajax({
	        url:'/insta/idCheck', //Controller에서 인식할 주소
	        type:'post', //POST 방식으로 전달
	        data:{uname:uname},
	        success:function(cnt){
	        	console.log("cnt: " + cnt);
	        	console.log("cnt < 1: " + (cnt < 1));
	        	if(cnt < 1){ //cnt가 1이 아니면(=0일 경우) -> 사용 가능한 아이디 
	                $('.uname_already').css("display", "none");
	            } else { // cnt가 1일 경우 -> 이미 존재하는 아이디
	                $('.uname_already').css("display","inline-block");
	            }
	        },
	        error:function(){
	            alert("에러입니다");
	        }
	    });
    }
    // .form-control.is-valid, .was-validated .form-control:valid
    // .form-control.is-invalid, .was-validated .form-control:invalid
};

/* 					$('#uname').removeClass("form-control.is-invalid");
	                $('#uname').addClass("form-control.is-valid");
	                $('#uname').removeClass("form-control:invalid");
	                $('#uname').addClass("form-control:valid");
	                
	                $('#uname').removeClass("form-control.is-valid");
	                $('#uname').addClass("form-control.is-invalid");
	                $('#uname').removeClass("form-control:valid");
	                $('#uname').addClass("form-control:invalid");
	                */