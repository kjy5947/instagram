
  var btn = document.getElementById("login");
  var email = document.getElementById("email");

  var idcheck = false;
  var pwcheck = false;

  function idLengthCheck(text){
    if(text.value.length >= 1){
      btn.disabled = false;
      idcheck = true;
      if(idcheck && pwcheck){
        btn.style.backgroundColor = "dodgerblue";
        btn.style.cursor = "pointer";
      }
    }
    else {
      btn.style.backgroundColor = "skyblue";
      btn.disabled = "disabled";
      idcheck = false;
      btn.style.cursor = "Default";
    }


}

function pwLengthCheck(text){
  if(text.value.length >= 8){
    btn.disabled = false;
    pwcheck = true;
    if(idcheck && pwcheck){
      btn.style.backgroundColor = "dodgerblue";
      btn.style.cursor = "pointer";
    }
  }
  else {
    btn.style.backgroundColor = "skyblue";
    btn.disabled = "disabled";
    pwcheck = false;
    btn.style.cursor = "Default";
  }


}