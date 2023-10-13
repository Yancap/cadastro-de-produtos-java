package br.com.repositories.product;

import br.com.Session;
import br.com.dto.products.AddProductDTO;
import br.com.dto.products.ProductDTO;
import br.com.models.ProductModel;
import br.com.repositories.user.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class ProductRepository implements IProductRepository{
  private List<ProductModel> products = new ArrayList<>();
  private final UserRepository userRepository;
  public ProductRepository(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
  public ProductModel create(AddProductDTO product) {

    var user_id = userRepository.findByEmail(Session.getEmail()).id;
    var productDTO = new ProductDTO(product.name(), product.category(), product.price(), user_id);
    var productAdd = new ProductModel(productDTO);
    products.add(productAdd);
    return productAdd;
  }

  public List<ProductModel> getByUser(String email) {
    var user = userRepository.findByEmail(email);
    return products.stream()
            .filter(product -> product.user_id == user.id )
            .collect(Collectors.toList());
  }

  public boolean delete(Integer id, String email) {
    var user = userRepository.findByEmail(email);

    AtomicBoolean control = new AtomicBoolean(false);
    products = products.stream()
            .filter(product -> {
              if(product.id.equals(id) && product.user_id.equals(user.id)) {
                control.set(true);
                return false;
              }
              return true;
            })
            .collect(Collectors.toList());
    return control.get();
  }
}
