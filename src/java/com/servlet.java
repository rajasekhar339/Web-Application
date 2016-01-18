/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author miracle
 */
public class servlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           String str = request.getParameter("n1");
            String str1 = request.getParameter("n2");
            out.println(str);
            out.println(str1);
            Class.forName("com.mysql.jdbc.Driver");
            out.println("Driver estb");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/raj", "rajasekhar", "honey");
            if(con!=null)
            out.println("connection estb");
            else
                out.println("not establsished");
           Statement stmt = con.createStatement();
           ResultSet rs=stmt.executeQuery("select * from student where username='"+str+"' password='"+str1+"'");
            if(rs!=null)
            out.println("stmt excecuted");
            else
                out.println("Failed");
            } catch (SQLException ex) {
            out.println("ex");
            }catch (ClassNotFoundException ex1){
                out.println("ex1");
        
        } finally {            
            out.close();
        }
    }
}