package menu.dto;

import java.util.List;
import menu.domain.Coach;
import menu.enums.FoodCategory;

public record ResultMenuResponse(List<Coach> coaches , List<FoodCategory> categorySchedule) {
}
