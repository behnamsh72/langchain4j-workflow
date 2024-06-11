package dev.langchain4j.workflow;

public class Transition<T> {
    private final Node<T, ?> from;
    private final Object to; // Can be Node<T,?> or WorflowState

    public Transition(Node<T, ?> from, Object to) {
        this.from = from;
        this.to = to;
    }

    public Node<T, ?> getFrom() {
        return from;
    }

    public Object getTo() {
        return to;
    }

    public static <T> Transition<T> from(Node<T, ?> from, Object to) {
        return new Transition<>(from, to);
    }

    @Override
    public String toString() {
        if (to instanceof Node) {
            return from.getName() + " -> " + ((Node<T, ?>) to).getName();
        } else if (to instanceof WorkflowState) {
            return from.getName() + " -> " + ((WorkflowState) to).toString();
        }
        return "";
    }
}
