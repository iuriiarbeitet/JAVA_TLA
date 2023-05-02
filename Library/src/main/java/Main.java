import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Необходимо смоделировать библиотеку. Для каждой книги библиотечного фонда известны автор,
 * название и год издания. Для читателя библиотеки будем хранить ФИО и электронный адрес
 * (объекты типа EmailAddress). Каждый читатель может взять в библиотеке одну или несколько книг -
 * их тоже сохраним. Ещё нам понадобится флаг читательского согласия на уведомления по электронной почте.
 * Рассылки организуют сотрудники библиотеки: напоминают о сроке возврата книг, сообщают новости.
 * Разработайте соответствующие классы.
 * Task 1. Получить список всех книг библиотеки, отсортированных по году издания.
 * Task 2. Требуется создать список рассылки (объекты типа EmailAddress) из адресов всех читателей библиотеки.
 * При этом флаг согласия на рассылку учитывать не будем: библиотека закрывается,
 * так что хотим оповестить всех.
 * Task 3. Снова нужно получить список рассылки. Но на этот раз включаем в него только адреса читателей,
 * которые согласились на рассылку. Дополнительно нужно проверить, что читатель взял
 * из библиотеки больше одной книги.
 * Task 4. Получить список всех книг, взятых читателями. Список не должен содержать дубликатов
 * (книг одного автора, с одинаковым названием и годом издания).
 * Task 5. Проверить, взял ли кто-то из читателей библиотеки какие-нибудь книги Оруэлла.
 * Task 6. Узнать наибольшее число книг, которое сейчас на руках у читателя.
 * Task 7*. Вернёмся к нашим email-рассылкам. Теперь нужно не просто отправить письма всем,
 * кто согласился на рассылку, — будем рассылать разные тексты двум группам:
 * <p>
 * * тем, у кого взято меньше двух книг, просто расскажем о новинках библиотеки;
 * <p>
 * тем, у кого две книги и больше, напомним о том, что их нужно вернуть в срок.
 * То есть надо написать метод, который вернёт два списка адресов (типа EmailAddress): с пометкой OK — если книг не больше двух, или TOO_MUCH — если их две и больше. Порядок групп не важен.
 * <p>
 * <p>
 * Можно решить любое количество задач. Все задачи будем разбирать на занятии. Единственное условие: попробуйте решить все задачи с помощью Stream API.
 */

public class Main {
    private static Library library = new Library();

    public static void main(String[] args) {
        System.out.println("-------------------------> 1 <------------------------------- ");
        m1();
        System.out.println("-------------------------> 2 <------------------------------- ");
        m2();
        System.out.println("-------------------------> 3 <------------------------------- ");
        m3();
        System.out.println("-------------------------> 4 <------------------------------- ");
        m4();
        System.out.println("-------------------------> 5 <------------------------------- ");
        m5();
        System.out.println("-------------------------> 6 <------------------------------- ");
        m6();
        System.out.println("-------------------------> 7 <------------------------------- ");
        m7();


    }

    // 1. Получить список всех книг библиотеки, отсортированных по году издания
    public static void m1() {
        List<Book> list = library.getBooks().stream()
                .sorted(Comparator.comparingInt(Book::getYear))
                .collect(Collectors.toList());
        list.forEach(System.out::println);
        System.out.println();
    }

    // 2. Требуется создать список рассылки (объекты класса EmailAddress) из адресов всех читателей.
    public static void m2() {
        List<EmailAddress> list2 = library.getReaders().stream()
                .map(Reader::getEmail)
                .map(EmailAddress::new)
                .collect(Collectors.toList());
        list2.forEach(System.out::println);
        System.out.println();
    }

    // 3. Включить в список рассылки только адреса читателей, которые согласны.
    // Дополнительно проверить, что читатель взял более одной книги
    public static void m3() {
        List<EmailAddress> list3 = library.getReaders().stream()
                .filter(Reader::getAgree)
                .filter(reader -> reader.getBooks().size() > 1)
                .map(Reader::getEmail)
                .map(EmailAddress::new)
                .collect(Collectors.toList());
        list3.forEach(System.out::println);
        System.out.println();
    }

    // 4. Получить список книг, взятых читателями. Список не должен содержать дубликатов
    public static void m4() {
        List<Book> list4 = library.getReaders().stream()
                .flatMap(reader -> reader.getBooks().stream())
                .distinct()
                .collect(Collectors.toList());
        list4.forEach(System.out::println);
        System.out.println();
    }
    // 5. Проверить, взял ли кто-то из читателей библиотеки книги Оруэлла
    public static void m5(){
        boolean match = library.getReaders().stream()
                .flatMap(reader -> reader.getBooks().stream())
                .anyMatch(book -> book.getAuthor().equals("Оруэлла"));
        System.out.println(match);
    }

    // 6. Узнать наибольшее число книг, которое сейчас на руках у читателей
    public static void m6(){
        System.out.println(library.getReaders().stream()
                .map(reader -> reader.getBooks().size())
                .reduce(0, (max, size) -> size > max ? size : max));
        System.out.println();
    }

// 7.
    public static void m7(){
        Map<String, List<EmailAddress>> map = library.getReaders().stream()
                .filter(Reader::getAgree)
                .collect(Collectors.groupingBy(reader -> reader.getBooks().size() > 2 ? "TOO_MUCH" : "OK",
                        Collectors.mapping(reader -> new EmailAddress(reader.getEmail()),
                                Collectors.toList())));
    for(Map.Entry<String, List<EmailAddress>> pair: map.entrySet()){
        String str = pair.getKey();
        List<EmailAddress> list = pair.getValue();
        System.out.println(str + " --> " + list);
    }
    }


}
