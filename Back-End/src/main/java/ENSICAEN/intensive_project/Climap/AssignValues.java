package ENSICAEN.intensive_project.Climap;

import org.springframework.lang.NonNull;

import java.util.function.Consumer;

public class AssignValues {
    public static void assignIfNotNull(@NonNull Object source, @NonNull Consumer<Object> assignment) {
        assignment.accept(source);
    }
}
