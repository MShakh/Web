/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

import java.io.File;

/**
 *
 * @author Support
 */
public class FileManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        File docs = new File("documents/");
        String[] files = docs.list();
        
        for (String f : files) {
           System.out.println(f);
        }
    }
    
}
