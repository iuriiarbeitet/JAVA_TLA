import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;
    private List<Reader> readers;

    public Library() {
        books = new ArrayList<>();
        Book book1 = new Book("Оруэлла", "name1", 2015);
        Book book2 = new Book("author2", "name2", 2020);
        Book book3 = new Book("author3", "name3", 2021);
        Book book4 = new Book("author4", "name4", 2010);
        Book book5 = new Book("author5", "name5", 2012);
        Book book6 = new Book("author6", "name6", 2009);
        Book book7 = new Book("author7", "name7", 2021);
        Book book8 = new Book("author8", "name8", 2018);
        Book book9 = new Book("author9", "name9", 2016);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        books.add(book8);
        books.add(book9);

        readers = new ArrayList<>();
        Reader reader1 = new Reader("John", "john@mail.ru", true);
        Reader reader2 = new Reader("Ann", "ann@mail.ru", false);
        Reader reader3 = new Reader("Barton", "barton@mail.ru", true);
        Reader reader4 = new Reader("Kevin", "kevin@mail.ru", true);
        readers.add(reader1);
        readers.add(reader2);
        readers.add(reader3);
        readers.add(reader4);

        reader1.getBooks().add(book1);
        reader1.getBooks().add(book2);
        reader1.getBooks().add(book5);
        reader2.getBooks().add(book1);
        reader2.getBooks().add(book3);
        reader2.getBooks().add(book7);
        reader2.getBooks().add(book9);
        reader3.getBooks().add(book5);
        reader4.getBooks().add(book4);
        reader4.getBooks().add(book8);

    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }
}
