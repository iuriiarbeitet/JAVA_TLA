package org.example;

/**
 *  2. Написать совсем небольшой метод, в котором 3 потока построчно пишут данные в файл
 *  *      (штук по 10 записей, с периодом в 20 мс)
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Task2 {
        public static void main(String[] args) throws InterruptedException {
            Thread thread1 = new Thread(new WriteToFileTask("Thread 1"));
            Thread thread2 = new Thread(new WriteToFileTask("Thread 2"));
            Thread thread3 = new Thread(new WriteToFileTask("Thread 3"));

            thread1.start();
            thread2.start();
            thread3.start();
            thread1.join();
            thread2.join();
            thread3.join();
        }

        private static class WriteToFileTask implements Runnable {
            private final String threadName;

            public WriteToFileTask(String threadName) {
                this.threadName = threadName;
            }

            @Override
            public void run() {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt", true))) {
                    for (int i = 1; i <= 10; i++) {
                        String line = threadName + " - Line " + i;
                        writer.write(line);
                        writer.newLine();
                        writer.flush();

                        Thread.sleep(20);
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

