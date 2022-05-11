package co.gatojunior.co.restaurant.rest;

import co.gatojunior.co.restaurant.exceptions.ResourceNotFoundException;
import co.gatojunior.co.restaurant.models.Restaurant;
import co.gatojunior.co.restaurant.services.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private IRestaurantService restoService;

    @GetMapping
    public List<Restaurant> findAll() {
        return restoService.findAll();
    }
    @GetMapping("/{id}")
    public Restaurant findById(@PathVariable("id") String identifiant) {
        Restaurant reponse = restoService.findById(identifiant);
        if(reponse == null) {
            return null;
           // throw new ResourceNotFoundException();
        }
        return reponse;
    }
}
