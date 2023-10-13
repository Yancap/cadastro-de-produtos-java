package br.com.repositories.user;

import br.com.dto.users.CreateUserDTO;
import br.com.dto.users.LoginUserDTO;
import br.com.models.UserModel;

import java.util.List;

public interface IUserRepository {
  UserModel create(CreateUserDTO user);
  UserModel findByEmail(String email);
  UserModel findByEmailAndPassword(LoginUserDTO user);
  boolean delete(Integer id);
  List<UserModel> getAll();
}
