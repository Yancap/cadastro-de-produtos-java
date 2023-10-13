package br.com.repositories.product;

import br.com.dto.products.AddProductDTO;
import br.com.dto.products.ProductDTO;
import br.com.models.ProductModel;

import java.util.List;

public interface IProductRepository {
  ProductModel create(AddProductDTO product);
  List<ProductModel> getByUser(String email);
  boolean delete(Integer id, String email);
}
