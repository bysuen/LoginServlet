package Servlet;

import Utils.DataSourceUtils;
import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        //在Servletcontext域中存一个数据count
        int count = 0;
        this.getServletContext().setAttribute("count",count);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //2.从数据库中验证用户名和密码是否正确
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());//获得连接池
        String sql = "select * from info where name=? and password=?";
        User user = null;
        try {
            user = runner.<User>query(sql, new BeanHandler<User>(User.class), username, password);

        }catch (SQLException e){
            e.printStackTrace();
        }
        //3.根据返回的结果给用户名返回提示
        if (user != null){
            //从Servletcontext中取出count进行++运算，计算访问次数
            ServletContext context = this.getServletContext();
            Integer count = (Integer) context.getAttribute("count");
            count++;
            context.setAttribute("count",count);
            //用户登录成功
            response.getWriter().write("ok "+count);

        }else {
            //用户登录失败
            response.getWriter().write("no,sorry");
        }
    }
}
