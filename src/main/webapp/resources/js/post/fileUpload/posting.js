/**
 * 
 */
const btnFileUpload = document.getElementById('fileBtn');
btnFileUpload.addEventListener('click',function (e){
	console.log("check here");
    $('input[type=file]').trigger('click');
});
$(document).ready(function(){
var objDragAndDrop = $(".dragAndDropDiv");

$(document).on("dragenter",".dragAndDropDiv",function(e){
    e.stopPropagation();
    e.preventDefault();
    $(this).css('border', '2px solid #0B85A1');
});
$(document).on("dragover",".dragAndDropDiv",function(e){
    e.stopPropagation();
    e.preventDefault();
});
$(document).on("drop",".dragAndDropDiv",function(e){
    
    $(this).css('border', '2px dotted #0B85A1');
    e.preventDefault();
    var files = e.originalEvent.dataTransfer.files;
    console.log("진입1");
    addPostByUser();
    handleFileUpload(files,objDragAndDrop);
});

$(document).on('dragenter', function (e){
    e.stopPropagation();
    e.preventDefault();
});
$(document).on('dragover', function (e){
    e.stopPropagation();
    e.preventDefault();
    objDragAndDrop.css('border', '2px dotted #0B85A1');
});
$(document).on('drop', function (e){
    e.stopPropagation();
    e.preventDefault();
});

$('input[type=file]').on('change', function(e) {
    var files = e.originalEvent.target.files;
    console.log("진입2");
    addPostByUser();
    handleFileUpload(files,objDragAndDrop);
});

function handleFileUpload(files,obj)
{

    console.log("진입3");
    for (var i = 0; i < files.length; i++) 
    {
        var fd = new FormData();
        fd.append('file', files[i]);
    
        var status = new createStatusbar(obj); //Using this we can set progress.
        status.setFileNameSize(files[i].name,files[i].size);
        sendFileToServer(fd,status);
    
    }
    
	// content popup  
	
	let modalBody = document.getElementById("modalBody");
	modalBody.style.display = 'none';

	let statusbar = document.getElementsByClassName("statusbar odd");
    statusbar[0].style.display = 'none';

	let btn_close = document.getElementsByClassName("btn-close");
    btn_close[0].style.display = 'none';
	
	let shareBtn = document.getElementsByClassName("shareBtn");
    shareBtn[0].style.display = 'block';
	
	let ImgContentsModal = document.getElementById("ImgContentsModal");
	ImgContentsModal.style.display = "flex";
	
	
	const xhttp = new XMLHttpRequest();			
		xhttp.addEventListener('readystatechange', (e) => {
			const readyState = e.target.readyState;
			const httpStatus = e.target.status;
			
			if(readyState == 4 && httpStatus == 200) {
			
				let pidUsermap = JSON.parse(e.target.responseText);
				
				const user = pidUsermap["user"];
				const postJoinImage = pidUsermap["postJoinImage"];
				console.log(postJoinImage);

				const contentImg = document.getElementById("contentImg");
				
				const img = document.createElement('img')
				img.src = postJoinImage.pimg;
				console.log(postJoinImage.pimg);
				
				
				const contentUserInfo = document.getElementById("contentUserInfo");
				const userimg = document.createElement('img')
				userimg.src = user.profile_img;
				
				const contentUname = document.createElement('div')
				contentUname.setAttribute('class', "contentUname");
				contentUname.innerHTML = "<a href='"+window.location.protocol+ "//" +window.location.host +"/insta/post/personal?uname=" + user.uname + "'>" + user.uname +"</a>&nbsp&nbsp";
				
				const contentArea = document.getElementById("contentArea");
				const textArea = document.createElement('textarea')
				textArea.setAttribute('id', 'contentTextArea');
				textArea.setAttribute('placeholder', '문구 입력...');
				textArea.setAttribute('autocomplete', 'off');
				
				contentImg.appendChild(img);
				
				contentUserInfo.appendChild(userimg);
				contentUserInfo.appendChild(contentUname);
				
				contentArea.appendChild(textArea);
			};
		});
	
		xhttp.open('POST', '/insta/fileUploadRest/postingImages' , true);

		xhttp.setRequestHeader('content-type', 'application/json;charset=UTF-8');		
		
		xhttp.send();
		
		
};

var rowCount=0;
function createStatusbar(obj){
        
    rowCount++;
    var row="odd";
    if(rowCount %2 ==0) row ="even";
    this.statusbar = $("<div class='statusbar "+row+"'></div>");
    this.filename = $("<div class='filename'></div>").appendTo(this.statusbar);
    this.size = $("<div class='filesize'></div>").appendTo(this.statusbar);
    this.progressBar = $("<div class='progressBar'><div></div></div>").appendTo(this.statusbar);
    this.abort = $("<div class='abort'>중지</div>").appendTo(this.statusbar);
    
    obj.after(this.statusbar);
    
    this.setFileNameSize = function(name,size){
        var sizeStr="";
        var sizeKB = size/1024;
        if(parseInt(sizeKB) > 1024){
            var sizeMB = sizeKB/1024;
            sizeStr = sizeMB.toFixed(2)+" MB";
        }else{
            sizeStr = sizeKB.toFixed(2)+" KB";
        }
    
        this.filename.html(name);
        this.size.html(sizeStr);
    }
    
    this.setProgress = function(progress){       
        var progressBarWidth =progress*this.progressBar.width()/ 100;  
        this.progressBar.find('div').animate({ width: progressBarWidth }, 10).html(progress + "% ");
        if(parseInt(progress) >= 100)
        {
            this.abort.hide();
        }
    }
    
    this.setAbort = function(jqxhr){
        var sb = this.statusbar;
        this.abort.click(function()
        {
            jqxhr.abort();
            sb.hide();
        });
    }
}

function sendFileToServer(formData,status)
{
    console.log("진입4");
    var uploadURL = "/insta/fileUpload/post"; //Upload URL
    var extraData ={}; //Extra Data.
    var jqXHR=$.ajax({
            xhr: function() {
            var xhrobj = $.ajaxSettings.xhr();
            if (xhrobj.upload) {
                    xhrobj.upload.addEventListener('progress', function(event) {
                        var percent = 0;
                        var position = event.loaded || event.position;
                        var total = event.total;
                        if (event.lengthComputable) {
                            percent = Math.ceil(position / total * 100);
                        }
                        //Set progress
                        status.setProgress(percent);
                    }, false);
                }
            return xhrobj;
        },
        url: uploadURL,
        type: "POST",
        contentType:false,
        processData: false,
        cache: false,
        data: formData,
        success: function(data){
            status.setProgress(100);
    
            //$("#status1").append("File upload Done<br>");           
        }
    }); 
    
    status.setAbort(jqXHR);
    
}


function addPostByUser(){
	$.ajax({
		url : "/insta/fileUpload/addPosting",
		type : "POST"
	})
}
});

const shareBtn = document.getElementById("shareBtn");

shareBtn.addEventListener('click', () => {
	let contentTextArea = document.getElementById("contentTextArea").value;
	
	const xhttp = new XMLHttpRequest();			
		xhttp.addEventListener('readystatechange', (e) => {
			const readyState = e.target.readyState;
			const httpStatus = e.target.status;
			
			if(readyState == 4 && httpStatus == 200) {
				const contentDiv = document.getElementById("contentDiv");
				const postCompleted = document.getElementById("postCompleted");
				
				contentDiv.styled.display = "none";
				postCompleted.styled.display = "flex";
			};
		});
	
		xhttp.open('POST', '/insta/fileUploadRest/posting' , true);

		xhttp.setRequestHeader('content-type', 'application/json;charset=UTF-8');
		
		const postsupport = {
			user_id : userId,
			pid : pid,
			content : contentTextArea
		}
		
		
		xhttp.send(JSON.stringify(postsupport));
});


