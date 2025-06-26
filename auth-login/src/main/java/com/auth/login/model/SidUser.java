// SidUser.java
package com.auth.login.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sidusers")
@Data
public class SidUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String password;
}
