/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Searcher;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Support
 */
public class Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter res = response.getWriter();
        String input = request.getParameter("input");
        if (input != ""){
            Searcher sear = Searcher.getInstance();
            Scanner sc = new Scanner(input);
            String firstword = sc.next();
            List<Record> filenames1 = sear.search(firstword);
            if(sc.hasNext()){
                String secondword = sc.next();
                List<Record> filenames2 = sear.search(secondword);
                if(filenames1 == null || filenames2 == null ){
                    res.println("This word does not exist in dictionary!");
                return;
                }
                List<String> filenames = sear.intersect(filenames1, filenames2);
                for(String r:filenames){
                    res.println(r);
                }
            } else if(filenames1 != null){
                for(Record r:filenames1){
                res.println(r.getDocID());
                }
            } else 
                res.println("This word does not exist in dictionary!");
        } else 
            res.println("Enter the word please!");           
    }
}
