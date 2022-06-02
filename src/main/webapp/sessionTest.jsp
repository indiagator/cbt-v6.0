<%--
  Created by IntelliJ IDEA.
  User: Prateek
  Date: 20-05-2022
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>session test</title>
</head>
<body>

<%
    String usr = (String) request.getSession().getAttribute("username");
%>

<h1>This is coming from the Session <%=usr%></h1>

</body>
</html>
