import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("12345", "Tierra", "Needum", "2105551234", "123 Main Street");

        assertEquals("12345", contact.getContactId());
        assertEquals("Tierra", contact.getFirstName());
        assertEquals("Needum", contact.getLastName());
        assertEquals("2105551234", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    public void testContactIdCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Tierra", "Needum", "2105551234", "123 Main Street");
        });
    }

    @Test
    public void testContactIdCannotBeTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Tierra", "Needum", "2105551234", "123 Main Street");
        });
    }

    @Test
    public void testFirstNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Needum", "2105551234", "123 Main Street");
        });
    }

    @Test
    public void testFirstNameCannotBeTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "LongFirstName", "Needum", "2105551234", "123 Main Street");
        });
    }

    @Test
    public void testLastNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Tierra", null, "2105551234", "123 Main Street");
        });
    }

    @Test
    public void testLastNameCannotBeTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Tierra", "LongLastName", "2105551234", "123 Main Street");
        });
    }

    @Test
    public void testPhoneMustBeExactlyTenDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Tierra", "Needum", "21055", "123 Main Street");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Tierra", "Needum", "abcdefghij", "123 Main Street");
        });
    }

    @Test
    public void testAddressCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Tierra", "Needum", "2105551234", null);
        });
    }

    @Test
    public void testAddressCannotBeTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Tierra", "Needum", "2105551234", "1234567890123456789012345678901");
        });
    }

    @Test
    public void testUpdateFields() {
        Contact contact = new Contact("12345", "Tierra", "Needum", "2105551234", "123 Main Street");

        contact.setFirstName("Ti");
        contact.setLastName("Nee");
        contact.setPhone("8305559876");
        contact.setAddress("456 Oak Avenue");

        assertEquals("Ti", contact.getFirstName());
        assertEquals("Nee", contact.getLastName());
        assertEquals("8305559876", contact.getPhone());
        assertEquals("456 Oak Avenue", contact.getAddress());
    }
}
