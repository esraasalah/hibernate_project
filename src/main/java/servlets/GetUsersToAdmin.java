/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.google.gson.Gson;
import controlles.User;
import database.UserTableOperations;
import enitiy.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author toshiba
 */
public class GetUsersToAdmin extends HttpServlet {


   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        if(request.getAttribute("notfound").equals("yes")){
            String obj = "{\"yes\":\"yes\"}";
            out.print(obj);
            System.out.println("ooooooooo");
        }else{
            System.out.println("nnnnnnnnnnnnn");
            // get all users from database :
            UserTableOperations uto = new UserTableOperations();
            List<Users> users = uto.retriveAllUsers();

            List<String> objs = new ArrayList<String>();
            for (int i = 0; i < users.size(); i++) {
             //   objs.add(createJsonObject(users.get(i));
            }
            out.print(objs);
        }
    }
    
    private String createJsonObject(User m){
        Gson msg = new Gson();
        return msg.toJson(m);
    }
    private String createJsonString(String m){
        Gson msg = new Gson();
        return msg.toJson(m);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
