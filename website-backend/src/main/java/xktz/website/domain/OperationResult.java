package xktz.website.domain;

/**
 * A result of operations
 */
public interface OperationResult {

    /**
     * If the operation is success or not
     *
     * @return if it is success or not
     */
    boolean isSuccess();

    /**
     * The message of operation
     *
     * @return the message
     */
    String getMessage();

    /**
     * Get a result instance
     * @param success success or not
     * @param message message
     * @return result
     */
    public static OperationResult getInstance(boolean success, String message) {
        return new OperationResult() {
            @Override
            public boolean isSuccess() {
                return success;
            }

            @Override
            public String getMessage() {
                return message;
            }
        };
    }
}
