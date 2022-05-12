package co.gatojunior.co.restaurant.util;

import co.gatojunior.co.restaurant.exceptions.ResourceNotFoundException;
import co.gatojunior.co.restaurant.models.Restaurant;

public final class CtrlPreconditions{


    public static <T> T checkFound(T object) {
        if(object == null) {
            throw new ResourceNotFoundException();
        }
        return object;
    }

}
