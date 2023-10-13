package br.com.view.employee;

import br.com.Input;
import br.com.Session;
import br.com.controller.ProductController;
import br.com.view.EmployeeView;
import br.com.view.EndView;
import br.com.view.View;

import java.util.InputMismatchException;

public class DeleteProductView extends View {
  public DeleteProductView(){
    var endView = new EndView();
    this.viewNode.add(endView);
    this.viewNode.add(this);
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
        if(usersProducts.size() == 0) {
          goBack();
          return;
        }
        System.out.println("******************* SEUS PRODUTOS CADASTRADOS *******************\n");
        System.out.println("|     ID     |     NAME     |     CATEGORY     |      PRICE      |");
        usersProducts.forEach(ProductsView::show);

        System.out.println("\nDigite o ID do produto que deseja excluir");
        System.out.print(" >> ");
        var product_id = Input.in.nextInt();
        Input.in.nextLine();
        var isDeleted = productController.delete(product_id, email);
        if(!isDeleted) {
          throw new RuntimeException("ID do produto inválido ou você não tem permissão para deletar");
        }
        clean();
        error = false;

      } catch (Exception e) {
        clean();
        error = true;
        if(e instanceof InputMismatchException) {
          Input.in.nextLine();
          System.out.println("ID do produto inválido ou você não tem permissão para deletar");
          continue;
        }
        System.out.println(e.getMessage());

      }
    } while(error);
    do {
      try {
        System.out.println("Produto deletado com sucesso");
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
