package com.br.userservice.controller.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDto {
    private UUID id;
    private String nome;
    private String sobrenome;
    private String email;
    private String tipo;
}
