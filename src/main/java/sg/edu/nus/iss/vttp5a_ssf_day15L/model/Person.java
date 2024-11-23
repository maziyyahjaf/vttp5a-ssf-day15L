package sg.edu.nus.iss.vttp5a_ssf_day15L.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Person {

    // practice - put in the necessary validations

    @NotNull(message = "ID cannot be empty")
    private Integer id;

    @NotEmpty(message = "Full name cannot be empty")
    @Size(min = 5, max = 200, message= "Name must be between 5 to 200 characters")
    private String fullName;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Proper email formatting please")
    private String email;

    
    public Person() {
    }

    public Person(Integer id, String fullName, String email) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return id + "," + fullName + "," + email;
    }

    


    

    
}
