package signup;

import Utils.DataSourceUtils;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

@WebServlet(name = "RegisterServlet",urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据

       // request.setCharacterEncoding("UTF-8");

        // String username =  request.getParameter("username");
        // String password = request.getParameter("password");
        //将获取的数据封装到javaBean中
        // User user = new User();
        // user.setUsername(username);
        // user.setPassword(password);

        //使用BeanUtils进行自动映射封装
        //BeanUtils工作原理：将map中的数据，根据key与实体的属性的对应关系封装
        //只要key的名字与实体的属性 的名字一样 就自动封装
        Map<String, String[]> properties = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, properties);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //以上已经完成封装
        //手动封装uid属性--uuid--随机不重复的字符串32位，Java代码生成后是36位的

       // user.setId(UUID.randomUUID().toString());


        //将参数传递给一个业务操作方法
        register(user);

    }
    //注册方法
    public void register(User user){
        //操作数据库

        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into info values(?,?,?)";

        try {
            runner.update(sql,null,user.getUsername(),user.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
