<%--
  Created by IntelliJ IDEA.
  User: bysuen
  Date: 2019/8/3
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>

</head>
<body>
<form action="${pageContext.request.contextPath}/transfer" method="post">
    转出账户<input type="text" name="out"><br>
    转入账户<input type="text" name="in"><br>
    转账金额<input type="text" name="money"><br>
    <input type="submit" name="确认转账"><br>
</form>

</body>
</html>
