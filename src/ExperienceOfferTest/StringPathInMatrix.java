package ExperienceOfferTest;

public class StringPathInMatrix {
    public static void main(String[] args) {
        StringPathInMatrix test = new StringPathInMatrix();
        char[] matrix = {'a','b','c','e','s','f','c','s','a','d','e','e'};
        char[] str = {'a','b','c','c','e','e'};
        System.out.println(test.hasPath(matrix,3,4,str));

    }
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if (matrix==null||rows<1||cols<1||str==null){
            return false;
        }
        int[] pathlength = new int[1];   //当前匹配路径的长度
        boolean[] visit = new boolean[rows*cols];   //设置足迹矩阵，即走过位置为true;
        for (int row = 0;row < rows ;row++){
            for (int col = 0;col < cols; col++){
                if (hasPathCore(matrix,rows,cols,row,col,str,pathlength,visit)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasPathCore(char[] matrix, int rows, int cols,int row,int col,
                               char[] str, int pathlength[], boolean visit[]) {
        if (pathlength[0]  == str.length){
            return true;
        }
        boolean hasPath = false;
        if (row >= 0 &&row < rows &&col>=0&&col<cols&&matrix[row*cols+col]==str[pathlength[0]]
            &&!visit[row*cols+col]){
            ++pathlength[0];
            visit[row*cols+col] = true;

            hasPath = hasPathCore(matrix,rows,cols,row,col-1,str,pathlength,visit)
                    ||hasPathCore(matrix,rows,cols,row,col+1,str,pathlength,visit)
                    ||hasPathCore(matrix,rows,cols,row-1,col,str,pathlength,visit)
                    ||hasPathCore(matrix,rows,cols,row+1,col,str,pathlength,visit);

            if (!hasPath){
                --pathlength[0];
                visit[row*cols+col] = false;
            }
        }
        return hasPath;
    }
}
