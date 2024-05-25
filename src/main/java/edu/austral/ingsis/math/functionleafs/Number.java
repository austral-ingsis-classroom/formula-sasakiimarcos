package edu.austral.ingsis.math.functionleafs;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.visitors.Visitor;

public class Number implements Value {
    private final double value;

    public Number(double value) {
        this.value = value;
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getSymbol() {
        return value + "";
    }

    @Override
    public double solve() {
        return value;
    }
}
