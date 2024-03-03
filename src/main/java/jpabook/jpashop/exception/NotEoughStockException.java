package jpabook.jpashop.exception;

public class NotEoughStockException extends RuntimeException {
    public NotEoughStockException() {
        super();
    }

    public NotEoughStockException(String message) {
        super(message);
    }

    public NotEoughStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEoughStockException(Throwable cause) {
        super(cause);
    }

    protected NotEoughStockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
