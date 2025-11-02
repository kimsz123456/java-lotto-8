package lotto;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGenerator generator;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.generator = new LottoGenerator();
    }

    public void run() {
        // 로또 구입
        LottoStore store = purchaseLottos();
        outputView.printLottos(store.getLottos());

        // 당첨 로또 생성
        WinningLotto winningLotto = createWinningLotto();

        // 당첨 통계 생성
        LottoResult result = new LottoResult(store.getLottos(), winningLotto);
        outputView.printResult(result);
    }


    // 로또를 구매합니다. 구매금액이 1000원 미만이거나 1000원 단위가 아닐 시 예외 발생
    private LottoStore purchaseLottos() {
        while (true) {
            try {
                int amount = inputView.readAmount();
                return new LottoStore(amount, generator);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /* WinningLotto 객체를 생성합니다.
    당첨 번호를 입력받아 Lotto 객체를 생성합니다.
    보너스 번호를 추가로 입력받아 WinningLotto를 생성합니다.
    잘못된 입력 시 에러 메시지를 출력하고 재입력을 받습니다.
    */
    private WinningLotto createWinningLotto() {
        Lotto lotto = createLotto();
        while (true) {
            try {
                int bonusNumber = inputView.readBonusNumber();
                return new WinningLotto(lotto, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /*
    당첨 번호를 입력받아 Lotto 객체를 생성합니다.
    잘못된 입력 시 에러 메시지를 출력하고 재입력을 받습니다.
     */
    private Lotto createLotto() {
        while (true) {
            try {
                List<Integer> numbers = inputView.readWinningNumbers();
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}