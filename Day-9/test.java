public class test {
    public static void main(String[] args) {
        a o1 = new c();
        b o2 = (b) o1;
        System.out.println(o2.func());
    }

    static class a {
        int test() {
            return 0;
        }

        int func() {
            return 3;
        }
    }

    static class b extends a {
        int test() {
            return 1;
        }

        int func() {
            return test();
        }
    }

    static class c extends b {
        int test() {
            return 2;
        }
    }
}
