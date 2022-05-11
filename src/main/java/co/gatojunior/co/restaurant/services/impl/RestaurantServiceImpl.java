package co.gatojunior.co.restaurant.services.impl;

import co.gatojunior.co.restaurant.dao.IRestaurantRepository;
import co.gatojunior.co.restaurant.models.Restaurant;
import co.gatojunior.co.restaurant.services.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RestaurantServiceImpl implements IRestaurantService {

    @Autowired
    private IRestaurantRepository restoRepository;

    @Override
    public List<Restaurant> findAll() {
        List<Restaurant> liste = new ArrayList<Restaurant>();
        restoRepository.findAll().forEach(liste::add);
        return liste;
    }

    @Override
    public Restaurant findById(String id) {
        if(restoRepository.findById(id).isPresent()) {
            return restoRepository.findById(id).get();
        }
        return null;
    }
}
