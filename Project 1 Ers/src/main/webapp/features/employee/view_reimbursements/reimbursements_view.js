
function loadReimbursementsViewForEmployee() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById("view").innerHTML = xhr.responseText;
			document.getElementById("reimbursementStatusFilter").value="Pending";
			loadReimbursements();
		}
	}
	xhr.open("GET", "ajaxReimbursements", true);
	xhr.send();
}

function loadReimbursements() {
	console.log("loadReimbursements");
	clearReimbursements();
	
	let status = document.getElementById("reimbursementStatusFilter").value;

	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if(xhr.readyState == 4 && xhr.status == 200) {
			let json = JSON.parse(xhr.responseText);
			json = filterByStatus(json, status);
			for(let i = 0; i < json.length; i++) {
				let re = json[i];
				populateEmployeeReimbursementTable(re);
			}
		}
	}
	xhr.open("GET", "ajaxReimbursementInfo", true);
	xhr.send();
}

function populateEmployeeReimbursementTable(re) {
	let tr = document.createElement("tr");
	let tdAmount = document.createElement("td");
	let tdType = document.createElement("td");
	let tdDescription = document.createElement("td");
	let tdSubmitted = document.createElement("td");
	let tdStatus = document.createElement("td");
	tdAmount.innerHTML = re.amount;
	tdType.innerHTML = re.type;
	tdDescription.innerHTML = re.description;
	tdSubmitted.innerHTML = re.submitted;
	tdStatus.innerHTML = re.status;
	tr.appendChild(tdAmount);
	tr.appendChild(tdType);
	tr.appendChild(tdDescription);
	tr.appendChild(tdSubmitted);
	tr.appendChild(tdStatus);
	document.getElementById("reimbursementTable").appendChild(tr);
}

function clearReimbursements() {
	let tbl = document.getElementById("reimbursementTable");
	while(tbl.firstChild) {
		tbl.removeChild(tbl.firstChild);
	}
}

function filterByStatus(lst, status) {
	let filtered = [];
	for (let i = 0; i < lst.length; i++) {
		let re = lst[i];
		if (statusMatch(status, re.status)) filtered.push(re);
	}
	return filtered;
}

function statusMatch(s1, s2) {
	s1 = s1.toLowerCase();
	s2 = s2.toLowerCase();
	if (s1 == "all" || s2 == "all") return true;
	if (s1 == "resolved") return (s2 == "approved" || s2 == "denied");
	if (s2 == "resolved") return (s1 == "approved" || s1 == "denied");
	return s1 == s2;
	
}
