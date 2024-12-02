package app;

import java.util.concurrent.atomic.AtomicInteger;

public class DataHandler {
    String[] fruits = new DataRepository().getData();
    public void getOutput() {
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            AtomicInteger count = new AtomicInteger(0);
            for (String fruit : fruits) {
                sb.append(String.format("(%d) %s ",
                        count.addAndGet(1), fruit));
//                System.out.println(Thread.currentThread().getName() + ": " + sb);
            }

            System.out.println(Thread.currentThread().getName() + ": " + sb);
        }
    }
}
