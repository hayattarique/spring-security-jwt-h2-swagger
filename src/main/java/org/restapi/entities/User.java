package org.restapi.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "system_user_id")
    private Integer systemUserId;

    private String username;
    private String password;
    private String status;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

}
