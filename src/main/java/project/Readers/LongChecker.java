package project.Readers;
/**
 * Functional Interface for checking parameters
 */
@FunctionalInterface
public interface LongChecker {
    boolean checkLong(long x, long y, boolean z);
}
