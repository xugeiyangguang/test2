package Leetcode;

/**
 * 1.将四边缘上有‘O’的改为‘*’
 * 2.将与‘*’相连的‘O’,深度搜索，全部转化为‘*’
 * 3.将全表的‘O’转化为‘X’
 * 4.将‘*’转化为‘O’
 */
public class A17SurroundedRegions {
    public static void main(String[] args) {

    }
    public void solve(char[][] board) {
        if (board == null || board.length == 1 && board[0].length == 0
                || board.length ==0){
            return;
        }
        for (int i = 0; i < board.length; i++){
            if (board[i][0] == 'O'){
                board[i][0] = '*';
                changeRelated(board,i,0);
            }
            if (board[i][board[0].length-1] == 'O'){
                board[i][board[0].length-1] = '*';
                changeRelated(board,i,board[0].length-1);
            }
        }
        for (int i = 0; i < board[0].length; i++ ){
            if (board[0][i] == 'O'){
                board[0][i] = '*';
                changeRelated(board,0,i);
            }
            if (board[board.length-1][i] == 'O'){
                board[board.length-1][i] = '*';
                changeRelated(board,board.length-1,i);
            }
        }
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if (board[i][j] == '*'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    public void changeRelated(char[][] board, int i, int j){
        if (i-1 >= 0 && board[i-1][j] == 'O'  ){
            board[i-1][j] = '*';
            changeRelated(board,i-1,j);
        }
        if (i+1 <= board.length-1 && board[i+1][j] == 'O' ){
            board[i+1][j] = '*';
            changeRelated(board,i+1,j);
        }
        if ( j-1 >= 0 && board[i][j-1] == 'O' ){
            board[i][j-1] = '*';
            changeRelated(board,i,j-1);
        }
        if ( j+1 <= board[0].length-1 && board[i][j+1] == 'O' ){
            board[i][j+1] = '*';
            changeRelated(board,i,j+1);
        }
    }

}
