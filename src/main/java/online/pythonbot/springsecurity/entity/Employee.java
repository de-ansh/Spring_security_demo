package online.pythonbot.springsecurity.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name="employee_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeid;

    @Column(name = "employee firstname", length= 255)
    private String employeefirstname;

    @Column(name = "employee lastname", length= 255)
    private String employeelastname;

    @Column(name = "email", length= 255)
    private String email;

    @Column(name = "password", length= 255)
    private String password;

    public Employee() {
    }

    public Employee(int employeeid, String employeefirstname, String employeelastname, String email, String password) {
        this.employeeid = employeeid;
        this.employeefirstname = employeefirstname;
        this.employeelastname = employeelastname;
        this.email = email;
        this.password = password;
    }

    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    public String getEmployeefirstname() {
        return employeefirstname;
    }

    public void setEmployeefirstname(String employeefirstname) {
        this.employeefirstname = employeefirstname;
    }

    public String getEmployeelastname() {
        return employeelastname;
    }

    public void setEmployeelastname(String employeelastname) {
        this.employeelastname = employeelastname;
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

    @Override
    public String toString() {
        return "Employee{" +
                "employeeid=" + employeeid +
                ", employeefirstname='" + employeefirstname + '\'' +
                ", employeelastname='" + employeelastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
