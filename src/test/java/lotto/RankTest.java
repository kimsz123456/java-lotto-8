package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RankTest {

    @DisplayName("1등 상금을 정확히 반환한다.")
    @Test
    void 일등_상금을_반환한다() {
        assertThat(Rank.FIRST.getPrize()).isEqualTo(2_000_000_000);
    }

    @DisplayName("2등 상금을 정확히 반환한다.")
    @Test
    void 이등_상금을_반환한다() {
        assertThat(Rank.SECOND.getPrize()).isEqualTo(30_000_000);
    }

    @DisplayName("3등 상금을 정확히 반환한다.")
    @Test
    void 삼등_상금을_반환한다() {
        assertThat(Rank.THIRD.getPrize()).isEqualTo(1_500_000);
    }

    @DisplayName("4등 상금을 정확히 반환한다.")
    @Test
    void 사등_상금을_반환한다() {
        assertThat(Rank.FOURTH.getPrize()).isEqualTo(50_000);
    }

    @DisplayName("5등 상금을 정확히 반환한다.")
    @Test
    void 오등_상금을_반환한다() {
        assertThat(Rank.FIFTH.getPrize()).isEqualTo(5_000);
    }

    @DisplayName("6개 일치 시 1등을 반환한다.")
    @Test
    void 여섯개_일치_시_일등() {
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
    }

    @DisplayName("5개 일치와 보너스 일치 시 2등을 반환한다.")
    @Test
    void 다섯개_일치_보너스_일치_시_이등() {
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
    }

    @DisplayName("5개 일치 시 3등을 반환한다.")
    @Test
    void 다섯개_일치_시_삼등() {
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
    }

    @DisplayName("4개 일치 시 4등을 반환한다.")
    @Test
    void 네개_일치_시_사등() {
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("3개 일치 시 5등을 반환한다.")
    @Test
    void 세개_일치_시_오등() {
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("2개 이하 일치 시 NONE을 반환한다.")
    @Test
    void 두개_이하_일치_시_낙첨() {
        assertThat(Rank.valueOf(2, false)).isEqualTo(Rank.NONE);
        assertThat(Rank.valueOf(1, false)).isEqualTo(Rank.NONE);
        assertThat(Rank.valueOf(0, false)).isEqualTo(Rank.NONE);
    }
}