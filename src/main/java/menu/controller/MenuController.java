package menu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import menu.dto.CreateMenuRequest;
import menu.dto.ResultMenuResponse;
import menu.enums.Food;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final Scanner scanner = new Scanner(System.in);

    private final MenuService menuService = new MenuService();
    private final InputView inputView = new InputView(scanner);
    private final OutputView outputView = new OutputView();


    public void run() {
        outputView.startPrint();
        List<String> coachNames = inputView.inputCoachName();
        List<CreateMenuRequest> createMenuRequests = new ArrayList<>();

        coachNames.forEach(coachName -> {
            List<Food> bannedFood = inputView.inputBannedFoodName(coachName);
            createMenuRequests.add(new CreateMenuRequest(coachName, bannedFood));
        });

        ResultMenuResponse result = menuService.createMenu(createMenuRequests);

        outputView.printResult(result);
    }

}
