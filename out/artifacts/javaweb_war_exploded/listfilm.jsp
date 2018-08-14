<%--
  Created by IntelliJ IDEA.
  User: hy
  Date: 2018/8/14
  Time: 1:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="bean.*" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>listfilm</title>
</head>
<body>
<form action="listFilm" method="post">
    <input type="submit"  value="显示列表">
</form>

<table>
            <caption style="margin-bottom: 20px">
                电影显示
            </caption>
            <tr>
                <th>电影id</th>
                <th>电影名称</th>
                <th>电影描述</th>
                <th>电影语言</th>
            </tr>
            <% List<filminfo> film=(List<filminfo>)request.getAttribute("allfilm");
                for(filminfo f:film){

            %>
            <tr>
                <td><%=f.getFilm_id()%></td>
                <td><%=f.getTitle()%></td>
                <td><%=f.getDescription()%></td>
                <td><%=f.getName()%></td>

            </tr>
            <%
                }
            %>
        </table>

</body>
</html>
