
var selectedReimbursement;

function loadReimbursementsViewForManager() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById("view").innerHTML = xhr.responseText;
			document.getElementById("reimbursementStatusFilter").addEventListener("change", function () {
				selectedReimbursement = null;
				$("#receiptImg").hide();
				loadReimbursementsForManager();
			}, false);
			loadReimbursementsForManager();
			loadApproveDenyButtons(true);
			$("#receiptImg").hide();
		}
	}
	xhr.open("GET", "ajaxLoadManagerReimbursementsView", true);
	xhr.send();
}

function loadReimbursementsForManager(empl_id) {
	let id = empl_id;
	if (arguments.length == 0) id = "-1";
	console.log("loadReimbursements");
	clearReimbursements();
	clearResolvedHeaders();
	
	let status = document.getElementById("reimbursementStatusFilter").value;

	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if(xhr.readyState == 4 && xhr.status == 200) {
			let json = JSON.parse(xhr.responseText);
			json = filterByStatus(json, status);
			if (status != "Pending") {
				loadTableHeadersForResolved();
				loadApproveDenyButtons(true);
				$("#approveDenyButtons").hide();
				selectedReimbursement = null;
				$("#receiptImg").hide();
			}
			else {
				if (selectedReimbursement == null) loadApproveDenyButtons(true);
				$("#approveDenyButtons").show();
			}
			for(let i = 0; i < json.length; i++) {
				let re = json[i];
				populateManagerReimbursementTable(re);
			}
		}
	}
	xhr.open("GET", `ajaxAllReimbursementsInfo?empl_id=${id}`, true);
	xhr.send();
}

function populateManagerReimbursementTable(re) {
	let tr = document.createElement("tr");
	let tdAmount = document.createElement("td");
	let tdType = document.createElement("td");
	let tdDescription = document.createElement("td");
	let tdSubmitted = document.createElement("td");
	let tdSubmittedBy = document.createElement("td");
	tdAmount.innerHTML = re.amount;
	tdType.innerHTML = re.type;
	tdDescription.innerHTML = re.description;
	tdSubmitted.innerHTML = re.submitted;
	let author = re.author;
	tdSubmittedBy.innerHTML = `${author.firstname} ${author.lastname}`;
	tr.appendChild(tdAmount);
	tr.appendChild(tdType);
	tr.appendChild(tdDescription);
	tr.appendChild(tdSubmitted);
	tr.appendChild(tdSubmittedBy);
	if (document.getElementById("reimbursementStatusFilter").value != "Pending") {
		let tdResolved = document.createElement("td");
		let tdResolver = document.createElement("td");
		let tdStatus = document.createElement("td");
		tdResolved.innerHTML = re.resolved;
		tdResolver.innerHTML = `${re.resolver.firstname} ${re.resolver.lastname}`;
		tdStatus.innerHTML = re.status;
		tr.appendChild(tdResolved);
		tr.appendChild(tdResolver);
		tr.appendChild(tdStatus);
	}
	tr.class="clickable-row";
	tr.addEventListener("click", function () { 
		  	$(this).addClass('active').siblings().removeClass('active');
//			if (re.status == "pending") {
				console.log("re.status = " + re.status);
				selectedReimbursement = re; 
//			}
			loadApproveDenyButtons(false);
			$("#receiptImg").show();
			loadReceiptImage();
		}, false);
	document.getElementById("reimbursementTable").appendChild(tr);
}

function loadTableHeadersForResolved() {
	let headerCols = document.getElementById("managerViewAllReimbursementsTableHeader");
	let thResolved = document.createElement("th");
	let thResolver = document.createElement("th");
	let thStatus = document.createElement("th");
	thResolved.innerHTML = "Date Resolved";
	thResolver.innerHTML = "Resolved By";
	thStatus.innerHTML = "Status";
	thResolved.id = "managerReimbursementsView_thResolved";
	thResolver.id = "managerReimbursementsView_thResolver";
	thStatus.id = "managerReimbursementsView_thStatus";
	thResolved.scope = "col";
	thResolver.scope = "col";
	thStatus.scope = "col";
	console.log(thResolved.scope);
	headerCols.appendChild(thResolved);
	headerCols.appendChild(thResolver);
	headerCols.appendChild(thStatus);
}

function clearResolvedHeaders() {
	$("#managerReimbursementsView_thResolved").remove();
	$("#managerReimbursementsView_thResolver").remove();
	$("#managerReimbursementsView_thStatus").remove();
}

function loadApproveDenyButtons(disable) {
	let approveBtn = document.getElementById('mngrReimbursementViewApproveBtn');
	let denyBtn = document.getElementById('mngrReimbursementViewDenyBtn');
	approveBtn.disabled = disable;
	denyBtn.disabled = disable;
	approveBtn.addEventListener("click", approveRequest, false);
	denyBtn.addEventListener("click", denyRequest, false);
}

function approveRequest() {
	console.log("approveRequest called");
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById("view").innerHTML = xhr.responseText;
			loadReimbursementsViewForManager();
		}
	}
	let re_id = selectedReimbursement.id;
	xhr.open("GET", `ajaxResolveRequest?approve=true&re_id=${re_id}`);
	xhr.send();
}

function denyRequest() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById("view").innerHTML = xhr.responseText;
			loadReimbursementsViewForManager();
		}
	}
	let re_id = selectedReimbursement.id;
	xhr.open("GET", `ajaxResolveRequest?approve=false&re_id=${re_id}`);
	xhr.send();
}

function loadReceiptImage() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let json = JSON.parse(xhr.responseText);
			let img = document.getElementById("receiptImg");
			img.src = `data:${json.mimetype};base64,${json.value}`;
		}
	}
	xhr.open("GET", `ajaxLoadReceipt?id=${selectedReimbursement.id}`, true);
	xhr.send();
}





