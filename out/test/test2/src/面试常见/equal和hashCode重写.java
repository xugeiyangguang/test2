package 面试常见;

public class equal和hashCode重写 {
    String a;
    int b;
    public static void main(String[] args) {

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        //不要使用instanceOf判断，这里要求的是两个对象必须要是同一个类的实例
        if (obj != null && obj.getClass() == equal和hashCode重写.class) {

            equal和hashCode重写 tmp = (equal和hashCode重写) obj;
            return this.a.equals(tmp.a) && (this.b == tmp.b);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result*31+ a.hashCode();
        result = result * 31 + b;
        return result;
    }
}
