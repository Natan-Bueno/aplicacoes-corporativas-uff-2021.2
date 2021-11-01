/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;


/**
 *
 * @author viter
 */
@WebServlet("/alomundo")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String msg = "";
        String msg2 = "";
        String bd = "";
        String bt = "";
        String bn = "";
        String trt ="";
        String cor_fundo = "background-color:" + request.getParameter("cor-fundo") + ";";
        String trat = request.getParameter("Trat");
        String lang = request.getParameter("lang");
        if(lang==null)
            lang = "pt";
        switch(lang){
            case "pt":
                msg = "Olá ";
                msg2 = "Seja bem vindo ao nosso site!";
                bd = "bom dia";
                bn="boa noite";
                bt="boa tarde";
                if("sr".equals(trat)){
                    trt = "Sr ";
                }else if ("sra".equals(trat)){
                    trt = "Sra ";
                }else{
                    trt = "";
                }
                break;
            case "en":
                msg = "Hello ";
                msg2="Welcome to our website!";
                bd = "good Morning";
                bn="good night";
                bt="good afternoon";
                if("sr".equals(trat)){
                    trt = "Mr ";
                }else if ("sra".equals(trat)){
                    trt = "Ms ";
                }else{
                    trt = "";
                }
                break;
            case "fr":
                msg = "Salut ";
                msg2="Bienvenue sur notre site!";
                bd = "bonjour";
                bn="bonne nuit";
                bt="bon après-midi";
                if("sr".equals(trat)){
                    trt = "M. ";
                }else if ("sra".equals(trat)){
                    trt = "Mme. ";
                }else{
                    trt = "";
                }
                break;
            case "de":
                msg = "Hallo ";
                msg2="Willkommen auf unserer Webseite!";
                bd = "guten morgen";
                bn="gute nacht";
                bt="guten tag";
                if("sr".equals(trat)){
                    trt = "Mr ";
                }else if ("sra".equals(trat)){
                    trt = "Mrs ";
                }else{
                    trt = "";
                }
                break;
            case "hl":
                msg = "Hallo ";
                msg2="Welkom op onze website!";
                bd = "goedemorgen";
                bn="goedenacht";
                bt="goedenmiddag";
                if("sr".equals(trat)){
                    trt = "Dhr ";
                }else if ("sra".equals(trat)){
                    trt = "Mevr ";
                }else{
                    trt = "";
                }
                break;
            case "es":
                msg = "Hola ";
                msg2="¡Bienvenido a nuestro sitio web!";
                bd = "buen día";
                bn="buenas noches";
                bt="buenas tardes";
                if("sr".equals(trat)){
                    trt = "Sr. ";
                }else if ("sra".equals(trat)){
                    trt = "Sra. ";
                }else{
                    trt = "";
                }
                break;
        }
        
        Calendar cal = Calendar.getInstance();
	String horario = "";
        int hora = cal.get(Calendar.HOUR_OF_DAY);
        
       
	if(hora < 12 ) {
		horario = bd;
	}else if(hora >= 12 && hora < 19) {
		horario = bt;
	}else {
		horario = bn;
	}		   
        
        
        
        String nome = request.getParameter("nome");

        if(nome.trim()==null)
            nome = "Fulano";
        
        msg = lang+" "+msg+trt+nome+". "+horario+".<br><br>"+msg2;

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html style="+cor_fundo+"");
            out.println("<head>");
            out.println("<title >Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 >Servlet</h1>");
            out.println("<p style=\"font-family:verdana;\">" + msg + "</p>");
            out.println("</body>");
            out.println("</html>");
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
