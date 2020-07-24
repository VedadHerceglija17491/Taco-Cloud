package sia.tacocloud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sia.tacocloud.model.Ingredient;
import sia.tacocloud.repository.IngredientRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientByIdConverter(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient convert(String id) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredients::add);
        for (Ingredient i : ingredients)
            if(i.getId().equals(id))
                return i;
        return null;

    }
}

