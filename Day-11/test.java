public class test {
    void func(byte b) {
        System.out.println("byte");
    }

    void func(int b) {
        System.out.println("int");
    }

    void func(float b) {
        System.out.println("float");
    }

    void func(Object b) {
        System.out.println("Object");
    }

    public test() {
        this(2);
        System.out.println();
    }

    public test(int n) { 
        
    }

    public static void main(String[] args) {
        test t = new test();
        t.func((short) 123);
        t.func(true);
        t.func(6.989);
    }
}
