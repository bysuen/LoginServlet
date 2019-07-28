package header;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "refererServlet",urlPatterns = "/referer")
public class refererServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //对该新闻的来源进行判断
        String header = request.getHeader("referer");
        System.out.println(header);
        if (header != null && header.startsWith("http://localhost")) {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("xiaobingbingchuanqishouyou");

        }else {
            response.getWriter().write("ni shi dao lian ");
        }
    }
}