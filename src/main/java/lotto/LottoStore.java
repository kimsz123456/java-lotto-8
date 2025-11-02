package lotto;

import java.util.Collections;
import java.util.List;

public class LottoStore {
    private final int amount;
    private final List<Lotto> lottos;

    public LottoStore(int amount, LottoGenerator generator) {
        validateAmount(amount);
        this.amount = amount;
        this.lottos = generator.generate(amount / 1000);
    }

    private void validateAmount(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.");
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}