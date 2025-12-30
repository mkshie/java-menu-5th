package menu.view;

import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.dto.ResultMenuResponse;
import menu.enums.FoodCategory;

public class OutputView {
    final String[] dayHeaders = {"월요일", "화요일", "수요일", "목요일", "금요일"};

    public void startPrint() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        System.out.println();
    }

    public void printResult(ResultMenuResponse result) {
        List<Coach> coaches = result.coaches();

        // 1) 헤더/카테고리 출력
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | " + String.join(" | ", dayHeaders) + " ]");
        System.out.println("[ 카테고리 | " + String.join(" | ",
                result.categorySchedule().stream().map(FoodCategory::getToKorean).toList()) + " ]");

        // 2) 코치별 스케줄 출력
        for (Coach coach : coaches) {
            List<String> schedule = coach.getFoodSchedule();

            // 스케줄 길이가 5가 아닐 때도 안전하게 출력(부족하면 빈칸, 넘치면 5개까지만)
            String[] cells = new String[5];
            for (int i = 0; i < 5; i++) {
                cells[i] = (schedule != null && i < schedule.size()) ? schedule.get(i) : "";
            }

            String coachName = coach.getName(); // <- 너 프로젝트에 맞게 여기만 수정

            System.out.println("[ " + coachName + " | " + String.join(" | ", cells) + " ]");
        }

        // 3) 마무리 출력
        System.out.println();
        System.out.println("추천을 완료했습니다.");
    }
}
