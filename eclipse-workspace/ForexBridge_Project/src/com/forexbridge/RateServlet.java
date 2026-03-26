
package com.forexbridge;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RateServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        double rate = 0;

        String source = (String)request.getAttribute("source");
        String target = (String)request.getAttribute("target");

        if(source.equals("USD") && target.equals("RWF")) rate = 1350;
        else if(source.equals("EUR") && target.equals("RWF")) rate = 1470;
        else if(source.equals("GBP") && target.equals("RWF")) rate = 1710;
        else if(source.equals("USD") && target.equals("EUR")) rate = 0.92;
        else if(source.equals("USD") && target.equals("JPY")) rate = 149.50;
        else{
            response.sendError(500,"Unsupported currency pair");
            return;
        }

        request.setAttribute("rate", rate);

        RequestDispatcher rd = request.getRequestDispatcher("convert");
        rd.forward(request,response);
    }
}
