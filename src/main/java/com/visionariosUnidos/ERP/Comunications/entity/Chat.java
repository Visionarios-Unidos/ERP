package com.visionariosUnidos.ERP.Comunications.entity;

import com.visionariosUnidos.ERP.Auth.Entity.User;
import com.visionariosUnidos.ERP.Comunications.constants.Visibility;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Visibility visibility;

    @ManyToMany
    @JoinTable(
            name = "User_Chat",
            joinColumns = @JoinColumn(name = "chat_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;

    @OneToMany(targetEntity = Message.class, cascade = CascadeType.ALL, mappedBy = "chat")
    private List<Message> messages;
}
