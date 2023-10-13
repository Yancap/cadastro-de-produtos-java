package br.com.repositories.user;

import br.com.dto.users.CreateUserDTO;
import br.com.dto.users.LoginUserDTO;
import br.com.models.UserModel;
import br.com.models.enums.Roles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class UserRepository implements IUserRepository {
  private List<UserModel> users = new ArrayList<>();

  public UserRepository() {
    this.users.add(new UserModel(new CreateUserDTO("Yan", "yan@email.com", "123", Roles.admin)));
    this.users.add(new UserModel(new CreateUserDTO("John", "john@email.com", "123", Roles.stockist)));
  }
  public UserModel create(CreateUserDTO user) {
    var userCreated = new UserModel(user);
    this.users.add(userCreated);
    return userCreated;
  };

  public UserModel findByEmailAndPassword(LoginUserDTO user) {
    return this.users
      .stream()
      .filter( userDB -> userDB.email.equals(user.email()) &&
                userDB.password.equals(user.password())
      )
      .findFirst().get();
  };

  public UserModel findByEmail(String email) {
    try {
      return this.users
              .stream()
              .filter( userDB -> userDB.email.equals(email))
              .findFirst().get();
    } catch (Exception e) {
      return null;
    }

  }
  public boolean delete(Integer id) {
    AtomicBoolean control = new AtomicBoolean(false);
    users = users.stream()
            .filter(user -> {
              if(user.id.equals(id)) {
                control.set(true);
                return false;
              }
              return true;
            })
            .collect(Collectors.toList());
    return control.get();
  }
  public List<UserModel> getAll() {
    return this.users;
  };

}
