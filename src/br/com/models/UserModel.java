package br.com.models;

import br.com.dto.users.CreateUserDTO;
import br.com.models.enums.Roles;

import java.util.Objects;

public class UserModel {
  public Integer id;
  public String name;
  public String email;
  public String password;
  public Roles role;
  public UserModel(CreateUserDTO user){
    this.name = user.name();
    this.email = user.email();
    this.password = user.password();
    this.role = user.role();
    this.id = this.hashCode();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserModel that = (UserModel) o;
    return Objects.equals(name, that.name) && Objects.equals(email, that.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, email);
  }
}
