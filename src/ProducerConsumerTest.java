import com.apple.eawt.AppEvent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class ProducerConsumerTest {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new LinkedBlockingDeque<String>(10);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Runnable producerTask = () -> {
            try {
                System.out.println("Producer is publishing data ..");
                int value = 0;
                BufferedReader reader;
                try {
                    reader = new BufferedReader(new FileReader(
                            "trades1.json"));
                    String line = reader.readLine();
                    while (line != null) {
                        blockingQueue.put(line);
                        System.out.println("Call1 "+line);
                        // read next line
                        line = reader.readLine();
                        Thread.sleep(10);
                    }
                    System.out.println("Producer completed " );
                    blockingQueue.put("EOF");
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable consumerTask = () -> {
            try {
                System.out.println("Consumer has started picking ");
                while (true) {
                    String value = blockingQueue.take();
                    System.out.println("Consume " + value);
                    Thread.sleep(10);
                    if(value == "EOF"){
                        System.out.println("EOF has reached ..");
                        return ;
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        executor.execute(producerTask);
        executor.execute(consumerTask);
        executor.shutdown();
    }
}
