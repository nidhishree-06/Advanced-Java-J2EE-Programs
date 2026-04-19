<%@ page language="java" %>
<%@ page import="javax.servlet.http.Cookie" %>

<html>
<head>
    <title>Active Cookies</title>
</head>
<body>

<h2>Active Cookie List</h2>

<%
    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
%>
            Name: <%= cookies[i].getName() %> <br>
            Value: <%= cookies[i].getValue() %> <br>
            <hr>
<%
        }
    } else {
%>
        <h3>No Cookies Found</h3>
<%
    }
%>

<br>
<a href="index.jsp">Back to Home</a>

</body>
</html>