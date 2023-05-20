/**
 * enrollBtn
 */


document.querySelector("#enrollBtn").addEventListener("click", function () {
	 let userinfo = {
		        id: document.querySelector("#id").value,
		        pwd : document.querySelector("#pwd").value,
		        name: document.querySelector("#name").value,
		        address : document.querySelector("#address").value,
		        phone : document.querySelector("#phone").value
	 }
	 
	 alert(userinfo.id);
	 
	 let config = {
		        method: "POST",
		        headers: {
		            "Content-Type": "application/json;charset=utf-8",
		        },
		        body: JSON.stringify(userinfo),
		    };
	
	console.log(config.body);
	
	  fetch(`./signup`, config)
		.then(data => {
			location.href='/'
		});
	
	
});
