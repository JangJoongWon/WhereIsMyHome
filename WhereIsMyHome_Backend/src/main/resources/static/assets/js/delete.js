/**
 * 
 */

document.querySelector("#deleteBtn").addEventListener("click", function() {

	const id = document.querySelector("#id").value;
	
	confirm("탈퇴 할까요?");

	fetch(`./delete/${id}`)
		.then(data => {
			location.href='/'
		});
});
