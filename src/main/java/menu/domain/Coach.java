package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private List<String> foodSchedule = new ArrayList<>();
    private List<String> bannedFood = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getFoodSchedule() {
        return foodSchedule;
    }

    //금지된 음식에 이미 포함됐는지 확인하는 메소드
    public boolean containsBannedFood(String bannedFoodName) {
        if(bannedFood == null) return true;
        return bannedFood.contains(bannedFoodName);
    }
    //금지 음식 추가 메소드
    public void addBannedFood(String bannedFoodName) {
        bannedFood.add(bannedFoodName);
    }

    // 스케줄 추가 메소드
    public void addFood(String food) {
        this.foodSchedule.add(food);
    }

    //스케줄에 해당 음식이 포함됐는지 확인하는 메소드
    public boolean containsFood(String food) {
        if(foodSchedule == null) return false;
        return foodSchedule.contains(food); // 이미 포함되어있다면 true
    }

}
