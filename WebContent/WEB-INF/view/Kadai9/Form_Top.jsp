<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.Form_Class"%>
<%@ page import="dao.Form_Function"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>投稿画面 </title>
<style>
body { width: 640px; }
.btn1 {
  display: block;
  margin: 0 auto;
}
.btn2 {
  display: block;
  margin: 0 auto;
}
.form{
width:340px;
height:50px;
}
.form2{
width:250px;
}
</style>
</head>
<body>
	<a href="/Sample/Form_Manag_Top"><button type="button" class="btn1">管理画面へ</button></a>
	<form  method="POST" enctype="multipart/form-data" action="/Sample/Form_Goal" >
		投稿者<br>
		<input type="text" class="form2" name="name"><br>
		 メールアドレス<br>
		 <input type="text" class="form2" name="mail"><br>
		  内容<br>
		  <input type="text" class="form" name="Content"><br>
		  <input type="file" name="file"/><br >
		  <input type="submit" class="btn2" value="送信">
	</form>

	<h1>投稿一覧を表示</h1><br>
		<%
	ArrayList<Form_Class> List = Form_Function.selectAll();
	%>
	<%
	for(Form_Class s : List){
	%>
		<%=s.getContent()%><br><br><br>
		投稿者:<%=s.getName()%>　　　
		投稿時間:<%=s.getTime()%><br>
		<%
	}
	%>

</body>
</html>