/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Support
 */
public class Dictionary {
    
    // Key is a word, value is list of pairs (document, times word was met)
    private Map<String, List<Record>> dict;
    
    public Dictionary() {
        dict = new HashMap<>();
    }

    public void put(String word, Record rec) {
        List lrec = dict.get(word);
        if (lrec == null) {
            lrec = new ArrayList<>();
        }
        dict.put(word, lrec);
        lrec.add(rec);       
    }
    public List<Record> search(String word){
        return dict.get(word);
    }
    
    public int size() {
        return dict.size();
    }
}
