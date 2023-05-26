import java.util.*;
import java.util.stream.Collectors;

/**
 * Создайте класс "История покупок клиента". В классе должно быть поле, тип которого Map.
 * Ключи Map - даты заказа, значения - список заказанных наименований.
 * В основной программе создайте истории покупок для нескольких клиентов.
 * С помощью Stream API нужно получить перечень всех наименований без повторений,
 * которые участвовали в заказах за прошедшие 30 дней от текущей даты.
 * Перечень должен быть отсортирован по алфавиту. Выведите перечень в консоль.
 */

public class CustomerPurchaseHistory {

    private static Map<Date, List<String>> listMap = new HashMap<>();

    public static void main(String[] args) {
        List<String> customer1 = Arrays.asList("тряпки", "губки", "салфетки", "клей", "крышки", "зубочистки", "батарейки");
        List<String> customer2 = Arrays.asList("перчатки", "бахилы", "фартуки", "клей", "крышки", "зубочистки", "комбинезоны");
        List<String> customer3 = Arrays.asList("пакеты", "пленки", "салфетки", "сетки", "профили", "зубочистки", "батарейки");
        List<String> customer4 = Arrays.asList("аэрозоли", "лосьоны", "спирали", "удлинители", "крышки", "переходники", "тройники");
        List<String> customer5 = Arrays.asList("сетки", "профили", "кисти", "уплотнители", "валики", "розетки", "переходники");
        List<String> customer6 = Arrays.asList("пакеты", "пленки", "клейкие ленты", "бумажная продукция", "резинки для денег");
        List<String> customer7 = Arrays.asList("тряпки", "губки", "салфетки", "клей", "крышки", "зубочистки", "батарейки");
        List<String> customer8 = Arrays.asList("перчатки", "бахилы", "фартуки", "клей", "крышки", "зубочистки", "комбинезоны");
        List<String> customer9 = Arrays.asList("пакеты", "пленки", "салфетки", "сетки", "профили", "зубочистки", "батарейки");
        List<String> customer10 = Arrays.asList("сетки", "профили", "кисти", "уплотнители", "валики", "розетки", "переходники");

        listMap.put(new Date(2023, 0, 18), customer1);
        listMap.put(new Date(2023, 2, 10), customer2);
        listMap.put(new Date(2023, 2, 15), customer3);
        listMap.put(new Date(2023, 3, 18), customer4);
        listMap.put(new Date(2023, 3, 11), customer5);
        listMap.put(new Date(2023, 1, 15), customer6);
        listMap.put(new Date(2023, 3, 25), customer7);
        listMap.put(new Date(2023, 3, 16), customer8);
        listMap.put(new Date(2023, 3, 22), customer9);
        listMap.put(new Date(2023, 2, 21), customer10);
        Date date = new Date();

        listMap.entrySet()
               .stream()
               .filter(x -> x.getKey().getTime() > date.getTime() - 30)
                .flatMap(x -> x.getValue().stream())
                .distinct()
                .sorted()
                .collect(Collectors.toList())
                .forEach(System.out::println);
      }


}
