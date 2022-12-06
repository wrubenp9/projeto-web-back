package com.br.userservice.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity(name = "user")
@Table(name = "tb_user")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String sobrenome;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String senha;
    @Column(nullable = false)
    private String tipo;

}
