package web;

import service.TransferService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TransferServlet",urlPatterns = "/transfer")
public class TransferServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受转账参数
        String out = request.getParameter("out");
        String in = request.getParameter("in");
        String money =request.getParameter("money");
        double mon = Double.parseDouble(money);
        //调用业务层的转账方法
        TransferService ts = new TransferService();
        boolean isTransferSuccess = ts.transfer(out,in,mon);
        if (isTransferSuccess){
            response.getWriter().write("ok");
        }else {
            response.getWriter().write("no");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
