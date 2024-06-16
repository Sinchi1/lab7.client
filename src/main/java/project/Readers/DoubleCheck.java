package project.Readers;
/**
 * Functional Interface for checking parameters
 */
@FunctionalInterface
public interface DoubleCheck {
    boolean checkDouble(double x, double y, boolean z);
}
