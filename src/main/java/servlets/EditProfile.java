/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controlles.User;
import database.UserTableOperations;
import enitiy.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Esraa
 */
public class EditProfile extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
          String newPassword ;
                       
          
          
          HttpSession userSession=request.getSession(false);

           Users u=null;
       
        String name= request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String creditLimit= request.getParameter("creditLimit");
        String job = request.getParameter("job");
         String oldPassword = request.getParameter("oldPassword");
         if(request.getParameter("newPassword")==""){
                 u=(Users) userSession.getAttribute("userDate");
                 
                 newPassword=u.getUserPassword();      
         }
         else
         {
            newPassword = request.getParameter("newPassword");
                 
         }
          
        String birthDate=u.getBirthdate().toString();
        
        double creditLimitNumber=Double.parseDouble(creditLimit);
                        
            //User user=new User(name, birthDate, email, newPassword, job, creditLimitNumber, address, 0);
            Users user = new Users();
            user.setUserName(name);
           user.setUserEmail(email);
            user.setUserAddress(address);
            user.setBirthdate(new Date(birthDate));
            user.setUserJob(job);
            user.setUserPassword(newPassword);
            user.setCreditLimit(new BigDecimal(creditLimitNumber));
            
            
            
             
                //userSession.removeAttribute("userDate");
                 userSession.setAttribute("userDate", user);
                
           
            UserTableOperations userTableOperations=new UserTableOperations();
              boolean result=userTableOperations.editeUser(user);
               if(result){
                    
                    response.sendRedirect("login.html");
              
               
                }else{
                   
                     response.sendRedirect("profile.jsp");
                
               }
               
        
        }
             
             
             
     
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
         response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
         
          HttpSession userSession=request.getSession(false);
       
           String oldPassword = request.getParameter("oldpassword");// request
           out.println(oldPassword);
        
           User myUser=(User)  userSession.getAttribute("userDate");
      
             String password=myUser.getPassword(); // session 
           out.println(password);
       
       if(oldPassword.equals(password)|| oldPassword=="")
       {
       
        response.getWriter().write("true");
            
       
       }
       else
       {
       
       response.getWriter().write("false");
       
       
       }

    }
    
    
     
    
    
    
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
                
                
                
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
