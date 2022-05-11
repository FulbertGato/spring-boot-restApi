package co.gatojunior.co.restaurant.dao;

import co.gatojunior.co.restaurant.models.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface IRestaurantRepository extends CrudRepository<Restaurant, String> {
}
