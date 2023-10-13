package br.com.controller;

import br.com.dto.products.AddProductDTO;
import br.com.models.ProductModel;
import br.com.repositories.Database;
import br.com.repositories.product.ProductRepository;

import java.util.List;

public class ProductController {
  private ProductRepository productRepository;
  public ProductController(){
    this.productRepository = Database.products;
  }

  public ProductModel add(AddProductDTO product) {
    return productRepository.create(product);
  }

  public List<ProductModel> getByUser(String email) {
    return productRepository.getByUser(email);
  }

  public boolean delete(Integer id, String email) {
    var isDeleted = productRepository.delete(id, email);
    return isDeleted;
  }
}
