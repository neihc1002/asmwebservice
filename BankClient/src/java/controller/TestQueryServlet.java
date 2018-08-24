/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import client.NewJerseyClient;
import entity.History;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author DuongTK
 */
public class TestQueryServlet extends HttpServlet {

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
       request.getRequestDispatcher("testqueryhistory.jsp").forward(request, response);
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
        NewJerseyClient client = new NewJerseyClient();
        String taikhoankhachhang =request.getParameter("taikhoankhachhang");
        String pin = request.getParameter("pin");
        GenericType<List<History>> type = new GenericType<List<History>>(){};
        String startdate = request.getParameter("startdate");
        String enddate = request.getParameter("enddate");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date start=new Date();
        Date end=new Date();
        try {
            start = formatter.parse(startdate);
            end = formatter.parse(enddate);
        } catch (Exception e) {
        }
        List<History> list = new ArrayList<History>();
        List<History> data=  client.queryHistoryCustomer_XML(type, taikhoankhachhang, new SimpleDateFormat("dd-MMM-yyyy").format(end), pin, new SimpleDateFormat("dd-MM-yyyy").format(start));
        if (data!=null) {
            list = data;
            request.setAttribute("datas", list);
            request.getRequestDispatcher("resultquery.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("queryfail.jsp").forward(request, response);
        }
        
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
