package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import lotto.util.NumbersGenerator;
import lotto.util.TestFixNumbersGenerator;
import lotto.util.TestRandomNumbersGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LotteryResultTest {

  private NumbersGenerator numbersGenerator;

  @BeforeEach
  void setup() {
    numbersGenerator = new TestFixNumbersGenerator();
  }

  @Test
  void test() {
    int money = 4000;
    PurchaseMoney purchasedMoney = new PurchaseMoney(money);
    PersonLotto personLotto = new PersonLotto(numbersGenerator, purchasedMoney);
    Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    WinningLotto winningLotto = new WinningLotto(lotto);
    LotteryMachine lotteryMachine = new LotteryMachine(personLotto, winningLotto);

    int bonusNumber = 22;
    Bonus bonus = new Bonus(new Number(bonusNumber), winningLotto);

    Map<WinningMoney, Integer> store = lotteryMachine.drawingLotto(bonus);

    LotteryResult lotteryResult = new LotteryResult(store);
    //String profitPercentage = lotteryResult.getProfitPercentage(purchasedMoney);
    //System.out.println(profitPercentage);
  }
}