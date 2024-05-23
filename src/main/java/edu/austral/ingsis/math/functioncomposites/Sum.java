package edu.austral.ingsis.math.functioncomposites;

import edu.austral.ingsis.math.functioncomposites.Operation;
import edu.austral.ingsis.math.visitors.Visitor;

public class Sum implements Operation {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    @Override
    public String getSymbol() {
        return null;
    }
}
