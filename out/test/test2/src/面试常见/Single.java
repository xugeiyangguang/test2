package 面试常见;

public class Single {
    private volatile static Single Single;
    private Single() {
    }
    public static Single newInstance() {
        if (Single == null) {
            synchronized (Single.class) {
                if (Single == null) {
                    Single = new Single();
                }
            }
        }
        return Single;
    }
}
