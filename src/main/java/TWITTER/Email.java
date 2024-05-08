package TWITTER;

public class Email {
    private String address;

    public Email(String address) {
        if (!Utils.isValidEmail(address)) {
            throw new IllegalArgumentException("Email no válido");
        }
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
