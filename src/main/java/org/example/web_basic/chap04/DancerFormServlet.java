package org.example.web_basic.chap04;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 주소창에 노출?될 주소
@WebServlet("/mvc/v1/register")
public class DancerFormServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //비지니스 로직 처리
//        System.out.println("댄서폼열어줘");

        //jsp 연결(html용) => 뷰 포워딩
        RequestDispatcher dispatcher
                //실제 위치
                = req.getRequestDispatcher("/WEB-INF/chap04/dancer/register.jsp");

        dispatcher.forward(req,resp);
    }
}
