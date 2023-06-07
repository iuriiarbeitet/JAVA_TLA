package org.example;

/**
 * 1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз,
 *  * порядок должен быть именно ABСABСABС. Используйте wait/notify/notifyAll.
 */

public class Task1 {

    public static void main(String[] args) {
        Thread threadA = new Thread(new PrintLetterTask('A', 'B'));
        Thread threadB = new Thread(new PrintLetterTask('B', 'C'));
        Thread threadC = new Thread(new PrintLetterTask('C', 'A'));

        threadA.start();
        threadB.start();
        threadC.start();
    }

    private static Object lock = new Object();
    private static volatile char currentLetter = 'A';


    private static class PrintLetterTask implements Runnable {
        private final char current;
        private final char next;

        public PrintLetterTask(char current, char next) {
            this.current = current;
            this.next = next;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                synchronized (lock) {
                    try {
                        while (currentLetter != current) {
                            lock.wait();
                        }

                        System.out.print(current);
                        currentLetter = next;
                        lock.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

