package com.grasp.cardeno.validation;

import com.grasp.cardeno.dto.TaskDTO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskValidatorTest {

    private final TaskValidator validator = new TaskValidator();

    @Test
    void testValidate_NullDto_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate(null));
    }

    @Test
    void testValidate_NullOrEmptyTitle_ThrowsException() {
        TaskDTO dtoWithNullTitle = new TaskDTO();
        dtoWithNullTitle.setTitle(null);

        TaskDTO dtoWithEmptyTitle = new TaskDTO();
        dtoWithEmptyTitle.setTitle("   ");

        assertThrows(IllegalArgumentException.class, () -> validator.validate(dtoWithNullTitle));
        assertThrows(IllegalArgumentException.class, () -> validator.validate(dtoWithEmptyTitle));
    }

    @Test
    void testValidate_ValidTask_DoesNotThrowException() {
        TaskDTO validDto = new TaskDTO();
        validDto.setTitle("Valid Task Title");

        // This should run without throwing any exceptions
        assertDoesNotThrow(() -> validator.validate(validDto));
    }
}