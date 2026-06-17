package com.grasp.jagunap.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// OOP: Immutability test — verifies state cannot be changed after creation
class OrderSnapshotTest {

    @Test
    void shouldPreserveStateAfterCreation() {
        OrderSnapshot snapshot = new OrderSnapshot("Juan", 500.0, "PENDING", 2);

        assertEquals("Juan", snapshot.getCustomerName());
        assertEquals(500.0, snapshot.getTotal());
        assertEquals("PENDING", snapshot.getStatus());
        assertEquals(2, snapshot.getItemCount());
    }

    @Test
    void shouldNotHaveSetters() {
        // Verify via reflection that no setter methods exist
        var methods = OrderSnapshot.class.getMethods();
        for (var method : methods) {
            assertFalse(method.getName().startsWith("set"),
                    "Immutable class should not have setters, found: " + method.getName());
        }
    }

    @Test
    void twoSnapshotsWithSameDataShouldHaveSameValues() {
        OrderSnapshot s1 = new OrderSnapshot("Juan", 500.0, "PENDING", 2);
        OrderSnapshot s2 = new OrderSnapshot("Juan", 500.0, "PENDING", 2);
        assertEquals(s1.getTotal(), s2.getTotal());
        assertEquals(s1.getCustomerName(), s2.getCustomerName());
    }
}