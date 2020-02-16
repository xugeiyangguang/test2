package HomeWork;
/**虚拟机和本地方法栈溢出
 * **/
//在单个线程下，无论是由于栈帧太大还是虚拟机容量太小，当内存无法分配的时候，虚拟机都是抛出StackOverflowError异常
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable throwable) {
            System.out.println("stack length:" + oom.stackLength);
            throw throwable;
        }
    }
}
