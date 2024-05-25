package edu.austral.ingsis.math.visitors;

import edu.austral.ingsis.math.functioncomposites.binary.BinaryOperation;
import edu.austral.ingsis.math.functioncomposites.unary.SingleOperation;
import edu.austral.ingsis.math.functionleafs.Numeral;
import edu.austral.ingsis.math.functionleafs.Variable;
import java.util.ArrayList;
import java.util.List;

public class GetVariablesVisitor implements Visitor {

  private List<String> variables;

  public GetVariablesVisitor() {
    this.variables = new ArrayList<>();
  }

  @Override
  public void visit(Numeral numeral) {
    return;
  }

  @Override
  public void visit(Variable variable) {
    variables.add(variable.getSymbol());
  }

  @Override
  public void visit(BinaryOperation binaryOperation) {
    binaryOperation.getLeftOperand().accept(this);
    binaryOperation.getRightOperand().accept(this);
  }

  @Override
  public void visit(SingleOperation singleOperation) {
    singleOperation.getOperand().accept(this);
  }

  public List<String> getVariables() {
    return variables;
  }
}
