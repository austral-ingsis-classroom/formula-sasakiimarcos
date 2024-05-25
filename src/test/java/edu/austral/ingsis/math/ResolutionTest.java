package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.functioncomposites.binary.factories.*;
import edu.austral.ingsis.math.functioncomposites.unary.factories.Absolute;
import edu.austral.ingsis.math.functioncomposites.unary.factories.Parenthesis;
import edu.austral.ingsis.math.functionleafs.Numeral;
import org.junit.jupiter.api.Test;

public class ResolutionTest {

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    Addition additionFactory = new Addition();
    Function function = additionFactory.createDoubleOperation(new Numeral(1), new Numeral(6));
    final Double result = function.solve();
    assertThat(result, equalTo(7d));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    Division division = new Division();
    Function function = division.createDoubleOperation(new Numeral(12), new Numeral(2));
    final Double result = function.solve();
    assertThat(result, equalTo(6d));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    Division division = new Division();
    Multiplication multiplication = new Multiplication();
    Parenthesis parenthesis = new Parenthesis();
    Function function =
        multiplication.createDoubleOperation(
            parenthesis.createSingleOperation(
                division.createDoubleOperation(new Numeral(9), new Numeral(2))),
            new Numeral(3));
    final Double result = function.solve();
    assertThat(result, equalTo(13.5d));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    Division division = new Division();
    Exponential exponential = new Exponential();
    Parenthesis parenthesis = new Parenthesis();
    Function function =
        exponential.createDoubleOperation(
            parenthesis.createSingleOperation(
                division.createDoubleOperation(new Numeral(27), new Numeral(6))),
            new Numeral(2));
    final Double result = function.solve();
    assertThat(result, equalTo(20.25d));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    Exponential exponential = new Exponential();
    Division division = new Division();
    Parenthesis parenthesis = new Parenthesis();
    Function function =
        exponential.createDoubleOperation(
            new Numeral(36),
            parenthesis.createSingleOperation(
                division.createDoubleOperation(new Numeral(1), new Numeral(2))));
    final Double result = function.solve();
    assertThat(result, equalTo(6d));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    Absolute absolute = new Absolute();
    Function function = absolute.createSingleOperation(new Numeral(136));
    final Double result = function.solve();
    assertThat(result, equalTo(136d));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    Absolute absolute = new Absolute();
    Function function = absolute.createSingleOperation(new Numeral(-136));
    final Double result = function.solve();
    assertThat(result, equalTo(136d));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    final Double result = 0d;
    Parenthesis parenthesis = new Parenthesis();
    Subtraction subtraction = new Subtraction();
    Multiplication multiplication = new Multiplication();
    Function function =
        multiplication.createDoubleOperation(
            parenthesis.createSingleOperation(
                subtraction.createDoubleOperation(new Numeral(5), new Numeral(5))),
            new Numeral(8));
    assertThat(result, equalTo(0d));
  }
}
