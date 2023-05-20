$(document).ready(function() {
	$.ajax({
		type: "GET",
		url: "/dong/sido", // 서블릿의 URL
		success: function(data) { // Ajax 요청이 성공했을 때 실행되는 함수
			var options = '<option value="">시도 선택</option>';
			for (var i = 0; i < data.length; i++) {
				options += '<option value="' + data[i] + '">' + data[i] + '</option>';
			}
			$('#sido').html(options); // city select 요소의 option 값을 업데이트
		},
		error: function(jqXHR, textStatus, errorThrown) { // Ajax 요청이 실패했을 때 실행되는 함수
			alert('An error occurred while processing your request: ' + textStatus + ' - ' + errorThrown);
		}
	});
});

$(function() {
	ready2();
})

function ready2() {

	// sido 요소에서 선택한 값이 변경될 때마다 실행되는 이벤트 핸들러
	$('#sido').change(function() {
		var sido = $(this).val(); // 선택한 시도 코드를 가져옴

		// 시도 코드를 이용하여 서버로 Ajax 요청을 보내고, 반환된 데이터로 구군 요소를 업데이트
		$.ajax({
			type: "GET",
			url: "/dong/gugun", // 서블릿의 URL
			data: { sido: sido }, // 선택한 국가 코드를 파라미터로 전달
			dataType: 'json',
			success: function(data) { // Ajax 요청이 성공했을 때 실행되는 함수
				var options = '<option value="">구군 선택</option>';
				for (var i = 0; i < data.length; i++) {
					options += '<option value="' + data[i] + '">' + data[i] + '</option>';
				}
				$('#gugun').html(options); // city select 요소의 option 값을 업데이트
			},
			error: function(jqXHR, textStatus, errorThrown) { // Ajax 요청이 실패했을 때 실행되는 함수
				alert('An error occurred while processing your request: ' + textStatus + ' - ' + errorThrown);
			}
		});
	});
};

$(function() {
	ready3();
})

function ready3() {

	// gugun 요소에서 선택한 값이 변경될 때마다 실행되는 이벤트 핸들러
	$('#gugun').change(function() {
		var gugun = $(this).val(); // 선택한 시도 코드를 가져옴

		// 시도 코드를 이용하여 서버로 Ajax 요청을 보내고, 반환된 데이터로 구군 요소를 업데이트
		$.ajax({
			type: "GET",
			url: "/dong/dong", // 서블릿의 URL
			data: { gugun: gugun }, // 선택한 국가 코드를 파라미터로 전달
			dataType: 'json',
			success: function(data) { // Ajax 요청이 성공했을 때 실행되는 함수
				var options = '<option value="">동 선택</option>';
				for (var i = 0; i < data.length; i++) {
					options += '<option value="' + data[i] + '">' + data[i] + '</option>';
				}
				$('#dong').html(options); // city select 요소의 option 값을 업데이트
			},
			error: function(jqXHR, textStatus, errorThrown) { // Ajax 요청이 실패했을 때 실행되는 함수
				alert('An error occurred while processing your request: ' + textStatus + ' - ' + errorThrown);
			}
		});
	});
};
