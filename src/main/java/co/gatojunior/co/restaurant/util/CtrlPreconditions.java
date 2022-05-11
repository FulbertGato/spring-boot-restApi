package co.gatojunior.co.restaurant.util;

import co.gatojunior.co.restaurant.exceptions.ResourceNotFoundException;
import co.gatojunior.co.restaurant.models.Restaurant;

public final class CtrlPreconditions{


    public static Restaurant checkFound(Restaurant restaurant) {
        if(restaurant == null) {
            throw new ResourceNotFoundException();
        }
        return restaurant;
    }

}
