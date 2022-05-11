package co.gatojunior.co.restaurant.services;

import co.gatojunior.co.restaurant.models.Restaurant;

import java.util.List;

public interface IRestaurantService {
    public List<Restaurant> findAll();
    public Restaurant findById(String id);
}
