/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Support
 */
public class Dictionary {
    
    private Map<String, List<Record>> dict;
    
    public Dictionary() {
        dict = new HashMap<>();
    }
}
