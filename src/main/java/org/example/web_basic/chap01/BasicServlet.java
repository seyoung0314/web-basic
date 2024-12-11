package org.example.web_basic.chap01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

//1970년대쯤...

// 역할 : http 통신의 요청과 응답을 손쉽게 처리하는 클래스
// URL 매핍 : 어떤 요청이 등어올 때 이 클래스가 작동할 것인지 정의
@WebServlet("/basic")
public class BasicServlet extends HttpServlet {

    //생성자
    public BasicServlet() {
        System.out.println("/basic 요청이 들어옴");
    }

    //요청이 들어오면 해야 할 일 : 비지니스 로직
    //service메서드는 HTTP요청과 응답을 실질적으로 처리함
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("비지니스 로직 실행");

        // HTTP 요청을 분석해서 클라이언트가 뭘 원하는지 이해하고
        // 로직을 수행해야 함

        String method = req.getMethod();
        System.out.println("method = " + method);

        String header = req.getHeader("Cache-Control");
        System.out.println("header = " + header);

        // 쿼리 스트링 읽기
        // ?name=kim&age=10&grade=F
        String name = req.getParameter("name");
        System.out.println("name = " + name);

        String age = req.getParameter("age");
        System.out.println("age = " + age);

        String grade = req.getParameter("grade");
        System.out.println("grade = " + grade);

        //서버의 응답처리
        //핵심 로직 : 나이를 기반으로 출생연도를 구해야 함
        //          F 학점일 시 재수강

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        //HTML 작성 (JAVA코드)
        PrintWriter w = resp.getWriter();

        //출생연도 구하기
        int birthYear = 0;
        try {
            birthYear = LocalDate.now().getYear() - Integer.parseInt(age) + 1;
            System.out.println("birthYear = " + birthYear);
        } catch (NumberFormatException e) {
            resp.setStatus(400);
            w.write("<h1>나이는 숫자로</h1>");
            return;
        }

        //재수강 여부 메세지
        String message = grade.equals("F")
                ? "재수강"
                : "PASS";
        System.out.println("message = " + message);

        //응답 HTTP 메세지 생성
        resp.setStatus(200); // 상태코드 전송

        w.write("<!DOCTYPE html>");
        w.write("<html lang=\"ko\">");
        w.write("<head>\n");
        w.write("</head>\n");
        w.write("<body>\n");
        w.write("   \t<h1>\n");
        w.write(String.format("%s님은 %d년생입니다.", name, birthYear));
        w.write("   </h1>\n");
        w.write("<h2>" + message + "</h2>");
        w.write("</body>\n");
        w.write("</html>");

    }
}
