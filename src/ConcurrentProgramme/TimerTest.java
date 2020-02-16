/*
package ConcurrentProgramme;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    private static Timer timer = new Timer();

    static public class MyTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("运行了！时间为：" + new Date());
        }
    }

    public static void main(String[] args) {
        try {
            MyTask task = new MyTask();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dataString = "2014-10-12 11:55:00";
            Date dataRef = sdf.parse(dataString);
            System.out.println("字符串时间：" + dataRef.toLocaleString() + "当前时间：" + new Date());
            timer.schedule(task, dataRef);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
*/
