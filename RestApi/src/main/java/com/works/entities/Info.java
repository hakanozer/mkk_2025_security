package com.works.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Info {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iid;

    private String url;
    private String sessionId;
    private String username;
    private String role;
    private String agent;
    private String ip;
    private long time;

}
