<%@ page import="java.sql.*" %>

<html>
<body>

<h2>Salary Report</h2>
<hr>

<%
String ch = request.getParameter("ch"); // input character

Connection con;
PreparedStatement ps;
ResultSet rs;

try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/Employee", "root", "nidhi2006");

    // LIKE query
    String query = "SELECT * FROM Emp WHERE Emp_Name LIKE ?";
    ps = con.prepareStatement(query);
    ps.setString(1, ch + "%");

    rs = ps.executeQuery();

    while (rs.next()) {
%>

Emp_No: <%= rs.getInt("Emp_NO") %><br>
Emp_Name: <%= rs.getString("Emp_Name") %><br>
Basic: <%= rs.getInt("Basicsalary") %><br>
<hr>

<%
    }

} catch(Exception e) {
    out.println(e);
}
%>

</body>
</html>