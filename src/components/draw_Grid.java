package components;

import java.util.ArrayList;


public class draw_Grid{
  static int pos_i = 4, pos_j = 4, venemy = 4, henemy = 3;
  static int [][]Adjmat = {{1,0,0,1,0},{1,0,1,0,1,},{1,1,0,1,0,},{0,1,1,1,0},{1,0,1,1,1}};
  ArrayList<Integer> wall = new ArrayList<Integer>();
  public ArrayList<Integer> getwalls(int [][]Adjmat){
    
    return wall;
  }
  public static void print_dash(int row) {
    for(int i =0 ;i< row;i++) {
      if( i != row - 1) {
        System.out.print("___ ");
      }
    }
  }
  public static void grid_draw(int row, int pos) {
    int pos_i = pos/row, pos_j = pos%row; 
    if(pos_i >= row || pos_j>= row) {
      System.out.println("Out of bounds");
      return;
    }
    for(int i = 0; i < row; i++ ) {
      System.out.print(" ");
      for(int j =0 ;j< row;j++) {
        if(i!= 0 && Adjmat[i][j] == 1 && Adjmat[i-1][j] == 1) {
          System.out.print("    ");
        }
        else if(i == 0 && j == 0) {
          System.out.print("    ");
        }
        else {
          System.out.print("___ ");
        }
      }
      System.out.println();
      for(int j =0;j < row;j++) {
        
       if(j!= 0 && Adjmat[i][j] == 1 && Adjmat[i][j-1] == 1 ) {
         if(pos_i == i && pos_j == j) {
           System.out.print(" c  ");
         }
         else {
           System.out.print("    ");
         }
        }
        else {
          if(pos_i == i && pos_j == j) {
            System.out.print("| c ");
          }
          else {
            System.out.print("|   ");
          }
        }
      }
      System.out.println("|");
    }
    System.out.print(" ");
    print_dash(row);
  }
  public static void main(String args[]) {
    int pos = 0;
    grid_draw(5,0);
    System.out.println();
     for(int i =0;i<5;i++) { 
       for(int j=0;j<5;j++) { 
         if(i!= 0 && Adjmat[i][j] == 1 && Adjmat[i-1][j] == 1 && (pos % 5)<= j) {
           pos = i*5+j;
           grid_draw(5,pos);
           System.out.println();
         }
         else if(j!= 0 && Adjmat[i][j] == 1 && Adjmat[i][j-1] == 1&& (pos_i/ 5)<= i) {
           pos = i*5+j;
           grid_draw(5,pos);
           System.out.println();
         }
         
       }
    }
     System.out.println();
     grid_draw(5,60);
  }
}
