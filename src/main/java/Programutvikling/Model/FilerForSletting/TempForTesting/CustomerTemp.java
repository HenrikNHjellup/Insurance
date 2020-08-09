package Programutvikling.Model.FilerForSletting.TempForTesting;

public class CustomerTemp {
    private String firstName, lastName, customerId;

    public CustomerTemp(String firstName, String lastname, String customerId) {
        this.firstName = firstName;
        lastName = lastname;
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
