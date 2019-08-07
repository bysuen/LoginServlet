<%--
  Created by IntelliJ IDEA.
  User: bysuen
  Date: 2019/8/7
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录效验</title>
    <script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <script>
        $(function () {
            $("#name").keyup(function () {
                var usernameInput = $(this).val();
                //alter(usernameInput);
                //去服务器效验该用户名是否存在
                $.post(
                    "${pageContext.request.contextPath}/LoginCheckServlet",
                {"name":usernameInput},
                function(data) {
                    var isExist = data.isExist;
                    //根据返回isExist动态显示信息
                    var checkResult = "";
                    if (isExist){
                        checkResult = "该用户名存在"
                    } else {
                        checkResult = "该用户可以使用"
                    }
                    $("#checkResult").html(checkResult);
                },
                    "json"
                );
            });
        });
    </script>
</head>
<body>
<form>

    用户名：<input id="name" name="name" type="text">
    <span id="checkResult"></span><br>
    <input type="submit" value="ok">

</form>
</body>
</html>
