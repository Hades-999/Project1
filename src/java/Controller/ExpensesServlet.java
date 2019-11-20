/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AccOps.Account;
import Model.AccOps.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
public class ExpensesServlet extends HttpServlet {

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
            String accno=request.getParameter("accno");			
            String ebill=request.getParameter("ebill");
            int b = Integer.parseInt(ebill);
            String lbill=request.getParameter("lbill");
            int c = Integer.parseInt(lbill);
            String carbill=request.getParameter("carbill");
            int d = Integer.parseInt(carbill);
            String obill=request.getParameter("obill");
            int e = Integer.parseInt(obill);
            String tax=request.getParameter("tax");
            int f = Integer.parseInt(tax);
            int expense=b+c+d+e+f;
            Account a=new Account();
            a.setAccno(accno);
            AccountDAO ad=new AccountDAO();
            Account a2=ad.search(a);
            if(a2!=null){
                String amt=a2.getCurrentamt();
                int num=Integer.parseInt(amt)-expense;
                String amt2=Integer.toString(num);
                Account a3=new Account();
                a3.setAccno(a2.getAccno());
                a3.setCurrentamt(amt2);
                a3.setSavingsamt(a2.getSavingsamt());
                ad.save(a3);
                response.sendRedirect("DisplayExpenses");
            }
            else{
                out.println("<script>alert('transaction failed'");
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
