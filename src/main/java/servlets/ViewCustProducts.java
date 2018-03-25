/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import enitiy.Products;
import database.ProductTableOperations;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author M.Gebaly
 */
public class ViewCustProducts extends HttpServlet {

      List<Products> allProducts;
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
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        
        ProductTableOperations productTableOperations = new ProductTableOperations();
         allProducts = productTableOperations.getAllProducts();
        
      List<String> objs = new ArrayList<>();
//        for(int i = 0; i < allProducts.size(); i++){
//            objs.add(createJsonObject(allProducts.get(i)));
//        }
          buildJSONFromVector( allProducts);

        out.print(objs);
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
        //processRequest(request, response);
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
    
    private String createJsonObject(Products m){
        Gson msg = new Gson();
        return msg.toJson(m);
    }
    
      private String buildJSONFromVector(List<Products> products) {
        ObjectMapper objectMapper = new ObjectMapper();

        Iterator<Products> productsIterator = products.iterator();
        List<Products> newProductsList = new ArrayList<>();
        while (productsIterator.hasNext()) {
            Products nextProduct = productsIterator.next();
            Products newProduct = new Products();
            newProduct.setProductQuanitity(nextProduct.getProductQuanitity());
            newProduct.setProductName(nextProduct.getProductName());
            newProduct.setProductImage(nextProduct.getProductImage());
            newProduct.setProductDescription(nextProduct.getProductDescription());
            newProduct.setProductSalary(nextProduct.getProductSalary());
            newProductsList.add(newProduct);
        }
        //Set pretty printing of json
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String arrayToJson = "";
        try {
            arrayToJson = objectMapper.writeValueAsString(newProductsList);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ViewCustProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayToJson;
    }

}
