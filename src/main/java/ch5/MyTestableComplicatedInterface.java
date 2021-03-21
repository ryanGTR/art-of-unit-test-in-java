package ch5;

public class MyTestableComplicatedInterface implements IComplicatedInterface{

    String meth1_a;
    String meth1_b, meth2_b;
    boolean meth1_c, meth2_c, meth3_c;
    int meth1_x, meth2_x, meth3_x;
    int meth1_0, meth2_0, meth3_0;

    @Override
    public void method1(String a, String b, boolean c, int x, Object o) {
        meth1_a =a;
        meth1_b = b;
        meth1_c = c;
        meth1_x = x;
        meth1_0 = 0;
    }

    @Override
    public void method2(String b, boolean c, int x, Object o) {
        meth2_b = b;
        meth2_c = c;
        meth2_x = x;
        meth2_0 = 0;
    }

    @Override
    public void method3(Boolean c, int x, Object o) {
        meth3_c = c;
        meth3_x = x;
        meth3_0 = 0;
    }
}
