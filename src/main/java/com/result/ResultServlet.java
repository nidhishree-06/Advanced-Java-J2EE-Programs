 

/*10.b Build an Application to get Rollno, Studentname, Sub1, Sub2, Sub3, Sub4 and Sub5  through JSP called index.jsp with client sided validation and submit to the 
servlet called ResultServlet and process all the fields with server sided validation and display all the data along with result ( Pass if all subjects greater
than 40%) and Average marks through result.jsp with a link to move to the client side*/


package com.result;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ResultServlet")   // 🔥 replaces web.xml
public class ResultServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rollno = request.getParameter("rollno");
        String name = request.getParameter("name");

        int marks[] = new int[5];
        boolean isValid = true;

        try {
            for (int i = 0; i < 5; i++) {
                marks[i] = Integer.parseInt(request.getParameter("sub" + (i + 1)));

                if (marks[i] < 0 || marks[i] > 100) {
                    isValid = false;
                }
            }
        } catch (Exception e) {
            isValid = false;
        }

        if (rollno == null || name == null || rollno.isEmpty() || name.isEmpty()) {
            isValid = false;
        }

        if (!isValid) {
            response.getWriter().println("<h3>Invalid Input! Go back and try again.</h3>");
            return;
        }

        int total = 0;
        boolean pass = true;

        for (int m : marks) {
            total += m;
            if (m < 40) {
                pass = false;
            }
        }

        double avg = total / 5.0;
        String result = pass ? "PASS" : "FAIL";

        request.setAttribute("rollno", rollno);
        request.setAttribute("name", name);
        request.setAttribute("marks", marks);
        request.setAttribute("average", avg);
        request.setAttribute("result", result);

        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }
}
