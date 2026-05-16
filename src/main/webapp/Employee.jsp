<%@ page import="java.sql.*" %>

<html>
<body>

<h2>Salary Report</h2>
<hr>

<%
String empno = request.getParameter("empno");
String empname = request.getParameter("empname");
String salary = request.getParameter("salary");

Connection con = null;
PreparedStatement ps;
Statement st;
ResultSet rs;

int total = 0;

try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/Employee", "root", "nidhi2006");

    // Insert record
    ps = con.prepareStatement("INSERT INTO Emp VALUES (?, ?, ?)");
    ps.setInt(1, Integer.parseInt(empno));
    ps.setString(2, empname);
    ps.setInt(3, Integer.parseInt(salary));
    ps.executeUpdate();

    // Display report
    st = con.createStatement();
    rs = st.executeQuery("SELECT * FROM Emp");

    while (rs.next()) {
        int no = rs.getInt("Emp_NO");
        String name = rs.getString("Emp_Name");
        int sal = rs.getInt("Basicsalary");

        total += sal;
%>

Emp_No: <%= no %><br>
Emp_Name: <%= name %><br>
Basic: <%= sal %><br>
<hr>

<%
    }
%>

<h3>Grand Salary: <%= total %></h3>

<%
} catch(Exception e) {
    out.println(e);
}
%>

</body>
</html>