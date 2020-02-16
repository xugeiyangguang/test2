package HomeWork;

import ExperienceOfferTest.TreeNode;

import java.util.ArrayList;
//java堆溢出：不断生成对象，导致堆内存溢出
public class HeapOOM {
    static class OOMObject {
    }
    public static void main(String[] args) {

        ArrayList<OOMObject> list = new ArrayList<>();
        while (true){
            OOMObject a = new OOMObject();
            list.add(a);
        }
    }
}
