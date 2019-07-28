package header;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

@WebServlet(name = "HeaderServlet", urlPatterns = "/header")
public class HeaderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得单个表单值
        String username = request.getParameter("username");
        response.getWriter().write(username);
        //获得多个表单的值
        String[] hobbys = request.getParameterValues("hobby");
        for (String hobby:hobbys){
            response.getWriter().write(hobby);
            response.getWriter().write("\n");
        }
        //获得所有的请求的参数名称
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            response.getWriter().write(parameterNames.nextElement()+"\n");
        }
        //获得所有参数 参数封装到一个Map<String,String[]>中
        Map<String,String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String,String[]> entry:parameterMap.entrySet()){
            for (String str:entry.getValue()){
                response.getWriter().write(str);
        }

    }
        }




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* //获得指定请求头
        String header = request.getHeader("User-Agent");
        System.out.println(header);
        // 获得所有的头的名称
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            System.out.println(headerName + ":::" + headerValue);
        }
*/
    }
    }