package org.example.web_basic.chap04;

import org.example.web_basic.chap02.Dancer;
import org.example.web_basic.chap02.DancerList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/mvc/v1/show")
public class ShowDancerListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dancer> dancerList = DancerList.getDancerList();

        req.setAttribute("dancers",dancerList);

        //jsp 연결(html용) => 뷰 포워딩
        RequestDispatcher dispatcher
                //실제 위치
                = req.getRequestDispatcher("/WEB-INF/chap04/dancer/list.jsp");

        dispatcher.forward(req,resp);

    }
}
