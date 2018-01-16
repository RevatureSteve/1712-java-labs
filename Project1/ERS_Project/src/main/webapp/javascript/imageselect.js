/**
 * 
 */


window.onload = function(){
	//addScript('features/dashboard/dashboard.js');
	console.log('second script');
	document.getElementById("option1").addEventListener("mouseover", changetoimage1,false);
	document.getElementById("option2").addEventListener("mouseover", changetoimage2,false);
	document.getElementById("option3").addEventListener("mouseover", changetoimage3,false);

	
	
	
}

function changetoimage1(){
	console.log('hover1');
	document.getElementById("imageview").innerHTML = "<img src=\"images/castle-4.jpg\" alt=\"image1\" width=100% >";
}

function changetoimage2(){
	console.log('hover2');
	document.getElementById("imageview").innerHTML = "<img src=\"images/castle-5.jpg\" alt=\"image2\" width=100% >";
}

function changetoimage3(){
	console.log('hover3');
	document.getElementById("imageview").innerHTML = "<img src=\"images/castle-6.jpg\" alt=\"image3\" width=100% >";
}