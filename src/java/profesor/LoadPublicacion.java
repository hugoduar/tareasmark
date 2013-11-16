/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package profesor;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.publicacion.PublicacionFisica;
import operations.publicacion.StorePublicacion;

/**
 *
 * @author Hugo
 */
public class LoadPublicacion extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoadPublicacion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoadPublicacion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    

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
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        String idGpo = request.getParameter("sel_idGpo");
        String titulo = request.getParameter("inp_titulo");
        String fecha_entrega = request.getParameter("inp_fecha_entrega");
        String descripcion = request.getParameter("inp_descripcion");
        String tipo = request.getParameter("sel_tipo");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        
        HttpSession session  = request.getSession();
        if(tipo.equals("FISICA")){
            StorePublicacion stPub = new StorePublicacion();
            PublicacionFisica pub = new PublicacionFisica(titulo, descripcion, 
                    fecha_entrega, dateFormat.format(date), 
                    (Integer)session.getAttribute("id_pro"), 
                    Integer.parseInt(idGpo));
            
                    try {
                        boolean exito = stPub.savePublicacionFisica(pub);
                        if(!exito) {
                            out.print("{\"mensaje\":\"error en la operacion\"}");
                        }
                        else {
                            out.print("{\"mensaje\":\"Operación exitosa\"}");
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(LoadPublicacion.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }else{
            out.print("{\"mensaje\":\"error en los datos\"}");
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
    }
}
