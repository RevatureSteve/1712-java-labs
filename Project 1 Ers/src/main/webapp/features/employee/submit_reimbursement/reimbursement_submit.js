
function loadSubmitReimbursementView() {
	console.log("loadSubmitReimbursementView")
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById("view").innerHTML = xhr.responseText;
			document.getElementById("reimbursementReceiptUpload").addEventListener("change", handleFileSelect, false);
			$("#reimbursementReceiptImg").hide();
		}
	}
	xhr.open("GET", "ajaxSubmitReimbursementRequest", true);
	xhr.send();
}

function submitReimbursement() {
	console.log("submitReimbursement")
	let reAmt = document.getElementById("reimbursementAmtInput").value;
	let reType = document.getElementById("reimbursementTypeInput").value;
	let reDesc = document.getElementById("reimbursementDescInput").value;
	console.log(reAmt);
	
	if (reDesc.length > 100) {
		alert("Description must not exceed 100 characters.");
		return;
	}
	
	if (reAmt == "" || reDesc == "") {
		alert("You left one or more required fields blank!");
		return;
	}
	
	let formData = new FormData();
	formData.append("amount", reAmt);
	formData.append("type", reType);
	formData.append("description", reDesc);
	
	for (let k of formData.keys()) {
		console.log(k);
	}
	
	let reReceipt = document.getElementById("reimbursementReceiptUpload").files[0];
	if (reReceipt != null) {
		console.log("an image has been selected")
		formData.append("receipt", reReceipt);
	}

	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById("view").innerHTML = xhr.responseText;
			document.getElementById("reimbursementStatusFilter").value = "Pending";
			loadReimbursements();
		}
	}
	xhr.open("POST", "ajaxSubmitReimbursementRequest", true);
	xhr.send(formData);
}

// Adapted from:
// http://www.onlywebpro.com/2012/01/24/create-thumbnail-preview-of-images-using-html5-api/
function handleFileSelect(evt) {
    let files = evt.target.files;
    let f = files[0];
    let reader = new FileReader();
    reader.onload = function(e) {
    	$('#reimbursementReceiptImg')
    		.attr('src',	 e.target.result)
    		.width(150)
    		.height(200)
    		.show();
       };
    reader.readAsDataURL(f);
}

function uploadReceipt() {
	let files = document.getElementById("reimbursementReceiptUpload").files;
	let f = files[0];
	let formData = new FormData();
	formData.append("file", f);
	console.log(formData);
	
	$.ajax({
	    data: formData,
	    url: 'ajaxUploadReceipt',
	    type: 'post',
	    processData: false,
	    contentType: false,
	    success:function (data) {
			document.getElementById("receiptImageTest").src= data.fileUrl;
	    }
	});
}



