package menu.enums;

public enum JapanFood implements Food {
    GUYDONG("규동"),
    WOODONG("우동"),
    MISOSIRU("미소 시루"),
    SUSHI("스시"),
    KATSUDON("가츠동"),
    ONIGIRI("오니기리"),
    HAYASHI_RICE("하이라이스"),
    RAMEN("라멘"),
    OKONOMIYAKI("오코노미야끼"),;

    private final String toKorean;
    JapanFood(String toKorean) {
        this.toKorean = toKorean;
    }

    @Override
    public String toKorean() {
        return this.toKorean;
    }

}
