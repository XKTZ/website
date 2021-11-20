package xktz.website.web.blog.domain.transfer;

import xktz.website.domain.OperationResult;

/**
 * The operation result of a comment
 */
public class BlogCommentOperationResult implements OperationResult {

    private boolean success;

    private String message;

    public BlogCommentOperationResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    @Override
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
