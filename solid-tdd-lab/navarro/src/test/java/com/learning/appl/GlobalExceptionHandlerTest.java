package com.learning.appl;

import com.learning.appl.exception.GlobalExceptionHandler;
import com.learning.appl.exception.InvalidOrderException;
import com.learning.appl.exception.OrderNotFoundException;
import com.learning.appl.exception.UnsupportedPaymentMethodException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler handler = new GlobalExceptionHandler();

    @Test
    @DisplayName("Should map missing order to 404 response")
    void shouldHandleNotFound() {
        ResponseEntity<Map<String, Object>> response =
                handler.handleNotFound(new OrderNotFoundException(10L));

        assertError(response, HttpStatus.NOT_FOUND, "10");
    }

    @Test
    @DisplayName("Should map invalid order to 400 response")
    void shouldHandleInvalidOrder() {
        ResponseEntity<Map<String, Object>> response =
                handler.handleInvalid(new InvalidOrderException("bad order"));

        assertError(response, HttpStatus.BAD_REQUEST, "bad order");
    }

    @Test
    @DisplayName("Should map unsupported payment to 400 response")
    void shouldHandleUnsupportedPayment() {
        ResponseEntity<Map<String, Object>> response =
                handler.handlePayment(new UnsupportedPaymentMethodException("unsupported"));

        assertError(response, HttpStatus.BAD_REQUEST, "unsupported");
    }

    @Test
    @DisplayName("Should combine validation field errors")
    void shouldHandleValidationErrors() {
        MethodArgumentNotValidException exception = mock(MethodArgumentNotValidException.class);
        BindingResult bindingResult = mock(BindingResult.class);
        when(exception.getBindingResult()).thenReturn(bindingResult);
        when(bindingResult.getFieldErrors()).thenReturn(List.of(
                new FieldError("orderRequest", "customerName", "required"),
                new FieldError("orderRequest", "items", "must not be empty")
        ));

        ResponseEntity<Map<String, Object>> response = handler.handleValidation(exception);

        assertError(response, HttpStatus.BAD_REQUEST, "customerName: required");
        assertThat(response.getBody()).containsEntry(
                "message",
                "customerName: required; items: must not be empty");
    }

    private void assertError(
            ResponseEntity<Map<String, Object>> response,
            HttpStatus expectedStatus,
            String expectedMessagePart) {
        assertThat(response.getStatusCode()).isEqualTo(expectedStatus);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody()).containsEntry("status", expectedStatus.value());
        assertThat(response.getBody()).containsEntry("error", expectedStatus.getReasonPhrase());
        assertThat(response.getBody().get("message").toString()).contains(expectedMessagePart);
        assertThat(response.getBody()).containsKey("timestamp");
    }
}
