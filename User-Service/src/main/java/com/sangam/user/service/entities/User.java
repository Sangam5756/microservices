package com.sangam.user.service.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "micro_users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "id")
    private Long userId;


    private String email;


    private String password;
    @Column(length = 50)
    private String about;


    @Transient
    private List<Rating> ratings = new ArrayList<>();


}
