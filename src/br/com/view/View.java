package br.com.view;

import java.util.ArrayList;
import java.util.List;

public abstract class View {
  protected boolean error = false;
  protected int screenSequence;
  protected List<View> viewNode= new ArrayList<>();
  protected abstract void init();

  protected void getViewNode() {
    this.viewNode.get(screenSequence).init();
  };
  protected void clean(){
    try {
      final String os = System.getProperty("os.name");

      if (os.contains("Windows")){
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      }
      else {
        String[] terminal = new String[] {"clean"};
        Runtime.getRuntime().exec(terminal);
      }
    }
    catch (final Exception e){
      System.out.println(e);
    }
  }
}
