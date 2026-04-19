<%@ page import="java.util.*" %>
<html>
<body>

<h2>Student Result</h2>

Roll No: ${rollno} <br>
Name: ${name} <br><br>

<%
    int marks[] = (int[]) request.getAttribute("marks");
    for (int i = 0; i < marks.length; i++) {
%>
    Subject <%= i+1 %>: <%= marks[i] %> <br>
<%
    }
%>

<br>
Average: ${average} <br>
Result: <b>${result}</b> <br><br>

<a href="index.jsp">Go Back</a>

</body>
</html>