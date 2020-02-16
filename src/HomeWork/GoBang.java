package HomeWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class GoBang {
    private static int BOARD_SIZE = 15;
    private String[][] board;
    //初始化棋盘
    public void initBoard(){
        board = new String[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++){
            for (int j = 0; j < BOARD_SIZE;j++){
                board[i][j] = "+";
            }
        }
    }
    //输出棋盘
    public void printBoard(){
        for (int i = 0; i < BOARD_SIZE; i++){
            for (int j = 0; j < BOARD_SIZE;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
   /* public boolean IsWin()*/

    public static void main(String[] args) throws IOException {
        GoBang gb = new GoBang();
        gb.initBoard();
        gb.printBoard();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = null;
        while ((inputStr = br.readLine())!= null){
            //人下棋
            String[] posStrArr = inputStr.split(",");
            int xPos = Integer.valueOf(posStrArr[0]);
            int yPos = Integer.valueOf(posStrArr[1]);
            gb.board[xPos - 1][yPos - 1] = "●";
            //电脑下棋
            Random rand = new Random();    //生成棋盘大小的伪随机数，使用Random类
            xPos = rand.nextInt(BOARD_SIZE - 1);
            yPos = rand.nextInt(BOARD_SIZE - 1);
            while (gb.board[xPos][yPos] != "+"){
                xPos = rand.nextInt(BOARD_SIZE - 1);
                yPos = rand.nextInt(BOARD_SIZE - 1);
            }
            gb.board[xPos][yPos] = "○";
            //输出一轮回的结果
            gb.printBoard();
            //检查是否有赢家
            for (int i = 0; i < BOARD_SIZE; i++){
                for (int j = 0;j < BOARD_SIZE; j++){
                    if (gb.board[i][j] == "○"){    //检查白棋是否赢
                        //检查白棋的行
                        if (j + 4 < BOARD_SIZE &&
                                gb.board[i][j+1] == "○" && gb.board[i][j+2] == "○" &&
                                gb.board[i][j+3] == "○" && gb.board[i][j+4] == "○"
                                || i + 4 < BOARD_SIZE &&
                                gb.board[i+1][j] == "○" && gb.board[i+2][j] == "○" &&
                                gb.board[i+3][j] == "○" && gb.board[i+4][j] == "○"
                                || j + 4 < BOARD_SIZE && i + 4 < BOARD_SIZE &&
                                gb.board[i+1][j+1] == "○" && gb.board[i+2][j+2] == "○" &&
                                gb.board[i+3][j+3] == "○" && gb.board[i+4][j+4] == "○"
                                || j - 4 > BOARD_SIZE && i + 4 < BOARD_SIZE &&
                                gb.board[i+1][j-1] == "○" && gb.board[i+2][j-2] == "○" &&
                                gb.board[i+3][j-3] == "○" && gb.board[i+4][j-4] == "○"){
                            System.out.println("white is winning!");
                            return;
                        }
                    }else if (gb.board[i][j] == "●"){
                        //检查黑棋是否胜出
                        if (j + 4 < BOARD_SIZE &&
                                gb.board[i][j+1] == "●" && gb.board[i][j+2] == "●" &&
                                gb.board[i][j+3] == "●" && gb.board[i][j+4] == "●"
                                || i + 4 < BOARD_SIZE &&
                                gb.board[i+1][j] == "●" && gb.board[i+2][j] == "●" &&
                                gb.board[i+3][j] == "●" && gb.board[i+4][j] == "●"
                                || j + 4 < BOARD_SIZE && i + 4 < BOARD_SIZE &&
                                gb.board[i+1][j+1] == "●" && gb.board[i+2][j+2] == "●" &&
                                gb.board[i+3][j+3] == "●" && gb.board[i+4][j+4] == "●"
                                || j - 4 > BOARD_SIZE && i + 4 < BOARD_SIZE &&
                                gb.board[i+1][j-1] == "●" && gb.board[i+2][j-2] == "●" &&
                                gb.board[i+3][j-3] == "●" && gb.board[i+4][j-4] == "●"){
                            System.out.println("black is winning!");
                            return;
                        }

                    }else {
                    }
                }
            }
            System.out.println("请您以x,y的形式输入下棋坐标：");
        }
    }
}
