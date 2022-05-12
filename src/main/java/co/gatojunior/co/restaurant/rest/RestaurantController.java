package co.gatojunior.co.restaurant.rest;

import co.gatojunior.co.restaurant.exceptions.ResourceNotFoundException;
import co.gatojunior.co.restaurant.models.Restaurant;
import co.gatojunior.co.restaurant.services.IRestaurantService;
import co.gatojunior.co.restaurant.util.CtrlPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private IRestaurantService restoService;

    @GetMapping
    public List<Restaurant> findAll() {
        List<Restaurant> restaurants = restoService.findAll();
        for (Restaurant restaurant : restaurants) {
            Link selfLink = WebMvcLinkBuilder.linkTo(RestaurantController.class).slash(restaurant.getId()).withSelfRel();
            restaurant.add(selfLink);
        }
        return restaurants;
    }
    @GetMapping("/{id}")
    public Restaurant findById(@PathVariable("id") String identifiant) {
        Restaurant reponse = restoService.findById(identifiant);
        CtrlPreconditions.checkFound(reponse);
        Link menusLink = WebMvcLinkBuilder.linkTo(RestaurantController.class).slash(reponse.getId()).slash("menus").withRel("menus");
        reponse.add(menusLink);
        return reponse;
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public String create(@RequestBody Restaurant restaurant) {
        return restoService.create(restaurant);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@PathVariable("id") String identifiant, @RequestBody Restaurant restaurant) {
        if(restoService.findById(identifiant) == null) {
            throw new ResourceNotFoundException();
        }
        restoService.update(identifiant, restaurant);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void partialUpdate(@PathVariable("id") String identifiant, @RequestBody Map<String, Object> updates) {
        if(restoService.findById(identifiant) == null) {
            throw new ResourceNotFoundException();
        }
        restoService.partialUpdate(identifiant, updates);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteById(@PathVariable("id") String identifiant) {
        CtrlPreconditions.checkFound(restoService.findById(identifiant));
        restoService.deleteById(identifiant);
    }
}
