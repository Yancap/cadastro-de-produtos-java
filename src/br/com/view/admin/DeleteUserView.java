package br.com.view.admin;

import br.com.Input;
import br.com.Session;
import br.com.controller.ProductController;
import br.com.controller.UserController;
import br.com.view.AdminView;
import br.com.view.EmployeeView;
import br.com.view.EndView;
import br.com.view.View;
import br.com.view.employee.ProductsView;

import java.util.InputMismatchException;

public class DeleteUserView extends View {
  public DeleteUserView(){
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
        var email = Session.getEmail();
        var usersProducts = userController.getAll();

        System.out.println("***************************** USUARIOS CADASTRADOS *****************************");
        System.out.println("|       ID       |         NAME         |           EMAIL          |    ROLE    |");
        usersProducts.forEach(UserView::show);

        System.out.println("\nDigite o id do usuário que deseja excluir");
        System.out.print(" >> ");
        var user_id = Input.in.nextInt();
        Input.in.nextLine();
        var isDeleted = userController.delete(user_id, email);
        if (!isDeleted) {
          throw new RuntimeException("ID do usuário inválido");
        }
        clean();
        error = false;
      } catch (Exception e) {
        clean();
        if(e instanceof InputMismatchException) {
          Input.in.nextLine();
          error = true;
          System.out.println("ID do usuário inválido");
          continue;
        }
        System.out.println(e.getMessage());
        error = true;
      }
    } while (error);
    do {
      try {
        System.out.println("Usuário deletado com sucesso");
        System.out.println("\nQual ação deseja fazer?");
        System.out.println("0 - Sair");
        System.out.println("1 - Continuar");
        System.out.println("2 - Voltar");

        System.out.print("\n >> ");
        screenSequence = Input.in.nextInt();
        Input.in.nextLine();
        if(screenSequence == 2){
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
          continue;
        }
      }
    } while(error);


  }
}