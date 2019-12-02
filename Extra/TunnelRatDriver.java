/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tunnelrat;
import java.util.Date;
import java.io.*;
import java.util.regex.*;
import java.text.*;



public class TunnelRatDriver {
    
    
    
        private static long hoursDifference(Date date1, Date date2) {
            final int MILLI_TO_HOUR = 1000 * 60 * 60;
            return (long) (date1.getTime() - date2.getTime()) / MILLI_TO_HOUR;
        }

        // php equivalent class
        public static String substr(String s,int start, int length) {
            if (length < 0)
                length = s.length()+length;
            if (start < 0)
                start = s.length()+start;
           
            s = s.substring(start,length);
            return s;
        }
        
        // removes key from text puts back string
        public static String implodeLine(String key, String text) {
            String[] split = text.split(key);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < split.length; i++) {
                sb.append(split[i]);
                if (i != split.length - 1) {
                    sb.append(" ");
                }
            }
            return sb.toString();
        }
        
        public static String[] explodeLine(String key, String text) {
            String[] split = text.split(key);
            return split;
        }
    
        // config
        static String regexAuc  =  " auctions, ";
        static String regexOffer = " has offered you a ";  
        static String charname = "Navlaan";
        static String filename = "C:\\Program Files (x86)\\Sony\\EverQuest\\Logs\\eqlog_" + charname + "_P1999Teal.txt";
        static int tsLen = ("[Thu Sep 19 10:30:44 2019]").length();
        int hashLen = 8;
        
        //variables
        static String line, timestamp;
        static String regexItem = "High Quality Bear Skin";
        static String seller, aucMsg, current, previous = " ";
        static String tLine[];
        int aucLineCount = 0;
        // objects        
        StackLinkedList numList = new StackLinkedList();
        static File file = new File(filename); 
        static BST bt = new BST();
        

        
        
      
        
        
        public static void main(String[] args) throws Exception {   
                        
            TunnelRat tr = new TunnelRat();
           
          //  StackLinkedList stl = new StackLinkedList();
            
            // load file
            BufferedReader br = new BufferedReader(new FileReader(file));
                                   
            // scan lines
            while ((line = br.readLine()) != null) {
                //tLine = explodeLine(",", line);
                
            
                //Boolean isMatch = Pattern.matches(key,line);
                //str contains an auction
                if ((line.contains(" auctions, ") == false))
                        continue;
                
                    
                // split timestamp
                timestamp = substr(line,5,tsLen-1).trim();
                //System.out.println(timestamp);
                DateFormat dateFormat = new SimpleDateFormat("MMM dd HH:mm:ss yyyy");
                Date dategame = dateFormat.parse(timestamp);
                Date datecurr = new Date();//dateFormat.format(datecurr));
                
                long diff = datecurr.getTime() - dategame.getTime();            
               // long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000);
                

                
                //System.out.println(diffDays + " days, " + diffHours + " hours, " + diffMinutes + " minutes, ");
                //date.setTime(timestamp);

                    
                // split seller 
                tLine = explodeLine(regexAuc,line);
                seller = substr(tLine[0],tsLen+1,tLine[0].length());

                aucMsg = tLine[1].trim();        
                aucMsg = substr(aucMsg,1,-1);
                 //String line = "Jagged Blade of Mourning 2.5k Sarnak Battle Shield 2k";
                
                
                if ((timestamp.isEmpty()) || (seller.isEmpty()) || (aucMsg.isEmpty()))
                    continue;
                
                // discard e.g. "x20" (can wrongly be interpreted as prices, or in any case price is unknown)
                if (aucMsg.matches("[x\\s?\\d]{1,3}")){
                    System.out.println(aucMsg);
                    continue;    
                }
                
                
                Matcher m = Pattern.compile( "([-_`\'\\sa-zA-Z:]+)[-\\s\\/,;]([0-9\\.kK\\.p]+)")
                       // "/([-_`\'\sa-zA-Z:]+)[-\s\/,;]([0-9\.k]+)/
                        
                        .matcher(aucMsg);
                    
                    
                    
                SimpleDateFormat parser = new SimpleDateFormat("MMM dd hh:mm:ss yyyy");     
                               

                    
                    
             //   System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
             //   System.out.println(aucMsg);
            //    System.out.println("................................................................................................................................");

                while(m.find()) {
                    // get match result object
                    MatchResult result = m.toMatchResult();
                    String item = result.group(1);
                    
                   if(tr.skipItem(item)){
                       continue;
                    }
            
                    item = tr.processItem(item);
                    
                    if(tr.skipItem(item)){
                       continue;
                    }
                   
            
                    String price = result.group(2).replaceAll("p", "").trim();

                        
                    if(price.isEmpty())
                            continue;
                        
                    
                    int p = tr.processPrice(price);                                                    
                      
                    item = tr.replaceItem(item.trim());
                    
                  
                        
                  if ( (item.length() <= 3) )// || (item.length()>30))
                       continue;
                  
                  

                  if(p > 0){
                      bt.insert(item, p, seller, timestamp);                 
                  }
                  
                  //if ((diffHours < 24))
                   // System.out.println("item: " + item + " ; price: " + p);
                  
                }       
           }          
           bt.inorder();
           
        
        SimpleTableDemo table = new SimpleTableDemo(bt.arr); 
          
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                
                table.setAndViewGUI();
            }
        });     
                
               
          
            //numList.printList();
        }
}
