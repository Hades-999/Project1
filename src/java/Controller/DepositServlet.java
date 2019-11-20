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
public class DepositServlet extends HttpServlet {

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
            String accno=request.getParameter("accno");
            String income=request.getParameter("income");
            int inc=Integer.parseInt(income);
            String transfer=request.getParameter("transfer");
            Account a=new Account();
            a.setAccno(accno);
            AccountDAO ad=new AccountDAO();
            Account a2=ad.search(a);
            if(a2!=null){
                String camt=a2.getCurrentamt();
                int ca=Integer.parseInt(camt);
                String samt=a2.getSavingsamt();
                int sa=Integer.parseInt(samt);
                if(transfer.equals("yes")){
                    sa=sa+ca;
                    ca=inc;
                }
                else{
                    ca=ca+inc;
                }
                String camt2=Integer.toString(ca);
                String samt2=Integer.toString(sa);
                Account a3=new Account();
                a3.setAccno(accno);
                a3.setCurrentamt(camt2);
                a3.setSavingsamt(samt2);
                ad.delete(a2);
                response.sendRedirect("DisplayDeposit");
            }
            else{
                out.println("<script>alert('Transaction failed!');</script>");
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
