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