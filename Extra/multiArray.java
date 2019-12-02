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

public class multiArray {
    
    private Object[][] arr;
    int N;
    int M;

    multiArray(int N, int M){
        this.N = N;
        this.M = M;
        arr = new String[N][M];
    }
    
    multiArray(int M)
    {
        this.M = M;
        arr = new String[M][];
    }
    
    public int getLength(){
        return M;
    }
    
    public int getHeight(){
        return N;
    }
    
    
    
    /**
    * Returns the matrix entry at position (row,col).  (If row < col,
    * the value is actually stored at position (col,row).)
    */
    public Object get(int row, int col ) {
        if (row >= col)
            return arr[row][col];
        else
            return arr[col][row];
    }
    

    public void set(int row, int col, Object data)
    {
          if (row >= col)
              arr[row][col] = data;
          else
              arr[col][row] = data;
    }
    
    public void setRow(int row, Object... data)
    {
        for(int i = 0; i < data.length; i++)
            arr[row][i] = data[i];
    }
    
    public Object[][] toObject(){
        return arr;
    }
    
    public void print(){
        for (int row = 0; row < arr.length; ++row) {
            System.out.print("[");
            for(int col = 0; col < arr[row].length; ++col) {

             if(col < arr[row].length-1)
                 System.out.print(arr[row][col] + " ");
             else
                 System.out.print(arr[row][col] + "]\n");
            }
        }
    }
    
    public static void main(String[] args){
        multiArray arr = new multiArray(5,3); // rows col
        Object[] sarr = {"Shit","Fuck"};
        arr.setRow(1,sarr);
        arr.print();        
        System.out.println("Height is " + arr.getHeight() + " and Length is " + arr.getLength());
    }
    
    
}