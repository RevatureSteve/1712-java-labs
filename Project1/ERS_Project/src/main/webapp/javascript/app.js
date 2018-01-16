/**
 * ERS app javascript
 */

window.onload = function(){
	//addScript('features/dashboard/dashboard.js');
	loadNavbar();
	//loadImageSelectView();
	loadAppView();
//	loadInfo();
	
}

function loadNavbar(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
			
			document.getElementById('navbar').innerHTML = xhr.responseText;//places xhr's responsetext in the navbar element
			
			let navXhr = new XMLHttpRequest();
			navXhr.onreadystatechange = function() {
				if(navXhr.readyState == 4 && navXhr.status == 200){
					
					//populate the inside using a json object
					let navOptions = JSON.parse(navXhr.responseText);
					
//					document.getElementById('nb_option1').innerText = navOptions.nb_option1;
//					document.getElementById('nb_option1').addEventListener("click", loadRequestReimbursement,false);
					
					document.getElementById('nbdd_option1').innerText = navOptions.nbdd_option1;
					document.getElementById('nbdd_option1').addEventListener("click", loadFilter("Pending", navOptions.u_id), false);
					
					document.getElementById('nbdd_option2').innerText = navOptions.nbdd_option2;
					document.getElementById('nbdd_option2').addEventListener("click", loadFilter("None", navOptions.u_id), false);
					
					document.getElementById('nbdd_option3').innerText = navOptions.nbdd_option3;
					if(navOptions.role == "Manager"){
						document.getElementById('nbdd_option3').addEventListener("click", loadEmployees,false);
					}
					else{
						document.getElementById('nbdd_option3').addEventListener("click", loadRequestReimbursement,false);
					}
					
					document.getElementById('nbdd_option4').innerText = navOptions.nbdd_option4;
					document.getElementById('nbdd_option4').addEventListener("click", loadInfo, false);
					
					
				}
			}
			navXhr.open("GET", "ajaxNavOptions?r=" + new Date().getTime(), true);
			navXhr.send();
			
			//document.getElementById('tx').addEventListener('click', loadTxView, false);
			
			
		}
	}
	xhr.open("GET", "ajaxNavbar?r=" + new Date().getTime(), true);//calls the ajaxNavbarServlet.java class which forwards to the html page. 
	xhr.send(); // what does this do?
}

//views

function loadAppView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
			document.getElementById('view').innerHTML = xhr.responseText;
			//retrieveBankUserAccountInfo();
			loadInfo();//moved 
		}
	}
	xhr.open("GET", "ajaxAppView?r=" + new Date().getTime(), true);
	xhr.send();	

}

function loadInfo(){
	console.log('in load info function');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
			document.getElementById('userSpace').innerHTML = xhr.responseText; //cannot set innerhtml property of null
			//places xhr's responsetext in the navbar element
			//document.getElementById('userAction').addEventListener('click', loadTxView, false);
			addUpdateInfoListener();
		}
	}
	xhr.open("GET", "userInfo?r=" + new Date().getTime(), true);//calls the ajaxNavbarServlet.java class which forwards to the html page. 
	xhr.send(); // what does this do?

	
}

function addUpdateInfoListener(){
	document.getElementById("updateInfoButton").addEventListener("click", loadUpdateInfo,false);
}

function loadEmployees(){
	
	console.log("load employees");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
			document.getElementById('userSpace').innerHTML = xhr.responseText;
			
			console.log("ready to populate");
			let innerXhr = new XMLHttpRequest();
			innerXhr.onreadystatechange = function() {
				if(innerXhr.readyState == 4 && innerXhr.status ==200){
					
					let employees = JSON.parse(innerXhr.responseText);
					
					console.log(innerXhr.responseText);
					
					document.getElementById('registerUser').addEventListener("click", register, false);
					
					for(let i = 0; i < employees.length; i++){
						
						console.log("populating " + i);
						
						//1 create a row let ----------------------------------------------------------
						let tableR = document.createElement("tr");
						//2 parse elements in an array
						let datatab = JSON.parse(employees[i]);
						//3 created td elements to place data in
						let tableD1 = document.createElement("td");
						let tableD2 = document.createElement("td");
						let tableD3 = document.createElement("td");
						let tableD4 = document.createElement("td");
						let tableD5 = document.createElement("td");
						
						
						//setting innertext value to data gained.
						//tableD1.InnerHTML = datatab.u_id;
						tableD1.innerText = datatab.u_id;
						console.log(datatab.u_id);
						tableR.appendChild(tableD1);
						
						//tableD2.InnerHTML = datatab.u_firstname;
						tableD2.innerText = datatab.u_firstname;
						console.log(datatab.u_firstname);
						tableR.appendChild(tableD2);
						
						//tableD3.InnerHTML = datatab.u_lastname;
						tableD3.innerText = datatab.u_lastname;
						console.log(datatab.u_lastname);
						tableR.appendChild(tableD3);
						
						//tableD4.InnerHTML = datatab.u_email;
						tableD4.innerText = datatab.u_email;
						console.log(datatab.u_email);
						tableR.appendChild(tableD4);
						
						//tableD5.InnerHTML = datatab.u_username;
						tableD5.innerText = datatab.u_username;
						console.log(datatab.u_username);
						tableR.appendChild(tableD5);
						
						console.log("row " + tableR);
						
						document.getElementById('employeesTable').appendChild(tableR);
						
						console.log("appended child");
					}
				}
			}
			
			innerXhr.open("GET", "employeesData?r=" + new Date().getTime(), true);
			innerXhr.send();
		}
	}
	xhr.open("GET", "employees?r=" + new Date().getTime(), true);
	xhr.send();
}

function register(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
			document.getElementById('userSpace').innerHTML = xhr.responseText;//places xhr's responsetext in the navbar element
			//document.getElementById('userAction').addEventListener('click', loadTxView, false);
			
		}
	}
	xhr.open("GET", "registerEmployee", true);//calls the ajaxNavbarServlet.java class which forwards to the html page. 
	xhr.send(); // what does this do?
}

function loadUpdateInfo(){
	console.log('in update info function');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
			document.getElementById('userSpace').innerHTML = xhr.responseText;//places xhr's responsetext in the navbar element
			//document.getElementById('userAction').addEventListener('click', loadTxView, false);
			
		}
	}
	xhr.open("GET", "changeInfo", true);//calls the ajaxNavbarServlet.java class which forwards to the html page. 
	xhr.send(); // what does this do?
	
	
}

function loadRequestReimbursement(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
			
			document.getElementById('userSpace').innerHTML = xhr.responseText;//places xhr's responsetext in the navbar element
			//document.getElementById('userAction').addEventListener('click', loadTxView, false);
			
			let innerXhr = new XMLHttpRequest();
			innerXhr.onreadystatechange = function() {
				if(innerXhr.readyState == 4 && innerXhr.status == 200){
					
					let typeOptions = JSON.parse(innerXhr.responseText);
					console.log(typeOptions);
					//add options
					for(let i = 0; i < typeOptions.length ; i++){
						let obj = JSON.parse(typeOptions[i]);
						let option = document.createElement("option");
						
						
						option.text = obj.rt_type;
						option.value = obj.rt_id;
						
						console.log(typeOptions[i]);
						console.log(option);
						document.getElementById('requestType').appendChild(option);
					}
				}
			}
			innerXhr.open("GET", "requestType", true);
			innerXhr.send();
		}
	}
	xhr.open("GET", "requestReimbursement", true);//calls the ajaxNavbarServlet.java class which forwards to the html page. 
	xhr.send(); // what does this do?
	
}

function loadFilter(filter, user){

	return function(){
		var xhr = new XMLHttpRequest();
		var canPopulate = true;
		
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				
				document.getElementById('userSpace').innerHTML = xhr.responseText;
				
				let input1 = document.getElementById("filter").value;
				let input2 = parseInt(document.getElementById("urid").value);
				
				console.log("input 2 is " + input2);
				
				if(canPopulate){
					
					document.getElementById("urid").value = user;
					document.getElementById("refresh").addEventListener("click", loadShowHistoryDynamic, false);
					canPopulate=false;
				}
				
				loadShowHistoryFilter(filter, user)();
			
			}
		}
		xhr.open("GET", "filterView?h=" + new Date().getTime() , true);
		xhr.send();
	}
}

function loadShowHistoryFilter(filter, user){
	var canPopulate = true;
	return function loadShowHistory(){
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				
				
				document.getElementById('historyTableDiv').innerHTML = xhr.responseText;
				
				
				let innerXhr = new XMLHttpRequest();
				innerXhr.onreadystatechange = function(){
					if(innerXhr.readyState == 4 && innerXhr.status == 200){
						

						objects = JSON.parse(innerXhr.responseText); 
						
						loadHistoryInnerLogic(objects);
						
					}
				}
				console.log("the uid we're submitting is " + user);
				innerXhr.open("GET", "history?f=" + filter + "&uid=" + user, true);
				innerXhr.send();
			}
		}
		xhr.open("GET", "historyView?f=" + filter + "&uid=" + user, true);
		xhr.send();
	}
}

function loadShowHistoryDynamic(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
			let input1 = document.getElementById("filter").value;
			let input2 = parseInt(document.getElementById("urid").value);
			
			document.getElementById('historyTableDiv').innerHTML = xhr.responseText;
			
			
			let innerXhr = new XMLHttpRequest();
			innerXhr.onreadystatechange = function(){
				if(innerXhr.readyState == 4 && innerXhr.status == 200){
					

					objects = JSON.parse(innerXhr.responseText); 
					
					loadHistoryInnerLogic(objects);
					
				}
			}
			console.log("the uid we're submitting is " + input2);
			innerXhr.open("GET", "history?f=" + input1 + "&uid=" + input2, true);
			innerXhr.send();
		}
	}
	xhr.open("GET", "historyView?f=" + new Date().getTime() , true);
	xhr.send();
	
	
}

function loadHistoryInnerLogic(objects){

	try {
		console.log(objects);
		
		
		for(let i = 0; i < objects.length; i++){
			
			//1 create a row let -------------------------------------------------------------------------------------
			let tableR = document.createElement("tr");
			
			//2 parse element in array
			let rmbt = JSON.parse(objects[i]);
			
			//3 create td elements to place data in
			let tableD1 = document.createElement("td");
			let tableD2 = document.createElement("td");
			let tableD3 = document.createElement("td");
			let tableD4 = document.createElement("td");
			let tableD5 = document.createElement("td");
			let tableD6 = document.createElement("td");
			
			let details = document.createElement("button");
			details.type = "button";
			details.className = "btn btn-secondary";
			details.innerText = "Details";
			
			//4 setting innertext to value gained by json parse
			tableD1.innerText = rmbt.r_id;
			//5 appending td to tr
			tableR.appendChild(tableD1);
			
			tableD2.innerText = rmbt.rt_status;
			tableR.appendChild(tableD2);
			tableD3.innerText = rmbt.r_amount;
			tableR.appendChild(tableD3);
			tableD4.innerText = rmbt.u_id_author;
			tableR.appendChild(tableD4);
			
			tableD5.innerText = rmbt.r_submitted;
			tableR.appendChild(tableD5);
			tableD6.innerText = rmbt.rt_type;
			tableR.appendChild(tableD6);
			
			tableR.appendChild(details);
			details.addEventListener("click", loadDetailsView(rmbt.r_id), false);
			
			//6 getting document element by id and appending child
			document.getElementById('historyTable').appendChild(tableR);
		}
	}
	catch (e) {
		console.log("nothing to display");
	}
}



function loadDetailsView(id){
	return function(){
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				document.getElementById('userSpace').innerHTML = xhr.responseText;
				
				let innerXhr = new XMLHttpRequest();
				innerXhr.onreadystatechange = function(){
					if(innerXhr.readyState == 4 && innerXhr.status == 200){
						
						let obj = JSON.parse(innerXhr.responseText);
						
						
						
						if(obj.clientRole == "Manager"){
							
							showImage(obj.r_id);
						}
						else{
							document.getElementById("upload").addEventListener("click", imageUpload, false);	
						}
						
						
						console.log(obj);
						
						let tableR = document.createElement("tr");
						
						let tableD1 = document.createElement("td");
						let tableD2 = document.createElement("td");
						let tableD3 = document.createElement("td");
						let tableD4 = document.createElement("td");
						let tableD5 = document.createElement("td");
						let tableD6 = document.createElement("td");
						let tableD7 = document.createElement("td");
						let tableD8 = document.createElement("td");
						let tableD9 = document.createElement("td");
						let tableD10 = document.createElement("td");
						let tableD11 = document.createElement("td");
						
						let resolveForm = document.createElement("form");
						
						tableD1.innerText = obj.r_id;
						tableD2.innerText = obj.u_id_author;
						tableD3.innerText = obj.u_author;
						tableD4.innerText = obj.rt_status;
						tableD5.innerText = obj.r_amount;
						tableD6.innerText = obj.r_description;
						tableD7.innerText = obj.r_submitted;
						tableD8.innerText = obj.r_resolved;
						tableD9.innerText = obj.rt_type;
						
						if(obj.u_resolver){
							console.log("resolved");
							tableD11.innerText = obj.u_resolver;
							tableD10.innerText = obj.u_id_resolver;
						}
						else if(obj.clientRole == "Manager"){
							console.log("unresolved");
							document.getElementById('resolveNow').innerText="Resolve";
							resolveCall(obj.r_id);
						}
						
						
						tableR.appendChild(tableD1);
						tableR.appendChild(tableD2);
						tableR.appendChild(tableD3);
						tableR.appendChild(tableD4);
						tableR.appendChild(tableD5);
						tableR.appendChild(tableD6);
						tableR.appendChild(tableD7);
						tableR.appendChild(tableD8);
						tableR.appendChild(tableD9);
						
						if(obj.clientRole == "Manager"){
							tableR.appendChild(tableD10);
							tableR.appendChild(tableD11);
							
						}
						//TODO add receipt button
						
						if(document.getElementById('detailsTable') != null){
							document.getElementById('detailsTable').appendChild(tableR);
						}
					}
				}
				innerXhr.open("GET", "details?r_id=" + id, true);
				innerXhr.send();
			}
		}
		xhr.open("GET", "requestDetails?r="  + new Date().getTime(), true);
		xhr.send();
	}
}

function resolveCall(id){
	console.log("resolveCall");
	//return function resolveView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
			
			console.log("resolveView");
			let array = JSON.parse(xhr.responseText);
			
			//let form = document.createElement("form");
			//form.method = "POST";
			//form.action = "resolve";
			let idFormValue = document.createElement("input");
			idFormValue.name = "r_id";
			idFormValue.value = id;
			idFormValue.type = "hidden";
			
			document.getElementById("resolveForm").appendChild(idFormValue);
			
			let selector = document.createElement("select");
			selector.className = "form-control" ;
			selector.style = "max-width:20%;";
			selector.name = "resolveSelect";
			
			for(let i = 0; i < array.length; i++){
				let status = JSON.parse(array[i]);
				let option = document.createElement("option");
				
				option.text = status.rs_status;
				option.value = status.rs_id;
				
				selector.appendChild(option);
			}
			
			document.getElementById("resolveForm").appendChild(selector);
			
			let submitButton = document.createElement("input");
			submitButton.type="submit";
			submitButton.className = "btn btn-secondary";
			
			document.getElementById("resolveForm").appendChild(submitButton);
			
//			
//			form.appendChild(selector);
//			document.getElementById('resolve').innerHTML = form;
			
		}
	}
	xhr.open("GET", "resolve?r=" + new Date().getTime(), true);
	xhr.send();	
	
	//}
}


function imageUpload(){
    console.log('imageTest()');
    //var fileInput = document.getElementById(reimNum);
    var fileInput = document.getElementById("image").value; //try this
    var file = fileInput;
    var img = new FormData();
    img.append('img', file);
    //img.append('reimNum', reimNum);
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if(xhr.readyState == 4 && xhr.status == 200){
                    	
        }
    }
    xhr.open("POST", "imageUpload", true); 
    xhr.send(img); 
}

function showImage(id){
	console.log("in showImage function");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
			console.log("ready...");
			let image = document.createElement('img');
        	
			//var base64 = Convert.ToBase64String(xhr.responseText);
			
			image.src = "data:image/png;base64, " + xhr.responseText;
			
			document.getElementById('imageDisplay').innerHtml = image;
			
			console.log("finished");
		}
	}
    xhr.open("GET", "imageView?id=" + id, true); 
    xhr.send();
}

/*
function loadImageSelectView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
			document.getElementById('view').innerHTML = xhr.responseText;
			retrieveBankUserAccountInfo();
		}
	}
	xhr.open("GET", "ajaxImageSelect", true);
	xhr.send();
	
	
}
*/
