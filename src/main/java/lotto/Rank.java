package lotto;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int score;
    private final boolean bonus;
    private final int prize;

    Rank(int score, boolean bonus, int prize) {
        this.score = score;
        this.bonus = bonus;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
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
}