import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1001", "Tierra", "Needum", "2105551234", "123 Main Street");

        service.addContact(contact);

        assertNotNull(service.getContact("1001"));
        assertEquals("Tierra", service.getContact("1001").getFirstName());
    }

    @Test
    public void testAddNullContactThrowsException() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
    }

    @Test
    public void testAddDuplicateContactIdThrowsException() {
        ContactService service = new ContactService();
        Contact firstContact = new Contact("1001", "Tierra", "Needum", "2105551234", "123 Main Street");
        Contact secondContact = new Contact("1001", "Ty", "Smith", "8305559999", "456 Oak Avenue");

        service.addContact(firstContact);

        assertThrows(IllegalArgumentException.class, () -> service.addContact(secondContact));
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1002", "Tierra", "Needum", "2105551234", "123 Main Street");

        service.addContact(contact);
        service.deleteContact("1002");

        assertNull(service.getContact("1002"));
    }

    @Test
    public void testDeleteMissingContactThrowsException() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("9999"));
    }

    @Test
    public void testUpdateFirstName() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1003", "Tierra", "Needum", "2105551234", "123 Main Street");

        service.addContact(contact);
        service.updateFirstName("1003", "Ty");

        assertEquals("Ty", service.getContact("1003").getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1004", "Tierra", "Needum", "2105551234", "123 Main Street");

        service.addContact(contact);
        service.updateLastName("1004", "Smith");

        assertEquals("Smith", service.getContact("1004").getLastName());
    }

    @Test
    public void testUpdatePhone() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1005", "Tierra", "Needum", "2105551234", "123 Main Street");

        service.addContact(contact);
        service.updatePhone("1005", "8305559876");

        assertEquals("8305559876", service.getContact("1005").getPhone());
    }

    @Test
    public void testUpdateAddress() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1006", "Tierra", "Needum", "2105551234", "123 Main Street");

        service.addContact(contact);
        service.updateAddress("1006", "456 Oak Avenue");

        assertEquals("456 Oak Avenue", service.getContact("1006").getAddress());
    }

    @Test
    public void testUpdateMissingContactThrowsException() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("9999", "Ty"));
    }

    @Test
    public void testUpdatePhoneWithInvalidValueThrowsException() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1007", "Tierra", "Needum", "2105551234", "123 Main Street");

        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("1007", "123"));
    }
}
