document.querySelector("#submitBtn").addEventListener("click", function () {
    let userinfo = {
        id: document.querySelector("#userid").value,
        pwd : document.querySelector("#userpwd").value
    }

    // alert(userinfo.userId + "/" + userinfo.userPwd);

    let config = {
        method: "POST",
        headers: {
            "Content-Type": "application/json;charset=utf-8",
        },
        body: JSON.stringify(userinfo),
    };
    
    console.log(config.body);
    
    
    fetch(`./login`, config)
		.then(data => {
			location.href='/'
		});
                               


});