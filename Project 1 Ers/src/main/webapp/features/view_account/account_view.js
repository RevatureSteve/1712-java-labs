
function loadAccountView() {
	console.log("loadAccountView");
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById("view").innerHTML = xhr.responseText;
			loadAccountDetails();
		}
	}
	xhr.open("GET", "ajaxAccount", true);
	xhr.send();
}

function loadAccountDetails() {
	console.log("loadAccountDetails");
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if(xhr.readyState == 4 && xhr.status == 200) {
			let json = JSON.parse(xhr.responseText);
			document.getElementById("accountUserUsername").innerHTML = json.username;
			document.getElementById("accountUserName").innerHTML = json.firstname + " " + json.lastname;
			document.getElementById("accountUserEmail").innerHTML = json.email;
			document.getElementById("accountUserUpdateBtn").addEventListener("click", loadAccountDetailsUpdateView, false);
		}
	}
	xhr.open("GET", "ajaxAccountInfo", true);
	xhr.send();
}
