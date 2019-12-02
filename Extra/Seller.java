/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tunnelrat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;


// keep track of when seller auctioned
public class Seller {
    Hashtable<Integer, String> sellers = new Hashtable<Integer,String>();
    DateFormat dateFormat = new SimpleDateFormat("MMM dd HH:mm:ss yyyy");

    Date datecurr = new Date();//dateFormat.format(datecurr));
    
    public Seller()
    {
        this.sellers = new Hashtable<Integer, String>();        
    }
        
    
    public void add(String sname, String time)
    {
        int key = sname.hashCode();
        
        if(!isHashed(sname))
            sellers.put(key,time);
        else     
            sellers.replace(key,time);
    }
    
    public boolean isHashed(String sname)
    {
        int key = sname.hashCode();
        
        return (sellers.contains(key));
    }
    
    public String getTime(String sname){
        int key = sname.hashCode();
        return sellers.get(key);
    }
    
    public long getHours(String sname)
    {
        try
        {
        Date dategame = dateFormat.parse(getTime(sname));
        long diff = datecurr.getTime() - dategame.getTime();         
        Date datecurr = new Date();//dateFormat.format(datecurr));
            // long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000); 
            
            return diffHours;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }        
        return -1;        
    }

    
}