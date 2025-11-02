package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> statistics;
    private final double profitRate;

    public LottoResult(List<Lotto> lottos, WinningLotto winningLotto) {
        this.statistics = calculateStatistics(lottos, winningLotto);
        this.profitRate = calculateProfitRate(lottos.size() * 1000);
    }

    public Map<Rank, Integer> getStatistics() {
        return statistics;
    }

    private Map<Rank, Integer> calculateStatistics(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<Rank, Integer> statistics = new EnumMap<>(Rank.class);

        for (Rank rank : Rank.values()) {
            statistics.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.match(lotto);
            statistics.put(rank, statistics.get(rank) + 1);
        }

        return statistics;
    }

    public double getProfitRate() {
        return profitRate;
    }

    private long calculateTotalPrize() {
        return statistics.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public double calculateProfitRate(int amount) {
        double rate = (double) calculateTotalPrize() / amount * 100;
        return Math.round(rate * 10) / 10.0;
    }
}