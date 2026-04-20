<%
    String name = request.getParameter("username");
    int time = Integer.parseInt(request.getParameter("time"));

    session.setAttribute("username", name);

    // Set session expiry time
    session.setMaxInactiveInterval(time);
%>

<html>
<body>

<h2>Hello <%= name %>!</h2>

<p>Your session is set for <%= time %> seconds.</p>

<a href="checkSession.jsp">Click here to check session</a>

</body>
</html>