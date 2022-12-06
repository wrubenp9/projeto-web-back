package com.br.userservice.controller.dto;

import lombok.Data;

@Data
public class UserDto {
    private Integer id;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private String tipo;
}
