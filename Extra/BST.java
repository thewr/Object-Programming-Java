/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tunnelrat;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class BST {
    Node root;
    static int total_count = 0;
   // LinkedList<Integer> numbers = new LinkedList<Integer>();
    static multiArray arr;
    int row = 0;
    

    DateFormat dateFormat = new SimpleDateFormat("MMM dd HH:mm:ss yyyy");

    Date datecurr = new Date();//dateFormat.format(datecurr));
                

    
    //TunnelRat mainObj = new TunnelRat();
    
    public boolean isRecent(Node root)
    {
        try
        {
            Date dategame = dateFormat.parse(root.time);
            long diff = datecurr.getTime() - dategame.getTime();         
            Date datecurr = new Date();//dateFormat.format(datecurr));
            // long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000); 
            
            if ( (diffDays < 4) && (diffHours <= 9))
                return true;
            else 
                return false;          
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }
    
    public void insert(String key, int price, String seller, String time)
    {
        
        root = insert(root, key, price, seller, time);
    }
    
    public static Node insert(Node root, String key, int price, String sname, String time) {

        // if root is null, create new Node object
        if (root == null) {
            ++total_count;
            return new Node(key,price,sname,time);
        }
        
        
        
        
        
        // if item is found inside of tree, add data to item's fields
        if ( key.compareToIgnoreCase(root.item)==0 ) {
            
            // if seller's price has not been recently added, proceed with adding items
            // or if seller has changed their price ... include price change
           
           if(root.dates.isHashed(sname)){
                System.out.println(root.dates.getTime(sname));
            }
            
            if( (! root.sellers.peek().equals(sname))||(root.sellers.peek().equals(sname) && root.prices.peek() != price) ){
                root.addData(price, sname, time);
            }            
            return root;                            
        }
        
        /*
        int LevDist = calcLD(key,root.item);
        if ( LevDist <= 2 ) {
            if( (!root.sellers.peek().equals(seller))||(root.sellers.peek().equals(seller) && root.prices.peek() != price) ){
                root.addData(price, seller);
            }
            
            System.out.println("Replacing /" + key + "/ with /" + root.item + "/");
            return root;  
        }          
        */
        
        
        if (key.compareToIgnoreCase(root.item)<0) {
            root.left = insert(root.left, key, price, sname, time);
        }
        
        else 
            root.right = insert(root.right, key, price, sname, time);
                
        return root;          
      }
    
    
    public void inorder(){
        arr = new multiArray(1550,6);
        inorder(root);
    }
    
    public void inorder(Node root){
        if (root == null) {
            return;
        }
        inorder(root.left);
        //removeOutliers(root);
        if( (root.count >= 5))
        {// & (isRecent(root)) ){
        
        
            double E = 1.65*(root.prices.stdev())/Math.sqrt(root.count);
            //System.out.println("BEFORE:");
            System.out.println(String.format("%n   %s (%d) %2.2f +/- %1.3f", root.item, root.count, root.prices.average(),E));
            String[] in = {
                root.item, 
                new StringBuilder().append(root.count).toString(),                
                new StringBuilder().append((int)root.prices.average()).toString(),
                new StringBuilder().append(root.prices.stdev()).toString(),
                new StringBuilder().append(root.prices.min).toString(),
                new StringBuilder().append(root.prices.max).toString()};
                                
            arr.setRow(row, in);
            row++;
            root.prices.printStats();
            //root.prices.sort();
            root.prices.printPrices();
            //System.out.println("AFTER:");
            
            //root.prices.printStats();
            //root.prices.printPrices();
        }
        inorder(root.right);       
    }
    
    
   /*
    public void buildArray(){
        int row  = 0;
        buildArray(root,row);
    }
    
    public void buildArray(Node root,int row){
       // arr = new multiArray(total_count,1);
        if (root == null) {
            return;
        }

        buildArray(root.left,row);
        if(root.count > 100) {
            arr.setRow(row, root.item);
            row++;
        }
        buildArray(root.right,row);      
    }
    */
    
    public void removeOutliers(Node root)
    {
        Statistics tmp = new Statistics();
        double m = root.prices.average();
        double s = root.prices.stdev();
        
        while(! root.prices.isEmpty())
        {
            int x = root.prices.pop();
            double z = Math.abs((x-m)/s);
            if(z < 2.5)         
                tmp.push(x);
        }
        
        root.prices = tmp;
        
    }  
    
    public long getTotalSize() {
        return total_count;
    }
}
