package org.example;

/**
 * 3. Написать класс МФУ, на котором возможны одновременная печать и сканирование документов,
 *  *  при этом нельзя одновременно печатать два документа или сканировать
 *  *  (при печати в консоль выводится сообщения "отпечатано 1, 2, 3,… страницы",
 *  *  при сканировании тоже самое только "отсканировано…", вывод в консоль все также с периодом в 50 мс.)
 */
public class Task3 {
       private static final Object lock = new Object();
        private static volatile boolean isPrinting = false;
        private static volatile boolean isScanning = false;

        public static void main(String[] args) {
            Thread printThread = new Thread(new PrintTask());
            Thread scanThread = new Thread(new ScanTask());

            printThread.start();
            scanThread.start();
        }

        private static class PrintTask implements Runnable {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 1; i <= 10; i++) {
                        while (isScanning) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        isScanning = true;
                        System.out.println("Отпечатано " + i + " страница");
                        isPrinting = false;

                        lock.notifyAll();

                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        private static class ScanTask implements Runnable {
            @Override
            public void run() {
                synchronized (lock) {
                    for (int i = 1; i <= 10; i++) {
                        while (isPrinting) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        isPrinting = true;
                        System.out.println("Отсканировано " + i + " страница");
                        isScanning = false;

                        lock.notifyAll();

                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

}
