<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>login</title>
</head>
<body>
    <h2>登陆系统</h2>
    <form action="LoginCheck" mothod="post">
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="user_name"></td>
            </tr>
            <tr>
                <td><br/><br/></td>
                <td><input type="submit" value="登陆">
                    <input type="reset" value="重置">
                </td>

            </tr>
        </table>
    </form>
</body>
</html>
