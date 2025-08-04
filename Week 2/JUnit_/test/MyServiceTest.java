package JUnit_.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

/**
 * This class tests MyService using a mock of ExternalApi.
 */
public class MyServiceTest {
    private ExternalApi api; // Add this field

    @Test
    public void testFetchDataWithMockApi() {
        // 1. Arrange: Create a mock object for the external dependency
        System.out.println("Creating a mock for ExternalApi...");
        api = mock(ExternalApi.class);

        // 2. Arrange: Stub the method call
        System.out.println("Stubbing the getData() method...");
        when(api.getData()).thenReturn("Mock Data");

        // 3. Act: Use the service with the mock
        String result = fetchData();

        // 4. Assert
        System.out.println("Asserting the result...");
        assertEquals("The result should be the data returned by the mock.", "Mock Data", result);
        System.out.println("Test passed!");
    }

    private String fetchData() {
        // Now uses the api field
        return api.getData();
    }

    @Test
    public void testVerifyInteraction() {
        // 1. Arrange
        api = mock(ExternalApi.class);

        // 2. Act
        fetchData();

        // 3. Verify
        verify(api).getData();
    }
}