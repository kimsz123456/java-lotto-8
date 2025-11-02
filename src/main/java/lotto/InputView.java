package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";

    public int readAmount() {
        System.out.println(PURCHASE_AMOUNT_PROMPT);
        while (true) {
            try {
                String input = Console.readLine();
                validateNumber(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> readWinningNumbers() {
        System.out.println("\n" + WINNING_NUMBERS_PROMPT);
        while (true) {
            try {
                String input = Console.readLine();
                validateWinningNumbersFormat(input);
                return Arrays.stream(input.split(","))
                        .map(String::trim)
                        .peek(this::validateNumber)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int readBonusNumber() {
        System.out.println("\n" + BONUS_NUMBER_PROMPT);
        while (true) {
            try {
                String input = Console.readLine();
                validateNumber(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateWinningNumbersFormat(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 입력해주세요.");
        }
        if (!input.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 쉼표(,)로 구분하여 입력해주세요.");
        }
    }

    private void validateNumber(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 비어있습니다.");
        }
        if (!input.matches("-?\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }
}