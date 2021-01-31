import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

public class ExecutorExample {

    public  void readFile()
    {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "/Users/kothari/Downloads/trades.json"));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        BlockingDeque<String> blockingDeque=new LinkedBlockingDeque<String>(10);
        executorService.execute(new Runnable() {
            public void run() {
                System.out.println("Asynchronous task");
            }
        });

        Set<Callable<String>> callables = new HashSet<Callable<String>>();

        callables.add(new Callable<String>() {
            public String call() throws Exception {

                BufferedReader reader;
                try {
                    reader = new BufferedReader(new FileReader(
                            "/Users/kothari/Downloads/trades.json"));
                    String line = reader.readLine();
                    while (line != null) {
                        blockingDeque.add(line);
                        System.out.println("Call1 "+line);

                        // read next line
                        line = reader.readLine();
                    }
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return "Task 1";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                Thread.sleep(1);
                while(!blockingDeque.isEmpty()) {
                    String str = blockingDeque.take();
                    System.out.println("IN callable 2 .... " + str);
                }
                return "Task 2";
            }
        });
        callables.add(new Callable<String>() {
            public String call() throws Exception {
                return "Task 3";
            }
        });

        List<Future<String>> futures = executorService.invokeAll(callables);
//        for(Future<String> future : futures){
//            if(future.isDone())
//            System.out.println("future.get = " + future.get());
//        }


        executorService.shutdown();
    }
}
