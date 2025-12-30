package menu.view;

import java.util.List;
import java.util.Scanner;
import menu.enums.Food;
import menu.exception.Validator;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> inputCoachName(){
        while(true){
            try {
                System.out.println("코치의 이름을 입력해 주세요");
                String names = scanner.nextLine();

                return Validator.parserNames(names);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Food> inputBannedFoodName(String name){
        while(true){
            try {
                System.out.println(name + "(이)가 못 먹는 메뉴를 입력해주세요.");
                String foodNames = scanner.nextLine();

                return Validator.parserFoodNames(foodNames);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
