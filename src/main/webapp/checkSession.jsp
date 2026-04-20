<%
    String name = (String) session.getAttribute("username");

    if (name == null) {
%>

<h2>Session Expired!</h2>
<a href="index.jsp">Go Back</a>

<%
    } else {
%>

<h2>Welcome back <%= name %>!</h2>

<p>Your session is still active.</p>

<a href="checkSession.jsp">Refresh Again</a>

<%
    }
%>