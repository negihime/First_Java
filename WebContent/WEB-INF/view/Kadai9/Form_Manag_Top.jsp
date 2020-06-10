<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.Form_Class"%>
<%@ page import="dao.Form_Function"%>
<%@page import="java.util.ArrayList"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理画面</title>
<style>
.btn1 {
  display: block;
  margin: 0 auto;
}
</style>
</head>
<body>
	<a href="/Sample/Form_Top"><button type="button" class="btn1">TOPへ戻る</button></a><br><br>
	<h1>投稿一覧を表示</h1><br>
		<%
	ArrayList<Form_Class> List = Form_Function.selectAll();
	%>
	<%
	for(Form_Class s : List){
	%>
		<form action="/Sample/Form_Delete" method="get">
			<input type="hidden" name="de_id" value = <%=s.getName()%>>
			<%=s.getContent()%><br><br><br>
			投稿者:<%=s.getName()%>　　　
			投稿時間:<%=s.getTime()%>
			<button>編集</button>
			<input type="submit" value="削除">
		</form>

		<br><br>
		<%
	}
	%>
</body>
</html>