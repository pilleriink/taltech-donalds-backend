package ee.taltech.backend.exception;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@NoArgsConstructor
@RequiredArgsConstructor
public class ClientOrderNotFoundException extends Throwable {
    @NonNull
    private String message;
}