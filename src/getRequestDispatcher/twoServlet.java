package getRequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "twoServlet",urlPatterns = "/two")
public class twoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从request域中取出数据
        Object object = request.getAttribute("name");
        response.getWriter().write((String) object);
        response.getWriter().write("\n");

        response.getWriter().write("okkoooooooookkkkkkkkk");
    }
}
