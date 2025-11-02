package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoGeneratorTest {

    @DisplayName("지정된 개수만큼 로또를 생성한다.")
    @Test
    void 지정된_개수만큼_로또를_생성한다() {
        LottoGenerator generator = new LottoGenerator();
        int count = 5;

        List<Lotto> lottos = generator.generate(count);

        assertThat(lottos).hasSize(count);
    }
}