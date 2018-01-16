/**
 * 
 */

window.onload = function () {
	loadNavBar();
	loadDashboardView();
	loadFooter();
}

function loadNavBar() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('navbar').innerHTML = xhr.responseText;
		}
	}
	xhr.open("GET", "ajaxNavbar?r=" + new Date().getTime(), true);
	xhr.send();
}

function loadDashboardView() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;
			loadGreeting();
		}
	}
	xhr.open("GET", "ajaxDashboard?r=" + new Date().getTime(), true);
	xhr.send();
}

function loadGreeting() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange= function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let json = JSON.parse(xhr.responseText);
			document.getElementById('greetingUsername').innerHTML = json.username;
		}
	}
	xhr.open("GET", "ajaxAccountInfo", true);
	xhr.send();
}    

function loadFooter() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById("footer").innerHTML = xhr.responseText;
		}
	}
	xhr.open("GET", "ajaxLoadFooter?r=" + new Date().getTime(), true);
	xhr.send();
}

function logoutUser() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log("Logging user out");
		}
	}
	xhr.open("POST", "logout", true);
	xhr.send();
}
