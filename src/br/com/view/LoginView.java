package br.com.view;

import br.com.Input;
import br.com.Session;
import br.com.controller.UserController;
import br.com.dto.users.LoginUserDTO;
import br.com.dto.users.SessionUserDTO;
import br.com.models.enums.Roles;

public class LoginView extends View{
  public LoginView(EmployeeView employeeView, AdminView adminView){
    var endView = new EndView();
    this.viewNode.add(endView);
    this.viewNode.add(employeeView);
    this.viewNode.add(adminView);
  }
  public void init() {
    var userController = new UserController();
    do {
      try {

        System.out.println("****** LOGIN ******\n");
        System.out.println("Digite seu email e senha por favor!");
        System.out.println("Digite 0 para sair");
        System.out.print("Email: ");

        var email = Input.in.next();
        Input.in.nextLine();

        if(email.equals("0")) {
          screenSequence = 0;
          getViewNode();
          return;
        }

        System.out.print("Senha: ");
        var password = Input.in.next();
        Input.in.nextLine();
        var user = userController.login(new LoginUserDTO(email, password));
        Session.setDataSession(new SessionUserDTO(user.name, user.email));

        if(Roles.stockist.equals(user.role)) {
          screenSequence = 1;
          this.getViewNode();
        } else {
          screenSequence = 2;
          this.getViewNode();
        }
        error = false;
        return;
      } catch (Exception e) {
        clean();
        System.out.println("Credenciais Inválidas\n Tente Novamente!");
        error = true;
        continue;
      }
    } while(error);

  }
}
