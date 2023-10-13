package br.com.view.admin;

import br.com.Input;
import br.com.Session;
import br.com.controller.UserController;
import br.com.dto.users.RegisterUserDTO;
import br.com.view.AdminView;
import br.com.view.EndView;
import br.com.view.View;

import java.util.InputMismatchException;

public class RegisterUserVIew extends View {
  public RegisterUserVIew(){
    var endView = new EndView();
    this.viewNode.add(endView);
    this.viewNode.add(this);
  }
  public void goBack() {
    new AdminView().init();
    return;
  }
  public void init() {
    var userController = new UserController();
    do {
      try {
        System.out.println("****** CADASTRO DE USUÁRIOS ******\n");
        System.out.print("Digite o nome do usuário: ");
        var name = Input.in.next();
        Input.in.nextLine();

        System.out.print("Digite o email do usuário: ");
        var email = Input.in.next();
        Input.in.nextLine();

        System.out.print("Digite a senha do usuário: ");
        var password = Input.in.next();
        Input.in.nextLine();

        var user = userController.register(new RegisterUserDTO(name, email, password), Session.getEmail());

        clean();
        System.out.println("Usuário cadastrado com sucesso!!!");
        error = false;
      } catch (Exception e) {
        clean();
        System.out.println(e.getMessage());
        error = true;
      }
    } while(error);
    do {
        try {
        System.out.println("Qual ação deseja fazer?");
        System.out.println("0 - Sair");
        System.out.println("1 - Continuar");
        System.out.println("2 - Voltar");

        System.out.print("\n >> ");
        screenSequence = Input.in.nextInt();
        Input.in.nextLine();
        clean();
        if(screenSequence == 2) {
          goBack();
          return;
        }

        this.getViewNode();

        error = false;
        return;
      } catch (Exception e) {
        clean();
        error = true;
        if(e instanceof InputMismatchException) {
          Input.in.nextLine();
        }
      }
    } while(error);


  }
}