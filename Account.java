public class Account {

    // Variables to store account information
    private String name;
    private String ppsNumber;
    private String email;
    private String password;
    private String address;
    private float initialBalance;

    // Constructor for all details
    public Account(String name, String ppsNumber, String email, String password, String address, float initialBalance) {
        super();
        this.name = name;
        this.ppsNumber = ppsNumber;
        this.email = email;
        this.password = password;
        this.address = address;
        this.initialBalance = initialBalance;
    }

// Return account prompt with delimiter
public String toString() {
    return name + "*" + ppsNumber + "*"+ email +"*" + password + "*" + address + "*" + initialBalance;
}


    // Getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPpsNumber() {
        return ppsNumber;
    }

    public void setPpsNumber(String ppsNumber) {
        this.ppsNumber = ppsNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(float initialBalance) {
        this.initialBalance = initialBalance;
    }
}