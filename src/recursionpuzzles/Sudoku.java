/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursionpuzzles;

/**
 *
 * @author tugsbilegkhaliunbat
 */
public class Sudoku {


    public static boolean solve(int[][] board,int row, int col){

        if(col == 9){
            row++;
            col =0;

        }
        if(row==9){
            return true;
        }

        if(board[row][col] != 0){
            return solve(board,row,col+1);
        }


                    for (int i = 1; i <= 9; i++) {
                        if(isValid(board,row,col,i)){
                            board[row][col] = i;
                            if(solve(board,row, col+1)){
                                return true;
                            }
                            board[row][col] = 0;
                        }
                    }



        return false;
    }



    public static boolean isValidRow(int[][] board,int row, int num){
        for (int i = 0; i < 9; i++) {
            if(board[row][i] == num ){
                return false;
            }
        }
        return true;
    }

    public static boolean isValidCol(int[][] board, int col, int num){
        for (int i = 0; i < 9; i++) {
            if(board[i][col] == num){
                return false;
            }
        }
        return true;
    }

    public static boolean isValidBox(int[][] board,int row, int col, int num){
        int topLeftRow = row / 3 * 3;
        int topLeftCol = col / 3 * 3;
        //System.out.println("row: "+topLeftRow+" col: "+topLeftCol);
        for (int i = topLeftRow; i < topLeftRow+3; i++) {
            for (int j = topLeftCol; j < topLeftCol+3; j++) {
                if(board[i][j]==num){
                    return false;
                }
            }

        }
        return true;

    }
    public static boolean isValid(int[][] board,int row, int col, int num){
        return isValidRow(board,row, num) && isValidCol(board,col, num) && isValidBox(board,row, col, num);
    }

    public static void display(int[][] board){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(" "+ board[i][j]);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {

        int[][] b = {
      {4,0,6,0,0,7,3,8,2,},
			{2,1,8,3,9,6,4,0,5},
			{0,5,3,2,8,4,0,0,6},
			{0,6,2,4,0,5,0,0,0},
			{0,7,4,0,2,8,0,5,0},
			{0,8,0,7,6,3,2,4,9},
			{6,4,0,0,0,0,5,2,0},
			{0,3,1,0,7,2,0,0,4},
			{8,2,0,0,4,0,1,0,0},
                      };
        solve(b,0,  0);
        display(b);


    }
}
