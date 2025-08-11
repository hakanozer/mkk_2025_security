package com.works.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nid;

    private String username;
    @JsonIgnore
    private String password;
    private Boolean enable;

    @ManyToMany
    private List<Role> roles;
}
