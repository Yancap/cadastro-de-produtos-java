package br.com.view.employee;

import br.com.Input;
import br.com.controller.ProductController;
import br.com.dto.products.AddProductDTO;
import br.com.view.EmployeeView;
import br.com.view.EndView;
import br.com.view.View;

import java.util.InputMismatchException;

public class AddProductView extends View {
  public AddProductView(){
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
    clean();
    do {
      try {
        System.out.println("****** CADASTRO DE PRODUTOS ******\n");
        System.out.print("Digite o nome do produto: ");
        var name = Input.in.next();
        Input.in.nextLine();

        System.out.print("Digite o categoria do produto: ");
        var category = Input.in.next();
        Input.in.nextLine();

        System.out.print("Digite o preço do produto: ");
        var price = Input.in.nextDouble();
        Input.in.nextLine();

        var product = productController.add(new AddProductDTO(name, category, price));
        if (product == null) {
          System.out.println("Ocorreu um error, tente novamente!");
          screenSequence = 2;
          this.getViewNode();
        }
        error = false;
      } catch (Exception e) {
        error = true;
        clean();
        if(e instanceof InputMismatchException) {
          Input.in.nextLine();
          System.out.println("Preço inválido");
          continue;
        }
        System.out.println(e.getMessage());
      }
    } while(error);
    do {
      try {
        clean();
        System.out.println("Produto cadastrado com sucesso!!!");

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
