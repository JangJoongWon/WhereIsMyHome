document.querySelector("#aptListBtn").addEventListener("click", function () {
    console.log("버튼 클릭");
    const sido = document.querySelector("#sido").value;
    const gugun = document.querySelector("#gugun").value;
    const dong = document.querySelector("#dong").value;

    const url = `/house/search?sido=${sido}&gugun=${gugun}&dong=${dong}`;
    window.location.href=url;
});