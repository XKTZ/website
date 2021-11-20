package xktz.website.excep.handler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import xktz.website.domain.OperationResult;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler()
    @ResponseBody
    public OperationResult handleAllOtherExceptions(Exception e) {
        e.printStackTrace();
        log.error(e.getMessage());
        return OperationResult.getInstance(false, e.getMessage());
    }
}
