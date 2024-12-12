
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>


<%@ page import="java.util.*"%>
<%@ page import="org.example.web_basic.chap02.*"%>


<%
  List<Dancer> dancerList = DancerList.getDancerList();
%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>
<body>
  <ul>
    <% for (Dancer d : dancerList){ %>
      <li>
        # 이름: <%= d.getName() %>,
        # 크루이름: <%= d.getCrewName() %>,
        # 수준: <%= d.getDanceLevel() %>,
        # 장르: <%= d.getGenres() %>
      </li>

    <%} %>
  </ul>
  <a href="/chap03/dancer/register.jsp"></a>
</body>
</html>