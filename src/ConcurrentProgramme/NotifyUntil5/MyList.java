package ConcurrentProgramme.NotifyUntil5;

import java.util.ArrayList;
import java.util.List;

public class MyList {
    private static List list = new ArrayList();

    public static void add() {
        list.add("new String");
    }

    public static int size() {
        return list.size();
    }
}
