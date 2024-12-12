package org.example.web_basic.chap04;

import org.example.web_basic.chap02.DancerList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mvc/v1/remove")
public class DancerRemoveServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("삭제요청이 들어옴");

        String id = req.getParameter("id");
        System.out.println("id = " + id);
        DancerList.removeDancer(Integer.parseInt(id));
        // 리스트 삭제 후 재요청(리다이렉트)
        resp.sendRedirect("/mvc/v1/show");
    }
}
