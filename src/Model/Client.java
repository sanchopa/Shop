package Model;

public class Client {
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String address;

    public Client(String name, String surname, String email, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client: " + name + ' ' + surname + " phone: " + phone + " ";
    }
}
