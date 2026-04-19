<%@ page language="java" %>
<%@ page import="javax.servlet.http.Cookie" %>

<html>
<head>
    <title>Cookie Added</title>
</head>
<body>

<%
    String name = request.getParameter("name");
    String domain = request.getParameter("domain");
    String ageStr = request.getParameter("age");

    try {
        int age = Integer.parseInt(ageStr);

        Cookie c = new Cookie(name, "SampleValue");

        // Set domain only if given
        if (domain != null && !domain.isEmpty()) {
            c.setDomain(domain);
        }

        c.setMaxAge(age);

        response.addCookie(c);
%>

<h3>Cookie Added Successfully!</h3>

Name: <%= name %><br>
Domain: <%= domain %><br>
Max Age: <%= age %> seconds<br><br>

<a href="viewCookies.jsp">Go to Active Cookie List</a>

<%
    } catch (Exception e) {
%>
<h3 style="color:red;">Invalid Input! Please enter correct values.</h3>
<a href="index.jsp">Go Back</a>
<%
    }
%>

</body>
</html>