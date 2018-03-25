/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import controlles.Cart;
import enitiy.Products;
import database.ProductTableOperations;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 *
 * @author Mark
 */
public class AddToCart extends HttpServlet {


    //private static int count  = 0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Cart shoppingCart;
        Integer count = null;
        shoppingCart = (Cart) session.getAttribute("cart");
        count = (Integer) session.getAttribute("count");
        if(shoppingCart == null&&count == null){
          shoppingCart = new Cart();
          count = 0;
          session.setAttribute("cart", shoppingCart);
          session.setAttribute("count", count);
        }
        String productId = request.getParameter("productId");
        System.out.println(productId);
            ProductTableOperations productTableOperations=new ProductTableOperations();
            Products product = productTableOperations.getSpecificProducts(productId);
            //System.out.println(product.getName());
            if(shoppingCart.getCartItems().get(productId)== null)
            {
                shoppingCart.addToCart(productId, product);
                count++;
            }
                
        //System.out.println(count);
        session.setAttribute("cart", shoppingCart);
        session.setAttribute("count", count);
        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>result</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>product successfully added to cart </h1>");
//            out.println("<form action='index.html'>Add more products item<input type='submit' value='go'></form>");
//            out.println("<hr>");
//            out.println("<h2>Cart</h2>");
//            HashMap<String, Integer> items = shoppingCart.getCartItems();
//            out.println("<table border='1px'>");
//             
//            for(String key: items.keySet()){
//                out.println("<tr><td>"+key+" - </td><td>"+"$"+items.get(key)+"</td></tr>");
//            }
//            out.println("<table>");
//            out.println("</body>");
//            out.println("</html>");
              out.write(count+"");
        }        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            
            response.setContentType("application/json");
            HttpSession session = request.getSession();
            Cart shoppingCart;  
            shoppingCart = (Cart) session.getAttribute("cart");
            HashMap<String, Products> items = shoppingCart.getCartItems();
            
            Gson gson = new Gson();
            ArrayList<Products> objs = new ArrayList<>();
            for(String key: items.keySet()){
                objs.add(items.get(key));
                //System.out.println(items.get(key).getName());
            }
            //System.out.println(gson.toJson(objs));
             response.getWriter().write(gson.toJson(objs));
             response.getWriter().close();
            
    }


}
