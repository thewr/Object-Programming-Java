/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodeSalad;

import java.util.logging.Level;
import java.util.logging.Logger;


interface Calculation {
    int sum(int n, int k);
    int sumFormula(int n);
}   
class partialsums extends Thread {
    int j;
    int n = 10;
    int k = 3;
    long sum;
    boolean done;
    
    partialsums(int j)
    {
        this.j = j;  //current thread count
    }

    @Override
    public void run(){
        synchronized(this){
            int numint = (n/k);///1000*1000;
            int start = j*numint;
            int stop = (j+1)*numint;
            
            if (j > 0)
                    start=start+1;
            
            for(int i = start; i<=stop; i++){
                sum += i;
            }
            System.out.println("SUM at THREAD #"+j+" IS " + sum);
            notify();
        }          
        
    }
    
}





public class Summer implements Calculation{

    /**
     *
     * @param n
     * @param k
     * @return
     */
    @Override
    public int sum(int n, int k)//int[] arr, int low, int high)
    {
        System.out.println("Summation Started");
        int total = 0;
        int numintervals = n/k;
                
        partialsums[] ps = new partialsums[numintervals];
        synchronized(ps) {       
        
            for(int j = 0; j < 3; j++){
                ps[j] = new partialsums(j);
                ps[j].start();
                try {
                    ps[j].join();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Summer.class.getName()).log(Level.SEVERE, null, ex);
                }
                total += ps[j].sum;
            }              
        }    
        
        
        //if the last partialsums interval does not include n
        //add up the remaining sequence less than k steps from n
        if(numintervals*k<n)
        {                
            System.out.println("Adding Remaining Values ...");
                for(int i = numintervals*k+1; i <= n ; i++)
                {
                    total += i;
                }
        }
        
        System.out.println("Summation Complete");

        return total;
    }

    @Override
    public int sumFormula(int n) {
        int sum;
        sum = n*(n+1)/2;
        return sum;

    }

}
