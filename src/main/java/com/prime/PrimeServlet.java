/*6c.Build a servlet program to check the given number is prime number or not , 
 * using HTML with Error Code when an invalid number is entered  step by step procedure.
 */





package com.prime;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/PrimeServlet")
public class PrimeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String input = request.getParameter("num");

        try {
            int num = Integer.parseInt(input);

            if (num <= 1) {
                out.println("<h3>" + num + " is NOT a Prime Number</h3>");
                return;
            }

            boolean isPrime = true;

            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime)
                out.println("<h3>" + num + " is a Prime Number</h3>");
            else
                out.println("<h3>" + num + " is NOT a Prime Number</h3>");

        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.println("<h3 style='color:red;'>Error: Invalid input! Enter a valid number.</h3>");
        }
    }
}