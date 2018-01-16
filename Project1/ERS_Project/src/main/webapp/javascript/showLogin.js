/**
 * 
 */

showLogin();

function showLogin(){
	console.log('showing Login');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
			document.getElementById('loginDetails').innerHTML = xhr.responseText;
			//retrieveBankUserAccountInfo();
		}
	}
	xhr.open("GET", "showLogin", true);
	xhr.send();	
}


