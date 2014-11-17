/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

import java.io.File;
import java.util.List;

/**
 *
 * @author Support
 */
public class FileManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Searcher searcher = Searcher.getInstance();
       // System.out.println(searcher.size());
        List<Record> result = searcher.search("cyclone");
        for(Record r:result){
            System.out.println(r.getDocID());
        }
    }
    
}
