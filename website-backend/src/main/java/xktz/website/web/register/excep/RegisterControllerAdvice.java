package xktz.website.web.register.excep;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import xktz.website.domain.OperationResult;
import xktz.website.global.activation.model.ActivationCodeNotFoundException;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice("xktz.website.web.register")
@Slf4j
public class RegisterControllerAdvice {

    private static final String MESSAGE_REGISTER_FAILED_EMAIL_HAS_BEEN_REGISTERED = "email has been registered";
    private static final String MESSAGE_ACTIVATE_FAILED_ACTIVATION_CODE_NOT_FOUND = "cannot find activation code";

    @ExceptionHandler({SQLIntegrityConstraintViolationException.class})
    @ResponseBody
    public OperationResult handleEmailDuplicated(SQLIntegrityConstraintViolationException exception) {
        return OperationResult.getInstance(false, MESSAGE_REGISTER_FAILED_EMAIL_HAS_BEEN_REGISTERED);
    }

    @ExceptionHandler({ActivationCodeNotFoundException.class})
    @ResponseBody
    public OperationResult handleActivationCodeNotFound(ActivationCodeNotFoundException exception) {
        return OperationResult.getInstance(false, MESSAGE_ACTIVATE_FAILED_ACTIVATION_CODE_NOT_FOUND + ": " + exception.getValue());
    }
}
