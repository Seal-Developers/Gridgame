package components;

import java.util.ArrayList;


public class draw_Grid{
  static int pos_i = 2, pos_j = 2;
  static int [][]Adjmat = {{1,1,1},{0,0,1},{0,0,1}};
  ArrayList<Integer> wall = new ArrayList<Integer>();
  public ArrayList<Integer> getwalls(int [][]Adjmat){
    
    return wall;
  }
  public static void main(String[] args) {
    
    int row = 3, col = 3;
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
      for(int j =0;j < col;j++) {
        
       if(j!= 0 && Adjmat[i][j] == 1 && Adjmat[i][j-1] == 1) {
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
    for(int i =0 ;i< row;i++) {
      if( i != row - 1) {
        System.out.print("___ ");
      }
    }
  }
    
}
