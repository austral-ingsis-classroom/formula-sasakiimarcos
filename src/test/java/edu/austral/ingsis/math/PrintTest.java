package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.functioncomposites.binary.factories.*;
import edu.austral.ingsis.math.functioncomposites.unary.factories.Absolute;
import edu.austral.ingsis.math.functioncomposites.unary.factories.Parenthesis;
import edu.austral.ingsis.math.functionleafs.Numeral;
import edu.austral.ingsis.math.functionleafs.Variable;
import edu.austral.ingsis.math.visitors.PrinterVisitor;
import org.junit.jupiter.api.Test;

public class PrintTest {

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    final String expected = "1 + 6";
    Addition additionFactory = new Addition();
    Function case1 = additionFactory.createDoubleOperation(new Numeral(1), new Numeral(6));
    PrinterVisitor visitor = new PrinterVisitor();
    case1.accept(visitor);
    final String result = visitor.getResult();
    assertThat(result, equalTo(expected));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    final String expected = "12 / 2";
    Division divisionFactory = new Division();
    Function case2 = divisionFactory.createDoubleOperation(new Numeral(12), new Numeral(2));
    PrinterVisitor visitor = new PrinterVisitor();
    case2.accept(visitor);
    final String result = visitor.getResult();
    assertThat(result, equalTo(expected));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    final String expected = "(9 / 2) * 3";
    Division divisionFactory = new Division();
    Multiplication multiplicationFactory = new Multiplication();
    Parenthesis parenthesisFactory = new Parenthesis();
    Function case3 =
        multiplicationFactory.createDoubleOperation(
            parenthesisFactory.createSingleOperation(
                divisionFactory.createDoubleOperation(new Numeral(9), new Numeral(2))),
            new Numeral(3));
    PrinterVisitor visitor = new PrinterVisitor();
    case3.accept(visitor);
    final String result = visitor.getResult();

    assertThat(result, equalTo(expected));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    final String expected = "(27 / 6) ^ 2";
    Division divisionFactory = new Division();
    Exponential exponentialFactory = new Exponential();
    Parenthesis parenthesisFactory = new Parenthesis();
    Function case4 =
        exponentialFactory.createDoubleOperation(
            parenthesisFactory.createSingleOperation(
                divisionFactory.createDoubleOperation(new Numeral(27), new Numeral(6))),
            new Numeral(2));
    PrinterVisitor visitor = new PrinterVisitor();
    case4.accept(visitor);
    final String result = visitor.getResult();
    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    final String expected = "|value| - 8";
    Absolute absoluteFactory = new Absolute();
    Subtraction subtractionFactory = new Subtraction();
    Function case5 =
        subtractionFactory.createDoubleOperation(
            absoluteFactory.createSingleOperation(new Variable("value")), new Numeral(8));
    PrinterVisitor visitor = new PrinterVisitor();
    case5.accept(visitor);
    final String result = visitor.getResult();
    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction7() {
    final String expected = "|value| - 8";
    Absolute absoluteFactory = new Absolute();
    Subtraction subtractionFactory = new Subtraction();
    Function case6 =
        subtractionFactory.createDoubleOperation(
            absoluteFactory.createSingleOperation(new Variable("value")), new Numeral(8));
    PrinterVisitor visitor = new PrinterVisitor();
    case6.accept(visitor);
    final String result = visitor.getResult();
    assertThat(result, equalTo(expected));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction8() {
    final String expected = "(5 - i) * 8";
    Subtraction subtractionFactory = new Subtraction();
    Multiplication multiplicationFactory = new Multiplication();
    Parenthesis parenthesisFactory = new Parenthesis();
    Function case7 =
        multiplicationFactory.createDoubleOperation(
            parenthesisFactory.createSingleOperation(
                subtractionFactory.createDoubleOperation(new Numeral(5), new Variable("i"))),
            new Numeral(8));
    PrinterVisitor visitor = new PrinterVisitor();
    case7.accept(visitor);
    final String result = visitor.getResult();
    assertThat(result, equalTo(expected));
  }
}
