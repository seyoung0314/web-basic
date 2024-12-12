package org.example.web_basic.chap04;

import org.example.web_basic.chap02.DanceLevel;
import org.example.web_basic.chap02.Dancer;
import org.example.web_basic.chap02.DancerList;
import org.example.web_basic.chap02.Genre;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// 새로운 댄서 정보를 리스트(데이터베이스)에 등록하기 위해
// 댄서 정보들을 읽어와서 리스트에 저장하는 처리
@WebServlet("/mvc/v1/process")
public class AddNewDancerServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //비지니스 로직 처리
        String name = req.getParameter("name");
        String crewName = req.getParameter("crewName");
        String danceLevel = req.getParameter("danceLevel");
        String[] genres = req.getParameterValues("genres");

        List<Genre> genreList = new ArrayList<>();
        for(String g : genres){
            genreList.add(Genre.valueOf(g));
        }
        Dancer dancer = new Dancer(
                name,crewName, DanceLevel.valueOf(danceLevel),genreList);

        DancerList.addDancer(dancer);

        // servlet 이 jsp 에게 화면을 그릴 때 필요한 데이터를 전달
//        req.setAttribute("name",name);
//        req.setAttribute("crew",crewName);
//        req.setAttribute("level",danceLevel);
        req.setAttribute("dancer",dancer);

//        Object name1 = req.getAttribute("name");

        // 응답 html 생성 처리 - jsp 포워딩
        RequestDispatcher dispatcher
                //실제 위치
                = req.getRequestDispatcher("/WEB-INF/chap04/dancer/result.jsp");

        dispatcher.forward(req,resp);
    }
}