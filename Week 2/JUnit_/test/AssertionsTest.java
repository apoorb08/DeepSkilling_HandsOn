package JUnit_.test;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This class demonstrates the use of common assertions in JUnit 4.
 * Each method tests a specific assertion to keep the tests focused and clear.
 */
public class AssertionsTest {

    @Test
    public void testAssertEquals() {
        // Checks if two values are equal.
        // It's one of the most common assertions you'll use.
        String expected = "Hello";
        String actual = "Hello";
        assertEquals("The two strings should be equal", expected, actual);

        // It works for primitives too.
        assertEquals(5, 2 + 3);
    }

    @Test
    public void testAssertTrueAndFalse() {
        // AssertTrue checks if a condition is true.
        assertTrue("5 should be greater than 3", 5 > 3);

        // AssertFalse checks if a condition is false.
        assertFalse("5 should not be less than 3", 5 < 3);
    }

    @Test
    public void testAssertNullAndNotNull() {
        // AssertNull checks if an object is null.
        // This is useful for verifying that a method returns null
        // under specific error conditions.
        Object myObject = null;
        assertNull("The object should be null", myObject);

        // AssertNotNull checks if an object is not null.
        // Useful for ensuring an object was successfully created.
        Object anotherObject = new Object();
        assertNotNull("The object should have been initialized", anotherObject);
    }

    @Test
    public void testAssertSameAndNotSame() {
        // AssertSame checks if two variables point to the *exact same object* in memory.
        String a = new String("test");
        String b = a; // b points to the same object as a
        assertSame("a and b should refer to the same object", a, b);

        // AssertNotSame checks if two variables point to different objects,
        // even if their contents are identical.
        String c = new String("test");
        assertNotSame("a and c should be different objects in memory", a, c);

        // To check for content equality, you should always use assertEquals.
        assertEquals("The content of a and c should be the same", a, c);
    }
}
