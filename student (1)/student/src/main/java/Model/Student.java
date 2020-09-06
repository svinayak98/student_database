package Model;

import javax.persistence.*;

@Entity
@Table
public class Student {
    @Id
    @GeneratedValue
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String mobileNumber;

    public Student() {
        super();
    }

    public Student(int id, String name, String mobileNumber) {
        super();
        this.id = id;
        this.name = name;
        this.mobileNumber = mobileNumber;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

}
