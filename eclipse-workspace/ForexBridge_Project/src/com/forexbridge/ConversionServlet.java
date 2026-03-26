
package com.forexbridge;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ConversionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        double amount = (Double)request.getAttribute("amount");
        double rate = (Double)request.getAttribute("rate");

        double result = amount * rate;
        result = Math.round(result * 100.0) / 100.0;

        HttpSession session = request.getSession();

        String history = (String)session.getAttribute("history");
        if(history == null) history = "";

        history = history + amount + " -> " + result + "<br>";

        session.setAttribute("history", history);

        request.setAttribute("result", result);

        RequestDispatcher rd = request.getRequestDispatcher("result");
        rd.forward(request,response);
    }
}
