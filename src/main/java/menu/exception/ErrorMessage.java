package menu.exception;

public enum ErrorMessage {

    INVALID_COACH_SIZE("코치는 최소 2명 이상 입력해야합니다."),
    INVALID_COACH_SIZE2("코치는 최대 5명 이하로 입력해야합니다."),
    INVALID_COACH_NAME_VALUE("코치의 이름에 빈값이 존재합니다."),
    INVALID_FOOD_SIZE("못먹는 메뉴는 최대 2개입니다."),
    INVALID_FOOD_NAME_VALUE("메뉴의 이름에 빈값이 존재합니다."),
    INVALID_FOOD_NAME("올바르지 않은 메뉴 이름입니다.");


    private final String message;
    private final static String PREFIX = "[ERROR] ";

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return PREFIX + message;
    }
}
