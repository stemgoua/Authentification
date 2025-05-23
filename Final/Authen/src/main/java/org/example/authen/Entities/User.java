package org.example.authen.Entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Users")
public class User {
     @Setter
     @Getter
     @Id

     @GeneratedValue(strategy= GenerationType.AUTO)

     private int id;

     @Setter
     @Getter
     private String username;

     @Setter
     @Getter
     private String password;

     @Setter
     @Getter
     private String email;

    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;


}
