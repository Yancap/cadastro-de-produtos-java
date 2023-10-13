package br.com.view.admin;

import br.com.models.UserModel;


public class UserView {
  public static void show(UserModel user){
    int middle = (16 - user.id.toString().length()) / 2 + 1;
    int start = middle - 1;
    int end = start + user.id.toString().length();

    String idRow = "";
    for (int i = 0; i < 17; i++) {
      if(i < start || i > end) {
        idRow = idRow + " ";
      } else if (i == middle) {
        idRow = idRow + user.id;
      }
    }

    middle = (22 - user.name.length()) / 2 + 1;
    start = middle - 1;
    end = start + user.name.length();

    String nameRow = "";
    for (int i = 0; i < 23; i++) {
      if(i < start || i > end) {
        nameRow = nameRow + " ";
      } else if (i == middle) {
        nameRow = nameRow + user.name;
      }
    }

    middle = (26 - user.email.length()) / 2 + 1;
    start = middle - 1;
    end = start + user.email.length();

    String emailRow = "";
    for (int i = 0; i < 27; i++) {
      if(i < start || i > end) {
        emailRow = emailRow + " ";
      } else if (i == middle) {
        emailRow = emailRow + user.email;
      }
    }

    middle = (12 - user.role.name().length()) / 2 + 1;
    start = middle - 1;
    end = start + user.role.name().length();

    String roleRow = "";
    for (int i = 0; i < 13; i++) {
      if(i < start || i > end) {
        roleRow = roleRow + " ";
      } else if (i == middle) {
        roleRow = roleRow + user.role.name();
      }
    }

    System.out.print("|" + idRow + "|");
    System.out.print(nameRow + "|");
    System.out.print(emailRow + "|");
    System.out.print(roleRow + "|");
    System.out.println();
  }

}
