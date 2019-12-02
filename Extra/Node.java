/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tunnelrat;
import java.util.*;



/**
 * A generic Node class that Stores a reference to Data and the next Node
 */
public class Node {

    // data fields (reference variables)
    // data stores an object of any class
    String item;
 //   Date dategame;
    int count = 0;
    Statistics prices = new Statistics();
    
    Stack<String> sellers = new Stack<String>();

    Seller dates = new Seller();
    String time;

    // next points to the next node
    Node left, right;

    /**
     * Constructor - Used To Create EAch Object and Initialize DAta Fields.
     * 
     * @param data2 initializes the data variable.
     * @param next2 initializes the next variable..
     */
        
    public Node(String item, int price, String sname, String time) {
        //name of item
        this.item = item;
        //includes another
        this.count += 1;
        this.prices.push(price);// = //new StackLinkedList();
        this.sellers.push(sname);
        this.dates.add(sname,time);
        this.time = time;

         left = right = null;
    }

	/**
	 * Used to Display The Data Stored In EAch Node.
	 * 
	 * @return a String for the data
	 */
   public String toString() {
      return item.toString();
   }

	/**
	 * This Is An "Accessor" Method - Used To Get A Data Field.
	 * 
	 * @return the data
	 */
   public String getName() {
      return item;
   }
	/**
	 * This Is A "Mutator" Method - Used To Set A Data Field.
	 * 
	 * @param data2 is the data stored in the Node object.
	 */
   public void addData(int price, String sname, String time) 
   {
       this.count += 1;
       this.prices.push(price);
       this.sellers.push(sname);
       //this.dates.add(sname,time);
   }


} // end of class
