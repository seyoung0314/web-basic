<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <style>
      .del-btn {
        padding: 5px 10px;
        outline: none;
        border: none;
        background: red;
        border-radius: 10px;
        color: #fff;
        margin-left: 10px;
        margin-bottom: 10px;
        cursor: pointer;
      }
      .del-btn:hover {
        border: 1px solid orange;
        opacity: 0.8;
      }
    </style>

    <title>Document</title>
  </head>
  <body>
    <h1>MVC 댄서 정보 목록</h1>
    <ul id="dancer-list">
      <!-- for (Dancer d : dancers) -->
      <c:forEach var="d" items="${dancers}">
        <li>
          # 이름: <span class="dancer-name">${d.name}</span>,
          # 크루명: ${d.crewName},
          # 수준: ${d.danceLevel}
          <button class="del-btn">삭제</button>
        </li>
      </c:forEach>
      
    </ul>
  
    <a href="/mvc/v1/register">다시 등록하기</a>

    <script>
      const $dancerList = document.getElementById('dancer-list');
      $dancerList.addEventListener('click',e =>{
        if(!e.target.matches('.del-btn')) return;

        const $ul = e.target.closest('ul'); 
        const index = Array.from($ul.children).indexOf(e.target.parentNode);
        console.log(index);

        //삭제 요청보내기
        // window.location.href =`/mvc/v1/remove?id=`+index;
        window.location.href =`/mvc/v1/remove?id=\${index}`;
        
      })
    </script>
  </body>
  
</html>
