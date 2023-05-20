const queryString = window.location.search;

const params = new URLSearchParams(queryString);

const sido = params.get('sido');
const dong = params.get('dong');
const gugun = params.get('gugun');

const info = {
    "sidoName" : sido,
    "gugunName" : gugun,
    "dongName" : dong
}

fetch("../house/search", {
    body: JSON.stringify(info),
    headers: {
          'Content-Type': 'application/json;charset=utf-8'
        },
    method : "post"
})
.then(res => res.json())
.then(data => {
    makeList(data);
})
.catch(() => {console.log("error")});


const makeList = (list)=>{
	const aptList = document.querySelector("#apt-list");

	list.forEach((index)=>{
		const div = document.createElement("div");
		const inner = `
				<div onclick="setCenter(${index.lat}, ${index.lng})">
                    <li>${index.apartmentName}</li>
                    <li>거래금액: ${index.dealAmount}</li>
                    <li>면적: ${index.area}</li>
                    <li>${index.dealYear}.${index.dealMonth}.${index.dealDay}</li>
                    <hr>
                </div>
		`;
		div.innerHTML = inner;
		aptList.appendChild(div);

	})
}