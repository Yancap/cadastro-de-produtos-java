package br.com.view;

import br.com.Input;
import br.com.view.employee.AddProductView;
import br.com.view.employee.DeleteProductView;
import br.com.view.employee.GetProductView;

import java.util.InputMismatchException;

public class EmployeeView extends View{
  public EmployeeView(){
    var endView = new EndView();
    var addProductView = new AddProductView();
    var getProductView = new GetProductView();
    var deleteProductView = new DeleteProductView();
    this.viewNode.add(endView);
    this.viewNode.add(getProductView);
    this.viewNode.add(addProductView);
    this.viewNode.add(deleteProductView);
  }

  public void init() {
    clean();
    do {
      try {
        System.out.println("****** SEJA BEM VINDO ******\n");
        System.out.println("Escolha uma das opções a seguir");
        System.out.println("1 - Ver seus produtos");
        System.out.println("2 - Cadastrar produtos");
        System.out.println("3 - Deletar produtos");
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
