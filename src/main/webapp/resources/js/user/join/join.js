/**
 * 
 */
 function checkId(){
    var uname = $('#uname').val();
    var joinBtn = document.getElementById('join-btn');
    
    if(!document.getElementById('uname').checkValidity()){
	    $('.uname_already').css("display","inline-block");
    } else {
    	$.ajax({
	        url:'/insta/idCheck', //Controller에서 인식할 주소
	        type:'post',
	        data:{uname:uname},
	        success:function(cnt){
	        	if(cnt < 1){ // 사용 가능한 아이디 
	                $('.uname_already').css("display", "none");
    				joinBtn.disabled = false;
	            } else { // 이미 존재하는 아이디
	                $('.uname_already').css("display","block");
    				joinBtn.disabled = true;
	            }
	        },
	        error:function(){
	            alert("사용자 이름 확인 중 에러가 발생했습니다.");
	        }
	    });
    }
};