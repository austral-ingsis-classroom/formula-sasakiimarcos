package edu.austral.ingsis.math;

import edu.austral.ingsis.math.functioncomposites.dual.factories.*;
import edu.austral.ingsis.math.functioncomposites.single.factories.Absolute;
import edu.austral.ingsis.math.functioncomposites.single.factories.Parenthesis;
import edu.austral.ingsis.math.functionleafs.Numeral;
import edu.austral.ingsis.math.functionleafs.Variable;
import edu.austral.ingsis.math.visitors.SetVariablesVisitor;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    HashMap<String, Double> variables = new HashMap<>(Map.of("x", 3d));
    Addition additionFactory = new Addition();
    Function case1 = additionFactory.createDoubleOperation(new Numeral(1), new Variable("x"));
    SetVariablesVisitor visitor = new SetVariablesVisitor(variables);
    case1.accept(visitor);
    final Double result = case1.solve();
    assertThat(result, equalTo(4d));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    HashMap<String, Double> variables = new HashMap<>(Map.of("div", 4d));
    Division divisionFactory = new Division();
    Function case2 = divisionFactory.createDoubleOperation(new Numeral(12), new Variable("div"));
    SetVariablesVisitor visitor = new SetVariablesVisitor(variables);
    case2.accept(visitor);
    final Double result = case2.solve();
    assertThat(result, equalTo(3d));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    HashMap<String, Double> variables = new HashMap<>(Map.of("x", 3d, "y", 4d));
    Division divisionFactory = new Division();
    Multiplication multiplicationFactory = new Multiplication();
    Parenthesis parenthesisFactory = new Parenthesis();
    Function case3 =
        multiplicationFactory.createDoubleOperation(
            parenthesisFactory.createSingleOperation(
                divisionFactory.createDoubleOperation(new Numeral(9), new Variable("x"))),
            new Variable("y"));
    SetVariablesVisitor visitor = new SetVariablesVisitor(variables);
    case3.accept(visitor);
    final Double result = case3.solve();
    assertThat(result, equalTo(12d));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    HashMap<String, Double> variables = new HashMap<>(Map.of("a", 9d, "b", 3d));
    Division divisionFactory = new Division();
    Exponential exponentialFactory = new Exponential();
    Parenthesis parenthesisFactory = new Parenthesis();
    Function case4 =
        exponentialFactory.createDoubleOperation(
            parenthesisFactory.createSingleOperation(
                divisionFactory.createDoubleOperation(new Numeral(27), new Variable("a"))),
            new Variable("b"));
    SetVariablesVisitor visitor = new SetVariablesVisitor(variables);
    case4.accept(visitor);
    final Double result = case4.solve();
    assertThat(result, equalTo(27d));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    HashMap<String, Double> variables = new HashMap<>(Map.of("z", 36d));
    Exponential exponentialFactory = new Exponential();
    Division divisionFactory = new Division();
    Parenthesis parenthesisFactory = new Parenthesis();
    Function case5 =
        exponentialFactory.createDoubleOperation(
            new Variable("z"), parenthesisFactory.createSingleOperation(divisionFactory.createDoubleOperation(new Numeral(1), new Numeral(2))));
    SetVariablesVisitor visitor = new SetVariablesVisitor(variables);
    case5.accept(visitor);
    final Double result = case5.solve();
    assertThat(result, equalTo(6d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    HashMap<String, Double> variables = new HashMap<>(Map.of("value", 8d));
    Subtraction subtractionFactory = new Subtraction();
    Absolute absoluteFactory = new Absolute();
    Function case6 =
        subtractionFactory.createDoubleOperation(
            absoluteFactory.createSingleOperation(new Variable("value")), new Numeral(8));
    SetVariablesVisitor visitor = new SetVariablesVisitor(variables);
    case6.accept(visitor);
    final Double result = case6.solve();
    assertThat(result, equalTo(0d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    HashMap<String, Double> variables = new HashMap<>(Map.of("value", 8d));
    Subtraction subtractionFactory = new Subtraction();
    Absolute absoluteFactory = new Absolute();
    Function case7 =
        subtractionFactory.createDoubleOperation(
            absoluteFactory.createSingleOperation(new Variable("value")), new Numeral(8));
    SetVariablesVisitor visitor = new SetVariablesVisitor(variables);
    case7.accept(visitor);
    final Double result = case7.solve();
    assertThat(result, equalTo(0d));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    HashMap<String, Double> variables = new HashMap<>(Map.of("i", 2d));
    Parenthesis parenthesisFactory = new Parenthesis();
    Subtraction subtractionFactory = new Subtraction();
    Multiplication multiplicationFactory = new Multiplication();
    Function case8 =
        multiplicationFactory.createDoubleOperation(
            parenthesisFactory.createSingleOperation(
                subtractionFactory.createDoubleOperation(new Numeral(5), new Variable("i"))),
            new Numeral(8));
    SetVariablesVisitor visitor = new SetVariablesVisitor(variables);
    case8.accept(visitor);
    final Double result = case8.solve();
    assertThat(result, equalTo(24d));
  }
}
