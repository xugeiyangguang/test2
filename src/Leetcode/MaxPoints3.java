package Leetcode;

import java.util.HashMap;
/* 记录每个点不同的斜率，而且斜率不一定是整数
* */
public class MaxPoints3 {
    public static void main(String[] args) {
        Point a1 = new Point(-4,1);
        Point a2 = new Point(-7,7);
        Point a3 = new Point(-1,5);
        Point a4 = new Point(9,-25);
        Point a5 = new Point(-1,-1);
    //    Point a6 = new Point(1,3);
        Point a7 = new Point(2,0);
     //   Point a8 = new Point(2,1);
     //   Point a9 = new Point(2,2);
        Point[] points = {a1,a2,a3,a4};
        MaxPoints3 test = new MaxPoints3();
        System.out.println(test.maxPoints(points));
    }
    //找到位于同一直线的最大点数
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0){
            return 0;
        }
        HashMap<Float,Integer> map = new HashMap<>();   //存储不同斜率上的点
        int max = 1;
        int rel = 1; //斜率上的点的最大值
        int col;//该列的节点数
        int dum = 1;//重合的个数,初始为1 ，表示只有一个点
        for (int i = 0; i < points.length; i++){
            //每个点都要初始化变量
            dum = 1;
            col = 1;
            map.clear();
            for (int j = 0;j < points.length; j++){
                if (i == j){
                    continue;
                }else if (points[i].y == points[j].y) {
                    if (points[i].x == points[j].x){
                        dum++;
                    }
                    col ++;   //col包含了重复的点
                }else {
                    float k = (float) (points[i].x - points[j].x)/(points[i].y - points[j].y);
                    if (map.containsKey(k)){    //如果包含当前斜率
                        map.put(k,map.get(k)+1);
                    }else {     //如果不包含当前斜率
                        map.put(k,1);
                    }
                }
            }
            for (Float k : map.keySet()){    //找到斜率中的最大值
                rel = Math.max(rel,map.get(k)+dum);
            }
            max = Math.max(max,Math.max(rel,col));
        }

        return max;
    }
}
