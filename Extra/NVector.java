/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tunnelrat;

/**
 *
 * @author Thewbacca
 */
public class NVector {
   private final int n;                 // length of the vector
   private double[] v;                  // array of elements
 
   // intialize vector with length n with zero for all elements
    NVector(int n) {
        this.n = n;
        this.v = new double[n];
    }
    
    public NVector(double... v) {
        n = v.length;
        
        //create a new vector
        this.v = new double[n];
        for(int i = 0; i < n; i++)
            this.v[i] = v[i];        
    }
    
    public NVector(NVector other) {
        this.n = other.n; 
        
        //create a new vector
        this.v = new double[n];
        for(int i = 0; i < n; i++)
            this.v[i] = other.v[i];  
        
    }
    
    
    // return length of vector
    public int length() {
        return n;
    }
    
    // accessor, returns element with index i
    public double get(int i) {
        return v[i];
    }
    
    // method to compare to NVector objects
    public boolean equals(NVector other) {
        // if any of the vectors have zero length return false;
        if (other.n == 0) 
            return false;
        
        // if the vecotrs have an absolute difference return false
        if (Math.abs(n-other.n) != 0)
            return false;
        
        // if the vectors are the same length
        // check each element; if different return false
        // otherwise pass through while and return as true
        if (n == other.n) {
            int i = 0;
            
            while(i < n){                
                if(get(i)!=other.get(i))
                    return false;
                i++;
            }

        } 
        return true;          
    }
    
    // sets a vector at index i to x; if index is 
    // out of bounds do nothing i.e. return original as is
    public NVector set(int i, double x)
    {
        // create temp vector
        NVector vnew = new NVector(v);       
        try {
            this.v[i] = x;        
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        return vnew;        
    }
    
    public NVector add(NVector other) {
        //NVector v = new NVector(n);
         NVector vnew = new NVector(n);

        if (n != other.n){
            throw new IllegalArgumentException("vectors are not equal, cannot add");
        }
        else
        {
            for(int i = 0; i < n; i++)
            {
                vnew.v[i] = v[i] + other.v[i];
            }
        }
        

            
          return vnew;  
        }
            
        
    
    
    // return as string
    public String toString() {
        StringBuilder vs = new StringBuilder();
        vs.append('[');
        for (int i = 0; i < n; i++) {
            if (i != n-1)
                vs.append(v[i]).append(" ");   
            else
                vs.append(v[i]);                          
        }
        vs.append(']');
        return vs.toString();
    }
    
    public static void main(String args[]){
        NVector vector1 = new NVector(1,2,3,8);
        System.out.println("v1: " + vector1.toString());
        NVector vector2 = new NVector(vector1);
        System.out.println("v2: " + vector2.toString());
        System.out.println(vector2.equals(vector1));
        NVector vector3 = new NVector(1,4,6,2);
        System.out.println(vector2.equals(vector3));
        
        //vector2.set(1, -5);
        //System.out.println(vector2.toString());
        
      
        
        System.out.println(vector1.add(vector2));
        System.out.println("v2: " + vector2.toString());
        System.out.println("v1: " + vector1.toString());



    }
}
