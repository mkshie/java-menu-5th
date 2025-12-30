package menu.enums;

import java.util.List;

public enum FoodCategory {
    JAPAN("일식"), KOREAN("한식"), CHINESE("중식"), ASIAN("아시안"), WESTERN("양식");

    private final String toKorean;

    FoodCategory(String toKorean) {
        this.toKorean = toKorean;
    }

    public String getToKorean() {
        return toKorean;
    }

    public static List<Food> getFoods(FoodCategory foodCategory) {
        if (foodCategory == JAPAN) {
            return List.of(JapanFood.values());
        }
        if (foodCategory == KOREAN) {
            return List.of(KoreanFood.values());
        }
        if (foodCategory == CHINESE) {
            return List.of(ChineseFood.values());
        }
        if (foodCategory == ASIAN) {
            return List.of(AsianFood.values());
        }

        return List.of(WesternFood.values());
    }
}
