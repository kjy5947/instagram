/**
 * 
 */
 const uname_input = document.getElementById('uname');
 uname_input.addEventListener('input', checkUnique);
 function checkUnique(e) {
     console.log(e.target.value);
 }