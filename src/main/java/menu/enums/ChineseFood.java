package menu.enums;

public enum ChineseFood implements Food {
    KKANPUNGGI("깐풍기"),
    CHOW_MEIN("볶음면"),
    DONGPAUK("동파육"),
    JJAJANGMYEON("짜장면"),
    JJAMPPONG("짬뽕"),
    MAPO_TOFU("마파두부"),
    TANGSUYUK("탕수육"),
    STIR_FRIED_TOMATO_EGGS("토마토 달걀볶음"),
    GOCHU_JAPCHEA("고추잡채"),;

    private final String toKorean;
    ChineseFood(String toKorean) {
        this.toKorean = toKorean;
    }

    @Override
    public String toKorean() {
        return this.toKorean;
    }
}
