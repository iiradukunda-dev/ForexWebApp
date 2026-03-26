package com.forexbridge;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

//@WebServlet("/currency")
public class CurrencyServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String amountStr = request.getParameter("amount");
        String source = request.getParameter("source");
        String target = request.getParameter("target");

        try{

            double amount = Double.parseDouble(amountStr);

            if(amount <= 0){
                response.sendError(400,"Invalid amount");
                return;
            }

            request.setAttribute("amount", amount);
            request.setAttribute("source", source);
            request.setAttribute("target", target);

            RequestDispatcher rd = request.getRequestDispatcher("rate");
            rd.forward(request,response);

        }catch(Exception e){

            response.sendError(400,"Invalid number");

        }
    }
}