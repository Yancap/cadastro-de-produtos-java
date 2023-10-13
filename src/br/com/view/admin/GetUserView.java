package br.com.view.admin;

import br.com.Input;
import br.com.Session;
import br.com.controller.UserController;
import br.com.view.AdminView;
import br.com.view.EndView;
import br.com.view.View;

import java.util.InputMismatchException;

public class GetUserView extends View {
  public GetUserView(){
    var endView = new EndView();
    this.viewNode.add(endView);

  }
  public void goBack() {
    new AdminView().init();
    return;
  }
  public void init() {
    var userController = new UserController();
    do {
      try {
        var email = Session.getEmail();
        var usersProducts = userController.getAll();

        System.out.println("***************************** USUARIOS CADASTRADOS *****************************");
        System.out.println("|       ID       |         NAME         |           EMAIL          |    ROLE    |");
        usersProducts.forEach(UserView::show);
        System.out.println("\nQual ação deseja fazer?");
        System.out.println("0 - Sair");
        System.out.println("1 - Voltar");

        System.out.print("\n >> ");
        screenSequence = Input.in.nextInt();
        Input.in.nextLine();
        if(screenSequence == 1){
          goBack();
          return;
        }


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
      }
    } while(error);


  }
}
