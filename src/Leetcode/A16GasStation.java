package Leetcode;

public class A16GasStation {
    public static void main(String[] args) {
        A16GasStation test = new A16GasStation();
        int[] gas = {3};
        int[] cost = {4};
        int re = test.canCompleteCircuit(gas,cost);
        System.out.println();
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0 || cost.length == 0){
            return -1;
        }
        int remain = 0;
        boolean flag;
        int j;
        for (j = 0; j < gas.length ; j++){
            flag = false;
            for (int i = j; i < gas.length; i ++){
                remain = remain + gas[i] - cost[i];
                if (remain < 0){
                    return -1;
                }
                if (i == gas.length -1){
                    i = -1;
                    flag = true;
                }
                if (flag == true && i == j){
                    return i;
                }
            }

        }
        return j;
    }
}
