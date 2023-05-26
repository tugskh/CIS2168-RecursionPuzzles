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
public class EightQueens {
    public static boolean solve(int[][] board, int col){
        
        int l = board.length;
        
        if(col >= l){
            return true;
        } else {
            
            //System.out.println("HERE");
            for(int row = 0; row < l; row++){
                if(isValid(board, row, col)){
                    board[row][col] = 1;
                    //System.out.println("col:"+col);
                    if(solve(board, col+1)){
                        //System.out.println(col+1);
                        return true;
                    }
                    board[row][col] = 0;
                }
                
            }
            
        }
        return false;
            
    }
    public static boolean isValid(int[][] board,int row, int col){
        return isValidRow(board,row,col) && isValidTopDiagonal(board, row, col) && isValidBotDiagonal(board, row, col);
    }
    
    public static boolean isValidRow(int[][] board, int row, int col){
        for (int c = 0; c < col; c++) {
            if(board[row][c] == 1){
                return false;
            }
        }
        return true;
    }
    public static boolean isValidTopDiagonal(int[][] board, int row, int col){
        int c;
        int r;
        for(c = col, r = row; c >=0 && r >=0; r--, c--){
            if(board[r][c] == 1){
                return false;
            }
        }
        return true;
    }
    public static boolean isValidBotDiagonal(int[][] board, int row, int col){
        int c;
        int r;
        for(c = col, r = row; c < board.length && c>=0 && r >=0 && r<board.length; r++, c--){
            //System.out.println("r:"+r+" c:"+c);
            if(board[r][c] == 1){
                return false;
            }
        }
        
        return true;
    }
    
    public static void display(int[][]board){
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if(board[row][col] == 1){
                    System.out.print("Q ");
                }
                if(board[row][col] == 0){
                    System.out.print("x ");
                }
            }
            System.out.println("");
        }
    }
    
    public static void main(String[] args) {
        int board[][] = new int[8][8];
        solve(board,0);
        display(board);
        
    }
}
