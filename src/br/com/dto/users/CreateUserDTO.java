package br.com.dto.users;

import br.com.models.enums.Roles;

public record CreateUserDTO(String name, String email, String password, Roles role) {

}
