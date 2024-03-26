package lambda;

import java.util.Objects;
import java.util.function.Consumer;

public interface IConsumer<T> extends Consumer<T> {

    default IConsumer<T> andThen(Consumer<? super T> after) {
        Objects.requireNonNull(after);
        return (T t) -> {
            System.out.println("1=="+ t);
            accept(t);
            System.out.println("2=="+ t);
            after.accept(t);
            System.out.println("3=="+ t);
        };
    }
}