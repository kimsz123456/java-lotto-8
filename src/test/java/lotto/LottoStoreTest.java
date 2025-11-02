package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoStoreTest {

    @DisplayName("구입 금액이 1000 미만이면 예외가 발생한다.")
    @Test
    void 구입_금액_1000_미만_예외() {
        LottoGenerator generator = new LottoGenerator();

        assertThatThrownBy(() -> new LottoStore(0, generator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1,000원 이상");
    }

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액_단위_예외() {
        LottoGenerator generator = new LottoGenerator();

        assertThatThrownBy(() -> new LottoStore(1500, generator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1,000원 단위");
    }

    @DisplayName("구입 금액만큼 로또를 생성한다.")
    @Test
    void 구입_금액만큼_로또_생성() {
        LottoGenerator generator = new LottoGenerator();
        LottoStore store = new LottoStore(5000, generator);

        List<Lotto> lottos = store.getLottos();

        assertThat(lottos).hasSize(5);
    }
}