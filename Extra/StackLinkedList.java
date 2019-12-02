/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tunnelrat;
import java.lang.Math; 

/**
 *
 * @author Thewbacca
 */
class Statistics extends StackLinkedList{
    public double avg;
    public Statistics(){
        this.avg = 0;
    }

    public double average() {
        avg = getSum()/getSize();
        avg = Math.round(avg);
        return avg;
    }
    
    public void printPrices() 
    { 
        Node tnode = top; // temp node
        int row = 0;
        System.out.print(String.format("%n" + "     "));
        while (tnode != null) 
        { 
            System.out.print(String.format("     "+ "%5d", tnode.price)); 
            tnode = tnode.next; 
            row++;
            if (row == 10){
                System.out.print(String.format("%n"+"     "));
                row = 0;
            }
        } 
        System.out.println();
    }
    
    public void printStats()
    {
        System.out.print(String.format(""
        + "   +-----------------------------%n"
       // + "   | Sum: %.0f%n"                
        + "   | N: %d%n"                    
        + "   | Average: %1.2f%n"
        + "   | WMA: %1.2f%n"
        + "   | EMA: %1.2f%n"
        + "   | Tn: %1.2f%n"
        + "   | StDev: %1.2f%n"
        + "   | min: %d%n"
        + "   | max: %d%n"
        + "   +-----------------------------%n", 
       // sum,
        getSize(),
        average(),
        weightedAverage(),
        EMA(),
        getTn(),
        stdev(),
        min,
        max));        
    }
    
        public double EMA(){
        Node tnode = top;
        double sigma = 0.3333;
        double WS = 0;
        double WC = 0;

        while (tnode != null) 
        { 
                WS += tnode.price + (1-sigma)*WS;
                WC += 1+(1-sigma)*WC;
                tnode = tnode.next;                
        }            
        
        return WS/WC;
    }
    
    public double stdev() {
        Node tnode = top;
        double avg = average();
        int N = getSize();
        try {
        double smdfsqr = 0.0;
        while(tnode.next != null){
            smdfsqr += Math.pow(tnode.price-avg,2);
            tnode = tnode.next;
        }
        
        double result = Math.sqrt(smdfsqr/(N-1));
        result = Math.round(result*100)/100.0;
        return result;        
        
        }
        catch(Exception e)
        {
            return 0;
        }                       
    }
    
    public double weightedAverage(){      
        Node tnode = top; // temp node
        double wma = 0;
        double sweights = 0;

        int n = size;
        while (tnode != null) 
        { 
            wma += (tnode.price)*((size-(n-1))/((double)size));
            sweights += 1.0*((size-(n-1))/((double)size));
            n = n-1;
            tnode = tnode.next;                
        }            
        return wma/sweights;
    } 


}


class StackLinkedList
{ 
    // global refence variable for top of stack 
    Node top;
    // global reference for sum
    double sum = 0.0;
    // min value in stack
    int min = 0;
    // max value in stack
    int max = 0;
    double Tn = 0.0;
    int size = 0;
        
    StackLinkedList(){
        super();
        this.top = null;
    }
    
    // Linked list Node
    class Node
    { 
        // object variables
        int price;
        // iterative position
        Node next; 
                
        // node constructor
        Node(int p) {price = p; next = null;} 
    } 
    
    
  
    // Push node on top
    public void push(int p) 
    {
        // allocate for present node        
        Node pnode = new Node(p);
        sum += p;
        size += 1;
        
        if (top == null) {
            min = p;
            max = p;
            Tn = p;
            top = pnode;
        }
        else
        {
            if(p < min)
                min = p;
            
            if(p>max)
                max = p;

            Tn = p*0.10+(1-0.10)*Tn;
            
            pnode.next = top;
            top = pnode;
        }
    }
    
    // Remove from top of stack
    public int pop() {
        // check for stack underflow 
        if (top == null) { 
            System.out.print("\nStack Underflow"); 
            return -1; 
        } 
  
        // update the top pointer to point to the next node 
        size -= 1;
        sum -= top.price;
        int p = top.price;
        top = top.next;    
        return p;
    }
    
    // Stack empty
    public boolean isEmpty()
    {
        return top == null;
    }
    
    public int peek() 
    {        
        // check if empty
        if (!isEmpty())
            return top.price;
        else
            return -1;        
    }
    
    public double getSum() {
        return sum;
    }
    
    public int getSize() {
        return size;
    }
    
    public double getTn() {
        return Tn;
    }
    
    // Change top
    public void setData(int p)
    {
       if (!isEmpty()) {
           sum -= top.price;
           sum += p;
           top.price = p;
       }
    }
   
    public StackLinkedList copyStack() {
        StackLinkedList stack = new StackLinkedList();
        
        Node tnode = top;
        while(tnode != null)
        {
            int x = tnode.price;
            stack.push(x);
            tnode = tnode.next;
        }
        
        return stack;        
    }
            
    public void sort()
    {
        StackLinkedList org = copyStack();
        StackLinkedList tmp = new StackLinkedList();
        
        while( !org.isEmpty() )
        {
            int x = org.pop();
            
            while( !tmp.isEmpty() && tmp.peek()>x)
            {
                org.push(tmp.pop());
            }
            tmp.push(x);
        }
        
        Node tnode = top; // temp node
        //int row = 0;
        //System.out.print(String.format("%n" + "     "));
        while (tnode != null) 
        { 
            tnode.price = tmp.pop();
            tnode = tnode.next; 
        } 
    }
    
}