package entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
public class Owner {

    @OneToMany
    @JoinColumn(name = "Owner_Id")
    private Set<Car> carSet;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;

}
