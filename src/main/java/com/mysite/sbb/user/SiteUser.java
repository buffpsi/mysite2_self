package com.mysite.sbb.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SiteUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true) //unique = true 는 중복되지않는 유일한 값이 되도록
    private String username;
    private String password;
    @Column(unique = true)
    private String email;
}
