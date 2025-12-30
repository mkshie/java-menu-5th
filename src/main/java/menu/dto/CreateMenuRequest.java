package menu.dto;

import java.util.List;
import menu.enums.Food;

public record CreateMenuRequest(
        String coachName, List<Food> bannedFoodName
) {
}
