package menu.enums;

public enum AsianFood implements Food {
    PAD_THAI("팟타이"),
    KHAO_PHAT("카오 팟"),
    NASI_GORENG("나시고렝"),
    PINEAPPLE_FRIED_RICE("파인애플 볶음밥"),
    PHO("쌀국수"),
    TOM_YUM_GOONG("똠양꿍"),
    BANH_MI("반미"),
    FRESH_SPRING_ROLLS("월남쌈"),
    BUN_CHA("분짜"),;

    private final String toKorean;
    AsianFood(String toKorean) {
        this.toKorean = toKorean;
    }

    @Override
    public String toKorean() {
        return this.toKorean;
    }
}
