package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @DisplayName("등수별 당첨 개수를 정확히 계산한다.")
    @Test
    void 등수별_당첨_개수_계산() {
        WinningLotto winningLotto = new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 8, 9)),
                new Lotto(List.of(1, 2, 3, 8, 9, 10))
        );

        LottoResult result = new LottoResult(lottos, winningLotto);
        Map<Rank, Integer> statistics = result.getStatistics();

        assertThat(statistics.get(Rank.FIRST)).isEqualTo(1);
        assertThat(statistics.get(Rank.SECOND)).isEqualTo(1);
        assertThat(statistics.get(Rank.THIRD)).isEqualTo(1);
        assertThat(statistics.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(statistics.get(Rank.FIFTH)).isEqualTo(1);
    }


    @DisplayName("수익률을 정확히 계산한다.")
    @Test
    void 수익률_계산() {
        WinningLotto winningLotto = new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(8, 9, 10, 11, 12, 13))
        );

        LottoResult result = new LottoResult(lottos, winningLotto);

        assertThat(result.getProfitRate()).isEqualTo(75000.0);
    }
}