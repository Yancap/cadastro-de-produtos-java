package br.com.view.employee;

import br.com.models.ProductModel;

import java.text.NumberFormat;
import java.util.Locale;

public class ProductsView {
  public static void show(ProductModel product){
    int middle = (12 - product.id.toString().length()) / 2 + 1;
    int start = middle - 1;
    int end = start + product.id.toString().length();

    String idRow = "";
    for (int i = 0; i < 13; i++) {
      if(i < start || i > end) {
        idRow = idRow + " ";
      } else if (i == middle) {
        idRow = idRow + product.id;
      }
    }

    middle = (15 - product.name.length()) / 2 + 1;
    start = middle - 1;
    end = start + product.name.length();

    String nameRow = "";
    for (int i = 0; i < 15; i++) {
      if(i < start || i > end) {
        nameRow = nameRow + " ";
      } else if (i == middle) {
        nameRow = nameRow + product.name;
      }
    }

    middle = (18 - product.category.length()) / 2 + 1;
    start = middle - 1;
    end = start + product.category.length();

    String categoryRow = "";
    for (int i = 0; i < 19; i++) {
      if(i < start || i > end) {
        categoryRow = categoryRow + " ";
      } else if (i == middle) {
        categoryRow = categoryRow + product.category;
      }
    }


    Locale ptBr = new Locale("pt", "BR");
    String price = NumberFormat.getCurrencyInstance(ptBr).format(product.price);

    middle = (17 - price.length()) / 2 + 1;
    start = middle - 1;
    end = start + price.length();

    String priceRow = "";

    for (int i = 0; i < 18; i++) {
      if(i < start || i > end) {
        priceRow = priceRow + " ";
      } else if (i == middle) {
        priceRow = priceRow + price;
      }
    }

    System.out.print("|" + idRow + "|");
    System.out.print(nameRow + "|");
    System.out.print(categoryRow + "|");
    System.out.print(priceRow + "|");
    System.out.println();
  }

}
