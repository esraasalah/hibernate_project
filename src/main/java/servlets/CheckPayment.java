/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controlles.User;
import database.ProductTableOperations;
import database.UserTableOperations;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author toshiba
 */
public class CheckPayment extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int total_price = Integer.parseInt(request.getParameter("total_price"));
        
        HttpSession userSession=request.getSession(false);
        User u=(User) userSession.getAttribute("userDate");
        int user_id = u.getId();
        
        UserTableOperations uto = new UserTableOperations();
        boolean canBuy = uto.checkCreditLimit(total_price,user_id);
        if(canBuy == true){
            userSession.setAttribute("total_price", total_price);
        }
        PrintWriter out = response.getWriter();
        out.print(canBuy);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
