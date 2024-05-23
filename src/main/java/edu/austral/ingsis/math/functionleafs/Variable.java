package edu.austral.ingsis.math.functionleafs;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.visitors.Visitor;

public class Variable implements Function {
    private final String name;
    private Double value;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getSymbol() {
        if (value == null) {
            return name;
        }
        return value.toString();
    }
}
