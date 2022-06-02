<%@ page import="pojo.TestClass" %><%--
  Created by IntelliJ IDEA.
  User: Prateek
  Date: 19-05-2022
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test page</title>
</head>

<body>

<%      //JSP CODE      %>

<%
    String temp_path = (String) request.getAttribute("path");
    String temp_line = (String) request.getAttribute("firstLine");
    String temp_userStatus = (String) request.getAttribute("userStatus");


%>

<p>This is the path <%=temp_path%></p>

<p>This is the First Line <%=temp_line%></p>

<p><%=temp_userStatus%></p>


<a href="sessionTest.jsp" >Session test</a>

</body>
</html>
