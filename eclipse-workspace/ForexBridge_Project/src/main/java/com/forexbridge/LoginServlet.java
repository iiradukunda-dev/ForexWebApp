package com.forexbridge;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

//@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        if("24RP02240".equals(user) && "24RP12926".equals(pass)) {

            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            response.sendRedirect("home");

        } else {

            request.setAttribute("error","Invalid username or password");

            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request,response);

        }
    }
}