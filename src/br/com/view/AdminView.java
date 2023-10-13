package br.com.view;

import br.com.Input;
import br.com.view.admin.DeleteUserView;
import br.com.view.admin.GetUserView;
import br.com.view.admin.RegisterUserVIew;

import java.util.InputMismatchException;

public class AdminView extends View{
  public AdminView(){
    var endView = new EndView();

    var getUserView = new GetUserView();
    var registerUserView = new RegisterUserVIew();
    var deleteUserView = new DeleteUserView();
    this.viewNode.add(endView);
    this.viewNode.add(getUserView);
    this.viewNode.add(registerUserView);
    this.viewNode.add(deleteUserView);
  }

  public void init() {
    clean();
    do {
      try {
        System.out.println("****** SEJA BEM VINDO ******\n");
        System.out.println("Escolha uma das opções a seguir");
        System.out.println("1 - Ver usuários");
        System.out.println("2 - Cadastrar novos usuários");
        System.out.println("3 - Deletar usuários");
        System.out.println("\n0 - Sair");
        System.out.print("\n >> ");

        screenSequence = Input.in.nextInt();
        Input.in.nextLine();
        clean();
        this.getViewNode();

        error = false;
        return;
      } catch (Exception e) {
        clean();
        if(e instanceof InputMismatchException) {
          Input.in.nextLine();
        }
        System.out.println("Digite um valor valido!!!\n");
        error = true;
        continue;
      }
    } while(error);


  }

}