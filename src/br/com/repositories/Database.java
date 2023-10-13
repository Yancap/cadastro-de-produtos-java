package br.com.repositories;

import br.com.repositories.product.ProductRepository;
import br.com.repositories.user.UserRepository;

public class Database {
  public final static UserRepository users = new UserRepository();
  public final static ProductRepository products = new ProductRepository(users);

}
