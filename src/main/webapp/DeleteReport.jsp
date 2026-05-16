<%@ page import="java.sql.*" %>

<html>
<body>

<h2>Salary Report (After Deletion)</h2>
<hr>

<%
String ch = request.getParameter("ch");

Connection con;
PreparedStatement ps;
Statement st;
ResultSet rs;

try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/Employee", "root", "nidhi2006");

    // DELETE query
    String deleteQuery = "DELETE FROM Emp WHERE Emp_Name LIKE ?";
    ps = con.prepareStatement(deleteQuery);
    ps.setString(1, ch + "%");

    int rows = ps.executeUpdate();
%>

<b><%= rows %> record(s) deleted successfully.</b>
<hr>

<%
    // Show remaining records
    st = con.createStatement();
    rs = st.executeQuery("SELECT * FROM Emp");

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