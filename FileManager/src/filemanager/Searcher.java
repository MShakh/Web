/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
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
           
           // This cycle is for every file in our pool
           for(String filename : files) {
               System.out.println(filename);
               
               // Consists of words and times words were met.
                TreeMap<String, Integer> words = new TreeMap<>();
                try {
                   File file = new File("documents/"+filename);
                   // Delimiters are punctuational signs, space and '\n'
                   Scanner in = new Scanner(file).useDelimiter("\\p{Punct}| |\\n");
                   while(in.hasNext()) {
                       String t = in.next().toLowerCase();
                       int result = words.containsKey(t) ? words.get(t) + 1 : 1;
                       words.put(t, result);
                   }
                   in.close();
                } catch (FileNotFoundException ex) {
                   System.err.println("Suddenly "+filename+" not found");
                }
                
                
                for (String key : words.keySet()) {
                    System.out.printf("(%s, %d)\n", key, words.get(key));
                    
                    Record rec = new Record(filename, words.get(key));
                    dict.put(key, rec);
                }
           }
       }
       public List<Record> search(String word){
           return dict.search(word);
       }
       
       public int size() {
           return dict.size();
       }
}
