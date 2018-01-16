
function loadAccountDetailsUpdateView() {
	console.log("loadAccountDetailsUpdateView");
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById("view").innerHTML = xhr.responseText;
			document.getElementById("accountUserUpdateSubmitBtn").addEventListener("click", submitAccountDetailUpdate, false);
			loadUserDetails();
		}
	}
	xhr.open("GET", "ajaxAccountUpdate", true);
	xhr.send();
}

function submitAccountDetailUpdate() {
	let u_username = document.getElementById("accountUserUsernameInput").value;
	let u_firstname = document.getElementById("accountUserFirstnameInput").value;
	let u_lastname = document.getElementById("accountUserLastnameInput").value;
	let u_email = document.getElementById("accountUserEmailInput").value;

	if (u_username == "" || u_firstname == "" || u_lastname == "" || u_email == "" ) {
		alert("You left one or more required fields blank!");
		return;
	}
	
	let user = {
		username: u_username,
		firstname: u_firstname,
		lastname: u_lastname,
		email: u_email
	}
	user = JSON.stringify(user);
	console.log(user);
	
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			
		}
	}
	xhr.open("POST", "ajaxAccountUpdate", true);
	xhr.setRequestHeader("key", user);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(user);
	
	loadDashboardView(); //Defined in app.js
}

function loadUserDetails() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let json = JSON.parse(xhr.responseText);
			document.getElementById("accountUserUsernameInput").value = json.username;
			document.getElementById("accountUserFirstnameInput").value = json.firstname;
			document.getElementById("accountUserLastnameInput").value = json.lastname;
			document.getElementById("accountUserEmailInput").value = json.email;
		}
	}
	xhr.open("GET", "ajaxAccountInfo", true);
	xhr.send();
}
