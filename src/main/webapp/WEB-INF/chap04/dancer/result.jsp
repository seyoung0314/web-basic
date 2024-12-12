<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <body>

    <h1>댄서 등록 결과 페이지입니다.</h1>
    <%-- // getter가 있다면 public처럼 접근가능 --%>
    <h2>${dancer.name}님 (소속: ${dancer.getCrewName()})이 정상 등록되었습니다.</h2>
    <h3>댄스 수준: ${dancer.getDanceLevel()}</h3>
  

    <a href="/mvc/v1/register">다시 등록하러 가기</a>
    <a href="/mvc/v1/show">댄서 목록 조회하기</a>
  </body>
</html>