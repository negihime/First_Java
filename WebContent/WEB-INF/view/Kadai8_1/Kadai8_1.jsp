<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>課題１</h1><br>
		<input type="text" id="name" value ="">
		<input type="text" id="name2" value =""><br>
		<button id="showAlert">足し算</button>
		<button id="showAlert2">引き算</button>
		<button id="showAlert3">掛け算</button>
		<button id="showAlert4">割り算</button>

		<h1>課題2</h1><br>
		<div id="myDIV">
  			Hello もりじょびワールド
		</div>
		<button onclick="myFunction()">ボタン</button>

		<h1>課題3</h1><br>
		<form id="actionForm">
		ID:<input type="text" id="id" value =""><br>
		PW:<input type="text" id="pw" value =""><br>
		<input type="submit" value="送信">
		</form>
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
	<script>
		$('#showAlert').click(function() {
			var suu = eval(document.getElementById("name").value) + eval(document.getElementById("name2").value);
			alert(suu);
		});
		$('#showAlert2').click(function() {
			var suu = eval(document.getElementById("name").value) - eval(document.getElementById("name2").value);
			alert(suu);
		});
		$('#showAlert3').click(function() {
			var suu = eval(document.getElementById("name").value) * eval(document.getElementById("name2").value);
			alert(suu);
		});
		$('#showAlert4').click(function() {
			var suu = eval(document.getElementById("name").value) / eval(document.getElementById("name2").value);
			alert(suu);
		});

		function myFunction() {
			  var x = document.getElementById("myDIV");
			  if (x.style.display === "none") {
			    x.style.display = "block";
			  } else {
			    x.style.display = "none";
			  }
			}
		$("#actionForm").submit(function(){
			if(document.getElementById("id").value === "" || document.getElementById("pw").value === "") {
			    alert("空欄があります。");
			    return false;
			  }
	    })
	</script>

</body>
</html>