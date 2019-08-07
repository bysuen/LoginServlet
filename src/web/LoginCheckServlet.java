package web;

import service.CheckService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginCheckServlet",urlPatterns = "/LoginCheckServlet")
public class LoginCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得要效验的用户名
        String name = request.getParameter("name");
        //传递name到service层
        CheckService checkService = new CheckService();
        boolean isExist = checkService.checkname(name);

        response.getWriter().write("{\"isExist\":"+isExist+"}");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
    }
