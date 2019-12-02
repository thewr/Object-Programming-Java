/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tunnelrat;

import java.util.Hashtable;
import java.util.Arrays;

/**
 *
 * @author Thewbacca
 */    

public class TunnelRat {
    
    static String[] names1 = new String[66];
    static String[] names2 = new String[66];
    static Hashtable<Integer, String> h = new Hashtable<Integer, String>(); 
    static String[] a_names = {"A Broom", "A Stein","A Gypsy Medallion","A Stone Key","A Yellow Whip"};

    TunnelRat(){
        
        names1[0] = "GEB";                      names2[0] = "Golden Efreeti Boots";
        names1[1] = "SSOY";                     names2[1] = "Short Sword of the Ykesha";
        names1[2] = "HQ Bear Skin";             names2[2] = "High Quality Bear Skin";
        names1[3] = "Hand Made Backpacks";      names2[3] = "Hand Made Backpack";
        names1[4] = "A Dark Reaver";            names2[4] = "Dark Reaver";
        names1[5] = "Plat Ruby Veil";           names2[5] = "Platinum Ruby Veil";
        names1[6] = "jade prod";                names2[6] = "Jade Chokidai Prod";
        names1[7] = "zombie skins";             names2[7] = "Zombie Skin";
        names1[8] = "Zombie skin";              names2[8] = "Zombie Skin";
        names1[9] = "LP";                       names2[9] = "Leather Padding";
        names1[10] = "Sow pot";                 names2[10] = "10 Dose Blood of the Wolf";
        names1[11] = "Sow Potion";              names2[11] = "10 Dose Blood of the Wolf";
        names1[12] = "SoW potions";             names2[12] = "10 Dose Blood of the Wolf";
        names1[13] = "Sow pots";                names2[13] = "10 Dose Blood of the Wolf";
        names1[14] = "Wort pots";               names2[14] = "Potion of Stinging Wort";
        names1[15] = "Zheart";                  names2[15] = "Zlandicar's Heart";
        names1[16] = "Z Heart";                 names2[16] = "Zlandicar's Heart";
        names1[17] = "J Boot";                  names2[17] = "Journeyman's Boots";
        names1[18] = "Bag of Sewn Evil Eye";    names2[18] = "Bag of Sewn Evil-Eye";        
        names1[19] = "Lumi Staff";              names2[19] = "Luminescent Staff";
        names1[20] = "Jboots MQ";               names2[20] = "Journeyman's Boots";
        names1[21] = "Orb Of Infitie Void";     names2[21] = "Orb Of the Infitie Void";
        names1[22] = "peggy cloak";             names2[22] = "Pegasus Feather Cloak"; 
        names1[23] = "skull shaped barbute";    names2[23] = "Skullshaped Barbute";
        names1[24] = "Coldain Heads";           names2[24] = "Coldain Head";
        names1[25] = "Yew Leaves";              names2[25] = "Yew Leaf";
        names1[26] = "giant warrior helmets";   names2[26] = "Giant Warrior Helmet";
        names1[27] = "Giant Warrior Helm";      names2[27] = "Giant Warrior Helmet";
        names1[28] = "Fungi Tunic";             names2[28] = "Fungus Covered Scale Tunic";
        names1[29] = "Fungy";                   names2[29] = "Fungus Covered Scale Tunic";
        names1[30] = "fungi staff";             names2[30] = "Fungi Covered Great Staff";
        names1[31] = "Fungi staff";             names2[31] = "Fungi Covered Great Staff";
        names1[32] = "fungi";                   names2[32] = "Fungus Covered Scale Tunic";
        names1[33] = "Black pearls";            names2[33] = "Black Pearl"; 
        names1[34] = "Thurg Plate Helm";        names2[34] = "Corroded Plate Helmet";
        names1[35] = "thurg plate legs";        names2[35] = "Corroded Plate Greaves";
        names1[36] = "Thurg plate legs";        names2[36] = "Corroded Plate Greaves";
        names1[37] = "TBB";                     names2[37] = "Thick Banded Belt";
        names1[38] = "Lodi Shield";             names2[38] = "Lodizal Shell Shield";
        names1[39] = "High Quality Bear Skins"; names2[39] = "High Quality Bear Skin";
        names1[40] = "Flawless Diamonds";       names2[40] = "Flawless Diamond";
        names1[41] = "Dose Blood of the Wolf";  names2[41] = "10 Does Blood of the Wolf";
        names1[42] = "Dose Greater Null Potion";            names2[42] = "10 Dose Greater Null Potion";
        names1[43] = "Dose Greater Potion of Purity";       names2[43] = "10 Dose Greater Potion of Purity";
        names1[44] = "Dose Kilva's Blistering Flesh";       names2[44] = "10 Dose Kilva's Blistering Flesh";    
        names1[45] = "Dose Kilva's Skin of Flame";          names2[45] = "10 Dose Kilva's Skin of Flame";
        names1[46] = "Dose Potion of Aquatic Haunt";        names2[46] = "10 Dose Potion of Aquatic Haunt";
        names1[47] = "Dose Potion of Stinging Wort";        names2[47] = "10 Dose Potion of Stinging Wort";
        names1[48] = "crusty bracer";                       names2[48] = "Crustacean Shell Bracers";
        names1[49] = "Crystal Chitin Chest";                names2[49] = "Crystal Chitin Chestguard";
        names1[50] = "FBSS";                                names2[50] = "Flowing Black Silk Sash";
        names1[51] = "Giant Warrior Helmets";               names2[51] = "Giant Warrior Helmet";
        names1[52] ="Woodman's Staff";                      names2[52] = "Woodsman's Staff";
        names1[53] = "adamantite band";                     names2[53] = "Adamantite Armband";
        names1[54] = "SCHW";                                names2[54] = "Silver Chitin Hand Wraps";
        names1[55] = "Bio Orb";                             names2[55] ="Bioluminescent Orb";
        names1[56] = "HQ Bear Pelts";                       names2[56] ="High Quality Bear Skin";
        names1[57]="HQ Bear Skins";                         names2[57] ="High Quality Bear Skin";
        names1[58] = "HQ Bear Pelts";                       names2[58] ="High Quality Bear Skin";
        names1[59] = "Kael Corroded plate bp";              names2[59] = "Corroded Plate Breastplate";    
        names1[60] = "lammy";                               names2[60] = "Lamentation";
        names1[61] = "Jboot";                               names2[61] = "Journeyman's Boots";
        names1[62] = "Jboots";                              names2[62] = "Journeyman's Boots";
        names1[63] = "J boots";                              names2[63] = "Journeyman's Boots";
        names1[64] = "J-boots";                              names2[64] = "Journeyman's Boots";
        names1[65] = "stein of moggok";                      names2[65] = "Stein of Moggok";


        
       //names1[55] = "J Boot";               names2[55] = "Journeyman's Boots";
        //names1[55] = "J boots";               names2[55] = "Journeyman's Boots";
        //names1[55] = "J boots";               names2[55] = "Journeyman's Boots";



        
        
        for(int i = 0; i < names1.length; i++){
            h.put(names1[i].toLowerCase().hashCode(),names2[i]);
        }
    }
    
    
    
    
        public String replaceItem(String itemName){  
            
            int key = itemName.toLowerCase().hashCode();
            
            if (h.containsKey(key)) 
                return h.get(key);
              
            return itemName;
        }
        
        
        static int calcLD(String x, String y) {
            int[][] dp = new int[x.length() + 1][y.length() + 1];

            for (int i = 0; i <= x.length(); i++) {
                for (int j = 0; j <= y.length(); j++) {
                    if (i == 0) {
                        dp[i][j] = j;
                    }
                    else if (j == 0) {
                        dp[i][j] = i;
                    }
                    else {
                        dp[i][j] = min(dp[i - 1][j - 1] 
                         + costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)), 
                          dp[i - 1][j] + 1, 
                          dp[i][j - 1] + 1);
                    }
                }
            }

            return dp[x.length()][y.length()];
        }
    
    
    public static int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }
 
    public static int min(int... numbers) {
        return Arrays.stream(numbers)
          .min().orElse(Integer.MAX_VALUE);
    }
    
    public int processPrice(String price){
                    int p;  
                    double factor = 1.0;                                 
                    if (price.matches(".*(k|K).*")) {                      
                        factor = 1000.0;
                        
                        if (price.endsWith("."))
                            price = price.replace(".","");
                                
                        if (price.endsWith("k"))
                            price = price.replace("k","");      

                            
                        if (price.endsWith("K"))
                            price = price.replace("K","");
                        

                        // if price contains decimal, find location
                        // and get factor then exit search
                        char[] keys = {'.',','};
                        for(char key : keys)
                        {
                            if (price.contains(String.valueOf(key)))
                            {
                                for(int i=0; i < price.length(); i++)
                                {
                                    if(price.charAt(i)==key)
                                    {
                                        factor = 1000.0/Math.pow(10,i);
                                        price = price.replace(".","");
                                        break;
                                    }
                                }
                            }
                        }                    
                    }   
                    
                    if (price.isEmpty())
                        return -1;
                    
                    
                    char[] keys = {'.','K','k'};
                    for(char key : keys)
                    {
                        if(price.contains(String.valueOf(key)))
                            return -1;
                        
                    }

                    p = Integer.parseInt(price);
                    p *= factor;
                    
                    //if(p<10)
                     //   return -1;
                    
                    return p;
    }
        
        
    public String processItem(String itemName) {
        Boolean flag = true;
        
        while(flag)
        {
            String itemNameOld = itemName;
            
            itemName = itemName.replaceAll("(?i)((^wts)|(^wtt)|(^wtb)|(^obo)|(only)|(^selling)|(piece)|(buying))(?-i)","").trim();                                   
            itemName = itemName.replaceAll("(^['\"p|-]+[\\s]+)","").trim();      
            itemName = itemName.replaceAll("(PP)", "").trim(); 
            itemName = itemName.replaceAll("(^x)","").trim();  
            itemName = itemName.replaceAll("((^T)(\\s))","").trim(); 
            itemName = itemName.replaceAll("((^-)|^:)+","").trim();
            
            if(itemName.matches("((.*)(\\s)(x))"))
                itemName = itemName.substring(0,itemName.length()-1);
            
            
            if(itemName.matches("((.*)(\\s)(x))"))
                itemName = itemName.substring(0,itemName.length()-1);
            
            if(itemName.matches("(.*)(offering)"))
                itemName = itemName.substring(0,itemName.length()-"offering".length());
            
            if(itemName.matches("(.*)(--)"))
                itemName = itemName.substring(0,itemName.length()-"--".length());

            if(itemName.matches("(.*)(-)"))
                itemName = itemName.substring(0,itemName.length()-"-".length());
                                                         
            if(itemName.matches("((.*)(?i)(\\s)(mq)(?-i)($))"))                             
                itemName = itemName.substring(0,itemName.length()-"mq".length());
                 
            //remove from back
            if(itemName.matches("((.*)(?i)(\\s)(stacks)(?-i)($))"))                             
                itemName = itemName.substring(0,itemName.length()-"stacks".length());
            
            //remove from back
            if(itemName.matches("((.*)(?i)(\\s)(paying)(?-i)($))"))                              
                itemName = itemName.substring(0,itemName.length()-"paying".length());
            
            if(itemName.matches("((.*)(?i)(\\s)(payin)(?-i)($))"))                              
                itemName = itemName.substring(0,itemName.length()-"payin".length());
            
            if(itemName.matches("((.*)(?i)(\\s)(for)(?-i)($))"))                              
                itemName = itemName.substring(0,itemName.length()-"for".length());
            
            if(itemName.matches("((?i)(^stacks)(?-i)(.*))"))  
                itemName = itemName.substring("stacks".length(),itemName.length());
           
            if(itemName.matches("((?i)(^stack)(?-i)(.*))"))   
                itemName = itemName.substring("stack".length(),itemName.length());
                 
            if(itemName.matches("((?i)(^of)(\\s)(?-i)(.*))")){    
                      itemName = itemName.substring("of".length(),itemName.length());
            }
            
            if(itemName.matches("((?i)(^k)(\\s)(?-i)(.*))")){    
                      itemName = itemName.substring("k".length(),itemName.length());
            }
                
            if(itemName.matches("((?i)(^plat)(?-i)(\\s)(.*))")){    
                      itemName = itemName.substring("plat".length(),itemName.length());
            }
            
            if(itemName.matches("((?i)(^of)(?-i)(\\s)(.*))")){    
                      itemName = itemName.substring("of".length(),itemName.length());
            }  
                     
            if (itemName.matches("((^p)(\\s)(.*))")){
                    itemName = itemName.substring(0,itemName.length()-1);
            }

            if (itemName.matches("((^ea)(\\s)(.*))"))
                  itemName = itemName.substring("ea".length(),itemName.length());
            

             if ( itemName.matches("((?i)(^each)(?-i)(.*))") ){
               // System.out.println(aucMsg);
                    itemName = itemName.substring("each".length(),itemName.length());
            }

            if ( itemName.matches("((?i)(^and)(?-i)(\\s)(.*))") ){
               // System.out.println(aucMsg);
                    itemName = itemName.substring("and".length(),itemName.length());
            }                   
            
            if ( itemName.matches("((?i)(^cheap)(?-i)(\\s)(.*))") ){
                    itemName = itemName.substring("cheap".length(),itemName.length());                
            }
            
            if ( itemName.matches("((?i)(^also)(?-i)(\\s)(.*))") ){
                    itemName = itemName.substring("also".length(),itemName.length());                
            }
            
            if ( itemName.matches("((?i)(^anyone)(?-i)(\\s)(.*))") ){
                    itemName = itemName.substring("also".length(),itemName.length());                
            }
            
            if ( itemName.matches("((?i)(^for)(?-i)(\\s)(.*))") ){
                    itemName = itemName.substring("also".length(),itemName.length());                
            }
            
            if ( itemName.matches("((?i)(^k)(?-i)(\\s)(.*))") ){
                    itemName = itemName.substring("k".length(),itemName.length());                
            }
            
            if ( itemName.matches("((?i)(^all)(?-i)(\\s)(.*))") ){
                    itemName = itemName.substring("all".length(),itemName.length());                
            }
            
            if ( itemName.matches("((?i)(^a)(?-i)(\\s)(.*))") ){
                    itemName = itemName.substring("a".length(),itemName.length());                
            }
            
            if ( itemName.matches("((?i)(^Level)(?-i)(\\s)(.*))") ){
                    itemName = itemName.substring("Level".length(),itemName.length());                
            }
            
            if ( itemName.matches("((?i)(^Paying)(?-i)(\\s)(.*))") ){
                    itemName = itemName.substring("Paying".length(),itemName.length());                
            }
                        
            if(itemName.matches(itemNameOld))
                flag = false;            
            
        }

            return itemName;                    
        }   
        
        public boolean skipItem(String itemName){
            
            if(itemName.matches("((?i)(^wis|^wiz|^agi|^str|^int|^cha|^sta|^dex|^pieces|^or)(\\s)(.*)(?-i))")){ 
                //   System.out.print(String.format("%150s%n %150s%n","SKIPPED!!",itemName));
                 return true;
            }
            //if(itemName.matches("(a\\s.*)|(A\\s.*)"))
            //    return true;

            if(itemName.matches("(^[aA]ll\\s.*)|(^[aA]ny\\s.*)"))
                return true;
            
            if (itemName.matches("your.*|Your.*|you.*|.*gems.*")){
                //System.out.println(itemName);
            
                 return true;
            }
            
                   
           
            
            
            
            
            
            
          if(itemName.matches("((?i)(^wiz)(\\s)(.*)(?-i))")){                              
                    System.out.print(String.format("%150s%n %150s%n","SKIPPED!!",itemName));
                return true;
           }
            
            if(itemName.matches("(selling|WTS|port|WTB|PC|Buying|pp|each|Dose|piece|pair|port|per ac|Sets|stack|level|lvl|offers|twink|stuff|ea|wis)")){
                return true;
            } 
             
             
             return false;
            
        }
         
    public static int levdistance(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        // i == 0
        int [] costs = new int [b.length() + 1];
        for (int j = 0; j < costs.length; j++)
            costs[j] = j;
        for (int i = 1; i <= a.length(); i++) {
            // j == 0; nw = lev(i - 1, j)
            costs[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= b.length(); j++) {
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]), a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }
        }
        return costs[b.length()];
    }           
    
}
