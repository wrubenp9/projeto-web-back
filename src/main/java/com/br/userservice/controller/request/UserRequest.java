package com.br.userservice.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private String tipo;
}
