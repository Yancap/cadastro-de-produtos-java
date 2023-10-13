package br.com.models;

import br.com.dto.products.ProductDTO;

import java.util.Objects;

public class ProductModel {
  public Integer id;
  public String name;
  public String category;
  public Double price;
  public Integer user_id;
  public ProductModel(ProductDTO product){
    this.name = product.name();
    this.category = product.category();
    this.price = product.price();
    this.id = this.hashCode();
    this.user_id = product.user_id();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ProductModel that = (ProductModel) o;
    return Objects.equals(name, that.name) && Objects.equals(category, that.category) && Objects.equals(user_id, that.user_id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, category, user_id);
  }
}
