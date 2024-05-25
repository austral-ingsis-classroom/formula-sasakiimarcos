package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitors.Visitor;

public interface Visitable {
  void accept(Visitor visitor);
}
