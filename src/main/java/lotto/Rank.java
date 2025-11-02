package lotto;

public enum Rank {
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원)"),
    FIFTH(3, false, 5_000, "3개 일치 (5,000원)"),
    NONE(0, false, 0, "");

    private final int score;
    private final boolean bonus;
    private final int prize;
    private final String message;

    Rank(int score, boolean bonus, int prize, String message) {
        this.score = score;
        this.bonus = bonus;
        this.prize = prize;
        this.message = message;
    }

    public static Rank valueOf(int score, boolean bonus) {
        if (score == 6) {
            return FIRST;
        }
        if (score == 5 && bonus) {
            return SECOND;
        }
        if (score == 5) {
            return THIRD;
        }
        if (score == 4) {
            return FOURTH;
        }
        if (score == 3) {
            return FIFTH;
        }
        return NONE;
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }
}