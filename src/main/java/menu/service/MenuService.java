package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.dto.CreateMenuRequest;
import menu.dto.ResultMenuResponse;
import menu.enums.Food;
import menu.enums.FoodCategory;
import menu.mapper.CoachMapper;

public class MenuService {

    private final CoachMapper coachMapper;
    private final List<FoodCategory> categoryNames = List.of(FoodCategory.values());
    private List<FoodCategory> categorySchedule = new ArrayList<>();

    public MenuService() {
        this.coachMapper = new CoachMapper();
    }

    public ResultMenuResponse createMenu(List<CreateMenuRequest> createMenuRequests) {

        List<Coach> coaches = createMenuRequests.stream().map(coachMapper::createCoach).toList();
        for (int i = 0; i < 5; i++) {
            pickCategory();
            //한 사람에게 메뉴 중복은 안됨
            int finalI = i;
            coaches.forEach(pickCoach -> {
                pickFood(pickCoach, categorySchedule.get(finalI));
            });

        }

        return new ResultMenuResponse(coaches, categorySchedule);
    }

    private void pickCategory() {
        //카테고리를 정하는 메소드
        //이미 해당 카테고리가 2번 존재한다면 다시 뽑기
        while (true) {
            FoodCategory foodCategory = categoryNames.get(Randoms.pickNumberInRange(1, 5) - 1);
            if (categorySchedule.stream().filter(c -> c == foodCategory).toList().size() > 1) {
                continue;
            }
            categorySchedule.add(foodCategory);
            break;
        }
    }

    private void pickFood(Coach coach, FoodCategory foodCategory) {
        List<String> foods = FoodCategory.getFoods(foodCategory).stream().map(Food::toKorean).toList();
        String menu;
        do {
            menu = Randoms.shuffle(foods).get(0);
        } while (coach.containsFood(menu) || coach.containsBannedFood(menu)); // 둘중하나라도 만족한다면 menu 다시 선정
        coach.addFood(menu);
    }
}
