package lotto;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {

    public void printLottos(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printResult(LottoResult result) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        Map<Rank, Integer> statistics = result.getStatistics();

        printRank(Rank.FIFTH, statistics.get(Rank.FIFTH));
        printRank(Rank.FOURTH, statistics.get(Rank.FOURTH));
        printRank(Rank.THIRD, statistics.get(Rank.THIRD));
        printRank(Rank.SECOND, statistics.get(Rank.SECOND));
        printRank(Rank.FIRST, statistics.get(Rank.FIRST));

        printProfitRate(result.getProfitRate());
    }

    private void printRank(Rank rank, int count) {
        if (rank == Rank.NONE) {
            return;
        }
        System.out.println(rank.getMessage() + " - " + count + "개");
    }

    private void printProfitRate(double profitRate) {
        DecimalFormat df = new DecimalFormat("#,##0.0");
        System.out.println("총 수익률은 " + df.format(profitRate) + "%입니다.");
    }
}