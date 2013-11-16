package login;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import operations.login.ReadUsuario;
import util.date.ConfigDate;
import util.date.OperationFecha;

/**
 *
 * @author Hugo
 */
public class Login extends HttpServlet {


    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        ReadUsuario readUs = new ReadUsuario();
        OperationFecha op = new OperationFecha();
        String strCoo = "";
        int idUsu = 0;
        try {
            idUsu = readUs.existeUsuario(usuario, password);
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        DateFormat dateFormat = new SimpleDateFormat(ConfigDate.format);
        Date date = new Date();
        String now  = dateFormat.format(date);
        String expDate = dateFormat.format(op.sumarDias(date, 1));
        try {
            if(idUsu!=0){
                out.println("{\"auth\":true}");
                strCoo = readUs.makeToken(idUsu, now, expDate, request.getRemoteAddr());
                Cookie cookie = new Cookie("euler", strCoo);
                response.addCookie(cookie);
                session.setAttribute("id_usu", idUsu);
                session.setAttribute("token", strCoo);
                session.setAttribute("auth", true);
                response.sendRedirect("index.jsp");
            }else{
                response.sendRedirect("index.jsp");
                session.setAttribute("auth", false);
                out.println("{\"auth\":false}");
            }
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
