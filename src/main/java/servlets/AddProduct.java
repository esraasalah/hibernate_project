/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import enitiy.Products;
import database.ProductTableOperations;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author IbrahimDesouky
 */
public class AddProduct extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddProduct</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddProduct at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        processRequest(request, response);
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
        String productName="",productDescription="";
            int productQuantity=0,productPrice=0;
            String imageName="";
            PrintWriter out = response.getWriter();
        try  {
            
            if(!ServletFileUpload.isMultipartContent(request)){
                out.println("Nothing to upload");
                return; 
            }
            
            
            
            
            
         DiskFileItemFactory factory = new DiskFileItemFactory();
            
            //Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);
            
            
           List<FileItem> items = upload.parseRequest(request);
        for (FileItem item : items) {
            if (item.isFormField()) {
                // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
                String fieldName = item.getFieldName();
                String fieldValue = item.getString();
                if(fieldName.equals("productname")){
                    productName=fieldValue;
                    //out.println(productName);
                }else if(fieldName.equals("productdescription")){
                    productDescription=fieldValue;
                    //out.println(productDescription);
                }else if(fieldName.equals("productquan")){
                    productQuantity=Integer.parseInt(fieldValue);
                    //out.println(productQuantity);
                }else if(fieldName.equals("productprice")){
                    productPrice=Integer.parseInt(fieldValue);
                    //out.println(productPrice);
                    
                }
                
                // ... (do your job here)
            } else {
                // Process form file field (input type="file").
                String fieldName = item.getFieldName();
                if(fieldName.equals("productimage")){
                   imageName = "images/"+FilenameUtils.getName(item.getName());
                   //out.println(imageName);
                   String savingPath = "F:\\ITI\\Servlet & JSP-20180204T105849Z-001\\New Folder\\E_Commerce_Servlet_And_JSP-\\src\\main\\webapp\\images\\";
                    ServletContext context = request.getServletContext();
                    String fullPath = context.getRealPath("/images/");
                    System.out.println(fullPath+item.getName());
                   item.write(new File(fullPath+item.getName()));
                       
                
                }
                
                
                // ... (do your job here)
            }
            
        }
    } catch (FileUploadException e) {
        throw new ServletException("Cannot parse multipart request.", e);
    }   catch (Exception ex) {
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        Products product=new Products();
            product.setProductImage(imageName);
            product.setProductName(productName);
            product.setProductDescription(productDescription);
            product.setProductQuanitity(new BigDecimal(productQuantity).setScale(1));
            product.setProductSalary(new BigDecimal(productPrice).setScale(1));
            
            ProductTableOperations productTableOperations=new ProductTableOperations();
            productTableOperations.addProduct(product);
            response.sendRedirect("manage_product.html");
        
        
        
       
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
