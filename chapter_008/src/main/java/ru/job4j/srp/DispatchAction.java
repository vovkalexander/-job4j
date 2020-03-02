package ru.job4j.srp;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
/**
 * DispatchAction.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class DispatchAction {
    /**
     * Contains object of Map.
     */
    private final Map<Integer, Function<Integer, Action>> dispatch = new HashMap<>();
    /**
     * Handle to Action.
     * @return type of Action.
     */
    public Function<Integer, Action> toAddition() {
        return choose ->  new Addition();

    }
    /**
     * Handle to Action.
     * @return type of Action.
     */
    public Function<Integer, Action> toSubtracting() {
        return choose -> new Subtracting();
    }

    /**
     * Handle to Action.
     * @return type of Action.
     */
    public Function<Integer, Action> toMultiplication() {
        return choose -> new Multiplication();
    }
    /**
     * Handle to Action.
     * @return type of Action.
     */
    public Function<Integer, Action> toDividing() {
        return choose -> new Dividing();
    }
    /**
     * Handle to Action.
     * @return null.
     */
    public Function<Integer, Action> toFinish() {
        return choose -> null;
    }
    /**
     * Handle to Action.
     * @return type of Action.
     */
    public Function<Integer, Action> toTripAdd() {
        return choose -> new TripleAdditional();
    }
    /**
     * Handle to Action.
     * @return type of Action.
     */
    public Function<Integer, Action> toTripSub() {
        return choose -> new TripleSubtracting();
    }
    /**
     * Handle to Action.
     * @return type of Action.
     */
    public Function<Integer, Action> toTripMul() {
        return choose -> new TripleMultiply();
    }
    /**
     * Handle to Action.
     * @return type of Action.
     */
    public Function<Integer, Action> toSin() {
        return choose -> new Sin();
    }
    /**
     * Handle to Action.
     * @return type of Action.
     */
    public Function<Integer, Action> toCos() {
        return choose -> new Cos();
    }
    /**
     * Handle to Action.
     * @return type of Action.
     */
    public Function<Integer, Action> toTan() {
        return choose -> new Tan();
    }
    /**
     * Handle to Action.
     * @return type of Action.
     */
    public Function<Integer, Action> toCtg() {
        return choose -> new Ctg();
    }
    /**
     * Fills in Map.
     * @param key of Map.
     * @param handle - value of Map.
     */
    public void load(Integer key, Function<Integer, Action> handle) {
        this.dispatch.put(key, handle);
    }
    /**
     * Sent message to dispatch.
     * @param choose - user's input.
     * @return Action's object if it finds in a dispatch.
     */
    public Action sent(Integer choose) {
        return this.dispatch.get(choose).apply(choose);
    }
    /**
     * Sent message to dispatch.
     * @return value of field of Class.
     */
    public Map<Integer, Function<Integer, Action>> getDispatch() {
        return dispatch;
    }
}

