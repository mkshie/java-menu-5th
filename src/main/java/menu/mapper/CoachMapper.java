package menu.mapper;

import menu.domain.Coach;
import menu.dto.CreateMenuRequest;

public class CoachMapper {

    public Coach createCoach(CreateMenuRequest createMenuRequest) {
        Coach coach = new Coach(createMenuRequest.coachName());

        createMenuRequest.bannedFoodName().forEach(food -> coach.addBannedFood(food.toKorean()));

        return coach;
    }
}
