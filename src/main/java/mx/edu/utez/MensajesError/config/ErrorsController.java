package mx.edu.utez.MensajesError.config;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import java.io.IOException;

@RestControllerAdvice
public class ErrorsController {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, Object>> handleNotFoundException(EntityNotFoundException ex) {
        return buildErrorResponse(HttpStatus.NOT_FOUND, "No se ha encontrado el recurso de tu petición, inténtalo nuevamente.", "COD1");
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, Object>> handleBadRequest(MethodArgumentTypeMismatchException ex) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, "Tú solicitud es incorrecta, inténtalo nuevamente.", "COD2");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Error interno del sistema, vuelve a intentarlo.", "COD3");
    }

    @ExceptionHandler(SQLException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Map<String, Object>> handleDatabaseException(SQLException ex) {
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Ocurrió un error en la base de datos, por favor vuelve a intentarlo.", "COD4");
    }

    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, Object>> handleNoResourceFoundException(NoResourceFoundException ex) {
        return buildErrorResponse(HttpStatus.NOT_FOUND, "La URL que ingresaste no existe, por favor vuelve a intentarlo.", "COD5");
    }

    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<Map<String, Object>> handleNotAcceptableException(HttpMediaTypeNotAcceptableException ex) {
        return buildErrorResponse(HttpStatus.NOT_ACCEPTABLE, "El formato de tu respuesta no es soportado por el sistema, vuelve a intentarlo.", "COD6");
    }

    @ExceptionHandler(SecurityException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<Map<String, Object>> handleForbiddenException(SecurityException ex) {
        return buildErrorResponse(HttpStatus.FORBIDDEN, "Acceso no autorizado, vuelve a intentarlo.", "COD7");
    }

    @ExceptionHandler(IllegalAccessException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<Map<String, Object>> handleUnauthorizedException(IllegalAccessException ex) {
        return buildErrorResponse(HttpStatus.UNAUTHORIZED, "Al parecer no estás autorizado, inténtalo nuevamente.", "COD8");
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Map<String, Object>> handleNullPointerException(NullPointerException ex) {
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Se produjo un error al procesar la solicitud. Un valor inesperado es nulo.", "COD9");
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, Object>> handleIndexOutOfBoundsException(IndexOutOfBoundsException ex) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, "El índice solicitado está fuera del rango permitido.", "COD10");
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, Object>> handleNumberFormatException(NumberFormatException ex) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, "El formato del número ingresado no es válido.", "COD11");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ResponseEntity<Map<String, Object>> handleMethodNotAllowedException(HttpRequestMethodNotSupportedException ex) {
        return buildErrorResponse(HttpStatus.METHOD_NOT_ALLOWED, "El método HTTP utilizado no está permitido para esta operación. Inténtalo nuevamente.", "COD12");
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, Object>> handleConstraintViolationException(ConstraintViolationException ex) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, "Se ha violado una restricción de datos. Verifica tu solicitud.", "COD13");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, Object>> handleValidationException(MethodArgumentNotValidException ex) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, "Uno o más valores ingresados no son válidos. Verifica los datos.", "COD14");
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, Object>> handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, "Falta un parámetro en la solicitud. Inténtalo nuevamente.", "COD15");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(IllegalArgumentException ex) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, "Se ha ingresado un argumento inválido.", "COD16");
    }

    @ExceptionHandler(UnsupportedOperationException.class)
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public ResponseEntity<Map<String, Object>> handleUnsupportedOperationException(UnsupportedOperationException ex) {
        return buildErrorResponse(HttpStatus.NOT_IMPLEMENTED, "La operación solicitada no es soportada por el sistema.", "COD17");
    }

    @ExceptionHandler(StackOverflowError.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Map<String, Object>> handleStackOverflowError(StackOverflowError ex) {
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Se detectó una recursión infinita o un uso excesivo de la memoria.", "COD18");
    }

    @ExceptionHandler(TimeoutException.class)
    @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
    public ResponseEntity<Map<String, Object>> handleTimeoutException(TimeoutException ex) {
        return buildErrorResponse(HttpStatus.REQUEST_TIMEOUT, "La operación tardó demasiado en responder.", "COD19");
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, Object>> handleArithmeticException(ArithmeticException ex) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, "Error matemático en la operación solicitada.", "COD20");
    }

    @ExceptionHandler(FileNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, Object>> handleFileNotFoundException(FileNotFoundException ex) {
        return buildErrorResponse(HttpStatus.NOT_FOUND, "El archivo solicitado no se encontró en el servidor.", "COD21");
    }

    @ExceptionHandler(IOException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Map<String, Object>> handleIOException(IOException ex) {
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Error de entrada/salida. Vuelve a intentarlo.", "COD22");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, Object>> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, "Error en el formato de la solicitud. Verifica el contenido enviado.", "COD23");
    }

    private ResponseEntity<Map<String, Object>> buildErrorResponse(HttpStatus status, String message, String code) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("Status", status.value());
        errorResponse.put("Message", message);
        errorResponse.put("Code", code);
        return new ResponseEntity<>(errorResponse, status);
    }

}