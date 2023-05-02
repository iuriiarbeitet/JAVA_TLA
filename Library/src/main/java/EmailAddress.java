public class EmailAddress {

    private String email;

    public EmailAddress(String email) {
        this.email = email;
    }

   public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "EmailAddress{" +
                "email='" + email + '\'' +
                '}';
    }
}
