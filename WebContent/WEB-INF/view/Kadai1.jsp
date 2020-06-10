<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
int count = 0;
%>
<!doctype html>
<html lang="ja">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>
	<h1>Hello, Cookie!</h1>

	<div id="cookie-set"></div>
<!-- Japascript jQuery -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script>
	function load() {
			alert("cookieが破棄されました。");
			window.onload = load;
	}
	setTimeout("load()", 30000);
	$(function(){
		$('#cookie-set').html('JS Cookie: ' + $.cookie('Cookie_kadai'));
	});
</script>

</body>
</html>