import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.management.MBeanServer;
import javax.net.ssl.HostnameVerifier;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        Random rand = new Random();

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    list.clear();
                    list.add("A");
                    list.add("B");
                    list.add("C");
                    sleep(1);
                }
            }

        });
        t.setDaemon(false);
        t.start();

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    list.add("A");
                    try {
                        list.get(0);
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                        System.exit(0);
                    }
                }
            }
        });
        t2.setDaemon(false);
        t2.start();

    }

    private static void sleep(int i) {
        try {
            Thread.sleep(i);
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
