public class test implements Runnable {

    public void run()

    {

        System.out.printf("kmit");

        System.out.printf("ngit");

    }

    public static void main(String[] args)

    {

        test obj = new test();

        Thread thread = new Thread(obj);

        thread.start();

        System.out.printf("ngit");
        try {

            thread.join();

        }

        catch (InterruptedException e) {

            e.printStackTrace();

        }

        System.out.println("kmec");

    }

}