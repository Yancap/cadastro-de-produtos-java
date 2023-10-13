package br.com.controller;

import br.com.dto.users.CreateUserDTO;
import br.com.dto.users.LoginUserDTO;
import br.com.dto.users.RegisterUserDTO;
import br.com.models.UserModel;
import br.com.models.enums.Roles;
import br.com.repositories.Database;
import br.com.repositories.user.UserRepository;

import java.util.List;

public class UserController {
  private final UserRepository userRepository;
  public UserController(){
    this.userRepository = Database.users;
  }

  public UserModel register(RegisterUserDTO user, String email){
    var userADM = userRepository.findByEmail(email);
    if(userADM == null || userADM.role.equals(Roles.stockist)){
      throw new RuntimeException("Você não tem permissão para executar essa ação");
    }

    var isEmailAlreadyExist = this.userRepository.findByEmail(user.email());
    if(isEmailAlreadyExist != null) throw  new RuntimeException("Email cadastrado já existe");

    var userDTO = new CreateUserDTO(user.name(), user.email(), user.password(), Roles.stockist);
    return this.userRepository.create(userDTO);
  }

  public UserModel login(LoginUserDTO user){
    var userDb = this.userRepository.findByEmailAndPassword(user);
    if(userDb == null){
      throw new RuntimeException();
    }
    return userDb;
  }
  public boolean delete(Integer user_id, String email){
    var user = userRepository.findByEmail(email);
    if(user == null || user.role.equals(Roles.stockist)){
      throw new RuntimeException("Você não tem permissão para executar essa ação");
    }
    return userRepository.delete(user_id);
  }
  public List<UserModel> getAll(){
    return this.userRepository.getAll();
  }
}
