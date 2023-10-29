/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.usuarios;
import java.sql.SQLException;
import validacion.validando;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author José Arévalo
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {
    
    public LoginController(){
        System.out.println("Entro");
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
                   /* TODO output your page here. You may use following sample code. */
                   PrintWriter out = response.getWriter();
            usuarios u=new usuarios(){};
            validando lg= new validando();
            int rspta=0;
     
            
            if (request.getParameter("btn-login")!=null){
                String usuario=request.getParameter("txt_usuario");
                String clave = request.getParameter("txt_clave");
                u.setUsuario(usuario);
                u.setClave(clave);
                try{
                    
                rspta = lg.validarlogin(u);
                }   catch (Exception ex){
                    System.out.println(ex.getMessage());
                    
                }
                if(rspta==1){
                    response.sendRedirect("menu.jsp");
                }else{
                    response.sendRedirect("index.jsp");
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}


