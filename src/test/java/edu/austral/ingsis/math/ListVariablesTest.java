package edu.austral.ingsis.math;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import java.util.List;
import edu.austral.ingsis.math.functioncomposites.dual.factories.*;
import edu.austral.ingsis.math.functioncomposites.single.factories.Absolute;
import edu.austral.ingsis.math.functioncomposites.single.factories.Parenthesis;
import edu.austral.ingsis.math.functionleafs.Numeral;
import edu.austral.ingsis.math.functionleafs.Variable;
import edu.austral.ingsis.math.visitors.GetVariablesVisitor;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    Addition additionFactory = new Addition();
    Function case1 = additionFactory.createDoubleOperation(new Numeral(1), new Numeral(6));
    GetVariablesVisitor visitor = new GetVariablesVisitor();
    case1.accept(visitor);
    final List<String> result = visitor.getVariables();
    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    Division divisionFactory = new Division();
    Function case2 = divisionFactory.createDoubleOperation(new Numeral(12), new Variable("div"));
    GetVariablesVisitor visitor = new GetVariablesVisitor();
    case2.accept(visitor);
    final List<String> result = visitor.getVariables();
    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    Division divisionFactory = new Division();
    Multiplication multiplicationFactory = new Multiplication();
    Parenthesis parenthesisFactory = new Parenthesis();
    Function case3 =
        multiplicationFactory.createDoubleOperation(
            parenthesisFactory.createSingleOperation(
                divisionFactory.createDoubleOperation(new Numeral(9), new Variable("x"))),
            new Variable("y"));
    GetVariablesVisitor visitor = new GetVariablesVisitor();
    case3.accept(visitor);
    final List<String> result = visitor.getVariables();
    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    Division divisionFactory = new Division();
    Exponential exponentialFactory = new Exponential();
    Parenthesis parenthesisFactory = new Parenthesis();
    Function case4 =
        exponentialFactory.createDoubleOperation(
            parenthesisFactory.createSingleOperation(
                divisionFactory.createDoubleOperation(new Numeral(27), new Variable("a"))),
            new Variable("b"));
    GetVariablesVisitor visitor = new GetVariablesVisitor();
    case4.accept(visitor);
    final List<String> result = visitor.getVariables();
    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    Exponential exponentialFactory = new Exponential();
    Division divisionFactory = new Division();
    Function case5 =
        exponentialFactory.createDoubleOperation(
            new Variable("z"), divisionFactory.createDoubleOperation(new Numeral(1), new Numeral(2)));
    GetVariablesVisitor visitor = new GetVariablesVisitor();
    case5.accept(visitor);
    final List<String> result = visitor.getVariables();
    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    Absolute absoluteFactory = new Absolute();
    Subtraction subtractionFactory = new Subtraction();
    Function case6 =
        subtractionFactory.createDoubleOperation(
            absoluteFactory.createSingleOperation(new Variable("value")), new Numeral(8));
    GetVariablesVisitor visitor = new GetVariablesVisitor();
    case6.accept(visitor);
    final List<String> result = visitor.getVariables();
    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    Absolute absoluteFactory = new Absolute();
    Subtraction subtractionFactory = new Subtraction();
    Function case7 =
            subtractionFactory.createDoubleOperation(
                    absoluteFactory.createSingleOperation(new Variable("value")), new Numeral(8));
    GetVariablesVisitor visitor = new GetVariablesVisitor();
    case7.accept(visitor);
    final List<String> result = visitor.getVariables();
    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    Subtraction subtractionFactory = new Subtraction();
    Multiplication multiplicationFactory = new Multiplication();
    Parenthesis parenthesisFactory = new Parenthesis();
    Function case8 =
        multiplicationFactory.createDoubleOperation(
            parenthesisFactory.createSingleOperation(
                subtractionFactory.createDoubleOperation(new Numeral(5), new Variable("i"))),
            new Numeral(8));
    GetVariablesVisitor visitor = new GetVariablesVisitor();
    case8.accept(visitor);
    final List<String> result = visitor.getVariables();
    assertThat(result, containsInAnyOrder("i"));
  }
}
