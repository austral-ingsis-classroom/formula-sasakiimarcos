package edu.austral.ingsis.math.visitors;

import edu.austral.ingsis.math.functioncomposites.single.SingleOperation;
import edu.austral.ingsis.math.functionleafs.Numeral;
import edu.austral.ingsis.math.functioncomposites.dual.DoubleOperation;
import edu.austral.ingsis.math.functionleafs.Variable;

public interface Visitor {
    void visit(Numeral numeral);
    void visit(Variable variable);
    void visit(DoubleOperation doubleOperation);
    void visit(SingleOperation singleOperation);
}
