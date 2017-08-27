
package pl.com.worktime.domain.exceptions;

public class DomainOperationException extends RuntimeException {

    public DomainOperationException(String message) {
        super(message);
    }
}
