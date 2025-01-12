package com.visionariosUnidos.ERP.Auth.Entity;

import com.visionariosUnidos.ERP.Comunications.Entity.Chat;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AppUser")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role", referencedColumnName = "id") //name es el de esta clase, referenced es el de la clase Role
    private Role role;

    @ManyToMany(mappedBy = "users") // En MappedBy se especifica nombre del atributo(de la entity Chat) que crea la clase intermedia
    private List<Chat> chats;

}
