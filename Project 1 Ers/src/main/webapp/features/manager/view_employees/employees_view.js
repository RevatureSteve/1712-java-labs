
var selectedEmployee;

function loadEmployeesViewForManager() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById("view").innerHTML = xhr.responseText;
			loadEmployees();
		}
	}
	xhr.open("GET", "ajaxLoadEmployees", true);
	xhr.send();
}

function loadEmployees() {
	console.log("loadEmployees");
	clearEmployees();

	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if(xhr.readyState == 4 && xhr.status == 200) {
			let json = JSON.parse(xhr.responseText);
			for(let i = 0; i < json.length; i++) {
				let empl = json[i];
				populateEmployeeTable(empl);
			}
		}
	}
	xhr.open("GET", "ajaxEmployeeInfo", true);
	xhr.send();
}

function populateEmployeeTable(empl) {
	let tr = document.createElement("tr");
	let tdFirstname = document.createElement("td");
	let tdLastname = document.createElement("td");
	let tdEmail = document.createElement("td");
	tdFirstname.innerHTML = empl.firstname;
	tdLastname.innerHTML = empl.lastname;
	tdEmail.innerHTML = empl.email;
	tr.appendChild(tdFirstname);
	tr.appendChild(tdLastname);
	tr.appendChild(tdEmail);
	tr.class="clickable-row";
	tr.addEventListener("click", function () { 
		$(this).addClass('active').siblings().removeClass('active');
		selectedEmployee = empl; 
		loadReimbursementsViewForManagerFilterByEmployee(empl);
	}, false);
	document.getElementById("employeeTableBody").appendChild(tr);
}

function clearEmployees() {
	console.log("clearEmployees");
	let tbl = document.getElementById("employeeTableBody");
	while(tbl.firstChild) {
		tbl.removeChild(tbl.firstChild);
	}
}

function loadReimbursementsViewForManagerFilterByEmployee(empl) {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById("employeeManagerViewReimbursementDisplay").innerHTML = xhr.responseText;
			document.getElementById("reimbursementStatusFilter").removeEventListener("change", loadReimbursementsForManager, false);
			document.getElementById("reimbursementStatusFilter").addEventListener("change", function () {
				loadReimbursementsForManager(empl.id);
			}, false);
			loadReimbursementsForManager(empl.id);
			document.getElementById("mngrReimbursementViewApproveBtn").addEventListener("click", function () {
				document.getElementById("mngrReimbursementViewApproveBtn").removeEventListener("click", approveRequest, false);
				approveRequestFromEmployeeView(empl);
			}, false);
			document.getElementById("mngrReimbursementViewDenyBtn").addEventListener("click", function () {
				document.getElementById("mngrReimbursementViewDenyBtn").removeEventListener("click", denyRequest, false);
				denyRequestFromEmployeeView(empl);
			}, false);
			
		}
	}
	xhr.open("GET", "ajaxLoadManagerReimbursementsView", true);
	xhr.send();
}

function approveRequestFromEmployeeView(empl) {
	console.log("approveRequestFromEmployeeView called");
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			loadReimbursementsViewForManagerFilterByEmployee(empl);
		}
	}
	let re_id = selectedReimbursement.id;
	xhr.open("GET", `ajaxResolveRequest?approve=true&re_id=${re_id}`);
	xhr.send();
}

function denyRequestFromEmployeeView(empl) {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			loadReimbursementsViewForManagerFilterByEmployee(empl);
		}
	}
	let re_id = selectedReimbursement.id;
	xhr.open("GET", `ajaxResolveRequest?approve=false&re_id=${re_id}`);
	xhr.send();
}

