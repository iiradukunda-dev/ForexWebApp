
package com.forexbridge;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ResultServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String history = (String)session.getAttribute("history");

        request.setAttribute("history", history);

        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request,response);
    }
}
