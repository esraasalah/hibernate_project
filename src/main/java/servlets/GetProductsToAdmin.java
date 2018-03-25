/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.google.gson.Gson;
import enitiy.Users;
import database.ProductTableOperations;
import database.UserTableOperations;
import enitiy.Products;
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
public class GetProductsToAdmin extends HttpServlet {

  
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        // get all users from database :
          if(request.getAttribute("notfound").equals("yes")){
            String obj = "{\"yes\":\"yes\"}";
            out.print(obj);
            System.out.println("ooooooooo");
        }else{
              ProductTableOperations pto = new ProductTableOperations();
        List<Products> products = pto.getAllProducts();
          
        List<String> objs = new ArrayList<String>();
        for(int i=0;i<products.size();i++){
            objs.add(createJsonObject(products.get(i)));
        }
        out.print(objs);  
          }
          
    }
          
    /**
     *
     *
     * @param m
     * @return
     */
    public String createJsonObject(Products m){
        Gson msg = new Gson();
        return msg.toJson(m);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
    
}
