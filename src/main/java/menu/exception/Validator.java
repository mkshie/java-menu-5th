package menu.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.enums.AsianFood;
import menu.enums.ChineseFood;
import menu.enums.Food;
import menu.enums.JapanFood;
import menu.enums.KoreanFood;
import menu.enums.WesternFood;

public class Validator {

    private static final List<List<Food>> foods = List.of(
            List.of(AsianFood.values()),
            List.of(ChineseFood.values()),
            List.of(JapanFood.values()),
            List.of(KoreanFood.values()),
            List.of(WesternFood.values())
    );


    public static List<String> parserNames(String names) {
        //최소 두명이상 최대 다섯명
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COACH_SIZE.getMessage());
        }
        names = names.trim();
        List<String> coachNames = Arrays.asList(names.split(","));
        if (coachNames.size() > 5) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COACH_SIZE.getMessage());
        }

        if (coachNames.stream().anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COACH_NAME_VALUE.getMessage());
        }

        return coachNames;
    }

    public static List<Food> parserFoodNames(String inputNames) {
        if (inputNames == null) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FOOD_SIZE.getMessage());
        }

        if (inputNames.isBlank()) {
            return List.of();
        }

        inputNames = inputNames.trim();
        List<String> foodNames = Arrays.asList(inputNames.split(","));

        if (foodNames.size() > 2) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FOOD_SIZE.getMessage());
        }
        if (foodNames.stream().anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FOOD_NAME_VALUE.getMessage());
        }



        return parserFoods(foodNames);
    }

    private static List<Food> parserFoods(List<String> foodNames) {

        List<Food> foodEnums = new ArrayList<>();

        for (String foodName : foodNames) {
            Food matchedFood = foods.stream().flatMap(List::stream)
                    .filter(f -> f.toKorean().equals(foodName))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_FOOD_NAME.getMessage()));
            foodEnums.add(matchedFood);
        }

        return foodEnums;
    }
}
