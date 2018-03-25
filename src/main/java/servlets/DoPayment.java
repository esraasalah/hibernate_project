/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import controlles.Cart;
import enitiy.Products;
import controlles.ProductsInBag;
import controlles.User;
import database.ProductTableOperations;
import database.UserTableOperations;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author toshiba
 */
public class DoPayment extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        
        HttpSession userSession=request.getSession(false);
        User u=(User) userSession.getAttribute("userDate");
        int total_price = (int) userSession.getAttribute("total_price");
        // update user's credit limit in session + database ;
        u.setCridet(u.getCridet() - total_price);
        userSession.setAttribute("userDate", u);
        UserTableOperations uto = new UserTableOperations();
        uto.updateCrediteLimit(u.getId(),u.getCridet());
        
        //String esraa = request.getParameter("products_in_bag");
        //out.print(esraa);
        
        java.lang.reflect.Type listType = new TypeToken<List<ProductsInBag>>() {}.getType();
        Gson gson = new Gson();
        List<ProductsInBag> list = gson.fromJson(request.getParameter("products_in_bag"), listType);
        
        ProductTableOperations pto = new ProductTableOperations();
       
        HttpSession session = request.getSession();
        Cart shoppingCart = (Cart) session.getAttribute("cart");
        
        HashMap<String, Products> items = shoppingCart.getCartItems();
        List<Integer> actual_quans = new ArrayList<>();
        for(String key: items.keySet()){
            Products product = items.get(key);
          //  actual_quans.add(product.getProductQuanitity());
        }
        int i = 0 ;
        // update product quanitity
        for (ProductsInBag p : list){
            int actual_quan = actual_quans.get(i);
            //pto.updateProductById(p.getProduct_id(),actual_quan - p.getQuantity());
            //out.print("product id = "+p.getProduct_id()+" Quanitity = "+p.getQuantity());
            i++;
        }
        
        shoppingCart.removeAll();
        session.setAttribute("cart", shoppingCart);
        session.setAttribute("count", 0);
        //out.print("Done");
        response.sendRedirect("shoppingCart.html");
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
