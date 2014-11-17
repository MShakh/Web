/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Searcher;

/**
 *
 * @author Support
 */
public class Record {
    
    private String docId;
    private int count;
    
    public Record(String docId, int count) {
        this.docId = docId;
        this.count = count;
    }
    
    @Override
    public String toString(){
        return (docId+count);
    }
    
    public String getDocID() {
        return docId;
    }
    
    public int getCount() {
        return count;
    }
}
