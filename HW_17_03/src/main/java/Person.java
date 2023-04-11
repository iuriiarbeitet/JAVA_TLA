/**
 * Task 2. Что выведет фрагмент кода? Объяснить.
 * import java.util.HashSet;
 * class Person {
 * String name;
 * Person(String name) { this.name = name; }
 * public String toString() { return name; }
 * }
 * class TestHashSet {
 * public static void main(String args[]) {
 * HashSet set = new HashSet<>();
 * Person p1 = new Person("Иван");
 * Person p2 = new Person("Мария");
 * Person p3 = new Person("Пётр");
 * Person p4 = new Person("Мария");
 * set.add(p1);
 * set.add(p2);
 * set.add(p3);
 * set.add(p4);
 * System.out.print(set.size());
 * }
 */

import java.util.HashSet;
import java.util.Objects;

public class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String toString() {
        return name;
    }
}

class TestHashSet {
    public static void main(String args[]) {
        HashSet set = new HashSet<>();
        Person p1 = new Person("Иван");
        Person p2 = new Person("Maria");
        Person p3 = new Person("Пётр");
        Person p4 = new Person("Maria");
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        System.out.print(set.size());
        System.out.println(set);
    }
}

