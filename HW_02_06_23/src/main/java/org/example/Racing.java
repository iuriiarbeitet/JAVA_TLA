package org.example;
import java.util.concurrent.CyclicBarrier;
/**
 * Все участники должны стартовать одновременно, несмотря на то что на подготовку
 * у каждого их них уходит разное время. В туннель не может заехать одновременно
 * больше половины участников. Попробуйте всё это синхронизировать.
 * Только после того как все завершат гонку нужно выдать объявление об окончании.
 * Можете корректировать классы.
 *
 * Пример вывода:
 * …
 * Участник #3 закончил этап: Дорога 40 метров
 * Участник #3 - WIN
 * Участник #1 закончил этап: Дорога 40 метров
 * Участник #4 закончил этап: Тоннель 80 метров
 * Участник #4 начал этап: Дорога 40 метров
 * Участник #2 закончил этап: Тоннель 80 метров
 * Участник #2 начал этап: Дорога 40 метров
 * Участник #2 закончил этап: Дорога 40 метров
 * Участник #4 закончил этап: Дорога 40 метров
 * ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!
 */

public class Racing {


        private static final int PARTICIPANT_COUNT = 10;
        private static final int TUNNEL_CAPACITY = PARTICIPANT_COUNT / 2;
        private static final CyclicBarrier startBarrier = new CyclicBarrier(PARTICIPANT_COUNT);
        private static final CyclicBarrier tunnelBarrier = new CyclicBarrier(TUNNEL_CAPACITY);
        private static final CyclicBarrier finishBarrier = new CyclicBarrier(PARTICIPANT_COUNT, new Announcement());

        public static void main(String[] args) {
            for (int i = 1; i <= PARTICIPANT_COUNT; i++) {
                new Thread(new Participant(i)).start();
            }
        }

        private static class Participant implements Runnable {
            private final int participantNumber;

            public Participant(int participantNumber) {
                this.participantNumber = participantNumber;
            }

            @Override
            public void run() {
                try {
                    System.out.println("Участник #" + participantNumber + " готовится");
                    Thread.sleep((int) (Math.random() * 5000));
                    System.out.println("Участник #" + participantNumber + " готов");

                    startBarrier.await();

                    System.out.println("Участник #" + participantNumber + " начал гонку");
                    Thread.sleep(5000);
                    System.out.println("Участник #" + participantNumber + " закончил этап: Дорога 40 метров");

                    if (participantNumber <= TUNNEL_CAPACITY) {
                        tunnelBarrier.await();
                        System.out.println("Участник #" + participantNumber + " начал этап: Тоннель 80 метров");
                        Thread.sleep(5000);
                        System.out.println("Участник #" + participantNumber + " закончил этап: Тоннель 80 метров");
                    }

                    finishBarrier.await();
                    System.out.println("Участник #" + participantNumber + " закончил гонку");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        private static class Announcement implements Runnable {
            @Override
            public void run() {
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
            }
        }
}