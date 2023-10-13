package br.com.view;

import br.com.Input;

import java.util.InputMismatchException;

public class StartView extends View{

  public StartView(LoginView loginView){
    var endView = new EndView();
    this.viewNode.add(loginView);
    this.viewNode.add(endView);
  }
  public void init() {

    do {
      try {

        System.out.println("****** SISTEMA DE CADASTRO DE PRODUTO ******\n");
        System.out.println("Escolha uma das opções a seguir para continuar");
        System.out.println("1 - Login");
        System.out.println("2 - Sair");
        System.out.print("\n >> ");

        screenSequence = Input.in.nextInt() - 1;
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
        System.out.println("Digite um valor valido");
        error = true;
        continue;
      }
    } while(error);
  }

}
