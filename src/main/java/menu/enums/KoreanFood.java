package menu.enums;

public enum KoreanFood implements Food {
    GIMBAP("김밥"),
    KIMCHI_JJIGAE("김치찌개"),
    SSAMBAP("쌈밥"),
    DOENJANG_JJIGAE("된장찌개"),
    BIBIMBAP("비빔밥"),
    KALGUKSU("칼국수"),
    BULGOGI("불고기"),
    TTEOKBOKKI("떡볶이"),
    JEYUK_BOKKEUM ("제육 볶음"),;

    private final String toKorean;
    KoreanFood(String toKorean) {
        this.toKorean = toKorean;
    }

    public String getToKorean() {
        return toKorean;
    }

    @Override
    public String toKorean() {
        return this.toKorean;
    }

}
