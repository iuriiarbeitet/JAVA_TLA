import java.util.ArrayList;
import java.util.List;

public class Reader {

    private String name;
    private String email;
    private List<Book> books = new ArrayList<>();
    private boolean isAgree;    // флаг согласия на рассылку

    public Reader(String name, String email, boolean isAgree) {
        this.name = name;
        this.email = email;
        this.isAgree = isAgree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public boolean getAgree() {
        return isAgree;
    }

    public void setAgree(boolean agree) {
        isAgree = agree;
    }

}
