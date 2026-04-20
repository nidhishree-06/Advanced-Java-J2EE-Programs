/*
8a. Build a servlet program to create a cookie to get your name through text box 
and press submit button to display the message by greeting Welcome back your name ! , 
you have visited this page n times ( n = number of your visit ) and demonstrate the 
expiry of cookie also.
*/

package com.lab_8a;

// Step 1: Required imports
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

// Step 2: Create servlet class and use WebServlet annotation
@WebServlet("/CookieServlet1")

public class CookieServlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    int count = 0; // count for loading times

    // Step 3: Handle GET requests
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Step 4: Create or retrieve cookies
        String userName = request.getParameter("userName");

        if (userName != null && !userName.isEmpty()) {

            // Create a new cookie
            Cookie userCookie = new Cookie("user", userName);

            // Step 5: Set cookie expiry (30 seconds)
            userCookie.setMaxAge(30);

            // Step 6: Add cookie to response
            response.addCookie(userCookie);
        }

        // Step 7: Read existing cookies
        Cookie[] cookies = request.getCookies();
        String existingUser = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    existingUser = cookie.getValue();
                    break;
                }
            }
        }

        // Step 8: Generate HTML response
        out.println("<html>");
        out.println("<head><title>Cookie Example</title></head>");
        out.println("<body>");

        if (existingUser != null) {
            count++;
            out.println("<font color='blue'><h2>Welcome back, " + existingUser + "!</h2></font>");
            out.println("<font color='magenta'><h2>You have visited this page " + count + " times!</h2></font>");
            out.println("<p>Note: Cookie expires in 30 seconds. Wait and refresh to test expiry.</p>");
        } else {
            out.println("<h2 style='color:red;'>Welcome Guest! Please enter your name</h2>");
            out.println("<form action='CookieServlet1' method='post'>");
            out.println("Enter your name: <input type='text' name='userName'>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
        }

        out.println("</body></html>");
    }

    // Step 9: Handle POST requests
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response); // redirect POST to GET
    }
}