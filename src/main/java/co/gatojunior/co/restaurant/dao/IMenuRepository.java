package co.gatojunior.co.restaurant.dao;

import co.gatojunior.co.restaurant.models.Menu;
import org.springframework.data.repository.CrudRepository;

public interface IMenuRepository extends CrudRepository<Menu, String> {
}