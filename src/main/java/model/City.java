package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "city_name")
    private String name;

    @OneToMany(mappedBy = "city",cascade = CascadeType.ALL)
    private List<Employee> employeeList;

    public City(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public City(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public City(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public City(String name) {
        this.name = name;
    }

    public City() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "city_name='" + name + '\'' +
                '}';
    }
}
