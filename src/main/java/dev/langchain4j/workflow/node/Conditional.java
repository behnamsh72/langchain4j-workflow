package dev.langchain4j.workflow.node;

import java.util.Objects;
import java.util.function.Function;

public class Conditional<T> {

    private final Function<T, Node<T,?>> condition;

    public Conditional(Function<T, Node<T,?>> condition) {
        this.condition = condition;
    }

    public Node<T,?> evaluate(T input) {
        return condition.apply(input);
    }

    public static <T> Conditional<T> eval(Function<T, Node<T,?>> condition) {
        return new Conditional<>(condition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conditional<?> that = (Conditional<?>) o;

        return Objects.equals(condition, that.condition);
    }

    @Override
    public int hashCode() {
        return condition != null ? condition.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Conditional{" +
                "condition=" + condition +
                '}';
    }
}
