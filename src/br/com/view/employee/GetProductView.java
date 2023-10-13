package br.com.view.employee;

import br.com.Input;
import br.com.Session;
import br.com.controller.ProductController;
import br.com.view.EmployeeView;
import br.com.view.EndView;
import br.com.view.View;

import java.util.InputMismatchException;

public class GetProductView extends View {
  public GetProductView(){
    var endView = new EndView();
    this.viewNode.add(endView);

  }
  public void goBack() {
    new EmployeeView().init();
    return;
  }
  public void init() {
    var productController = new ProductController();
    do {
      try {
        var email = Session.getEmail();
        var usersProducts = productController.getByUser(email);

        System.out.println("******************* SEUS PRODUTOS CADASTRADOS *******************\n");
        System.out.println("|     ID     |     NAME     |     CATEGORY     |      PRICE      |");
        usersProducts.forEach(ProductsView::show);
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