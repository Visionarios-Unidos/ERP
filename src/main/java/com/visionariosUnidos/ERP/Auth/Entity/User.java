package com.visionariosUnidos.ERP.Auth.Entity;

import com.visionariosUnidos.ERP.Comunications.entity.Chat;
import com.visionariosUnidos.ERP.Comunications.entity.Message;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id") //name es el de esta tabla, referenced es el de la tabla roles
    private Role roles;

    @ManyToMany(mappedBy = "users") // En MappedBy se especifica nombre del atributo(de la entity Chat) que crea la clase intermedia
    private List<Chat> chats;

    @OneToMany(targetEntity = Message.class, cascade = CascadeType.ALL, mappedBy = "user")
    private List<Message> messages;
}
