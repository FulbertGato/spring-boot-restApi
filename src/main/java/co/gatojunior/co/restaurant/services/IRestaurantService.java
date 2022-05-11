package co.gatojunior.co.restaurant.services;

import co.gatojunior.co.restaurant.models.Restaurant;

import java.util.List;
import java.util.Map;

public interface IRestaurantService {
    public List<Restaurant> findAll();
    public Restaurant findById(String id);

    public String create(Restaurant restaurant);

    public void update(String identifiant, Restaurant restaurant);

    public void partialUpdate(String identifiant, Map<String,Object> updates);

    public void deleteById(String identifiant);
}
