/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodkoala.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lendle
 */
@WebServlet(name = "AddOrderServlet", urlPatterns = {"/addOrder"})
public class AddOrderServlet extends HttpServlet {

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
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        List<String> foodList = new ArrayList<String>();
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddOrderServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            String food=request.getParameter("food");
            //不知為何無法使用以下兩行，無法使用List
            //List<String> foodList = new ArrayList<String>();
            foodList.add(food);
            
            HttpSession session=request.getSession();
            session.setAttribute(" foodList", foodList);       
            response.sendRedirect("list.jsp");
          
            
             Enumeration<String> en=request.getParameterNames();
            while(en.hasMoreElements()){
                String name=en.nextElement();
                String[] sours =request.getParameterValues(name);
               
            }
            out.println("</body>");
            out.println("</html>");
            
      
        } finally {
            out.close();
        }
        /*
        question 5 (30%)
        取得 session 物件，接收 user 傳來的 food 參數，
        將參數儲存到 session 物件裏面（你會需要將其儲存到一個 ArrayList 裏面，因爲會有多個 food）
        
        question 6 (10%)
        最後外轉址到 list.jsp
        */
   
        
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
