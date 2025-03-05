package mx.edu.utez.MensajesError.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ApiResponse {
    private Object data;
    private int status;
    private boolean error;
    private String message;

    public ApiResponse(Object data, HttpStatus status) {
        this.data = data;
        this.status = status.value();
    }

    public ApiResponse(HttpStatus status,boolean error, String message) {
        this.status = status.value();
        this.error = error;
        this.message = message;
    }

    public ApiResponse(Object data, HttpStatus status, boolean error, String message) {
        this.data = data;
        this.status = status.value();
        this.error = error;
        this.message = message;
    }
}
