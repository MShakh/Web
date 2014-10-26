/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Support
 */
public class Searcher {
       private Dictionary dict;
       
       public Searcher() {
           dict = new Dictionary();
       }
       
       public void init() {
           File docs = new File("documents/");
           String[] files = docs.list();
           
           for(String filename : files) {
               System.out.println(filename);
                TreeMap<String, Integer> words = new TreeMap<>();
                try {
                   File file = new File("documents/"+filename);
                   Scanner in = new Scanner(file).useDelimiter("\\p{Punct}| |\\n");
                   while(in.hasNext()) {
                       String t = in.next();
                       int result = words.containsKey(t) ? words.get(t) + 1 : 1;
                       words.put(t, result);
                   }
                   in.close();
               } catch (FileNotFoundException ex) {
                   System.err.println("Suddenly "+filename+" not found");
                }
                for (String key : words.keySet()) {
                    System.out.printf("(%s, %d)\n", key, words.get(key));
                }
           }
       }
}
