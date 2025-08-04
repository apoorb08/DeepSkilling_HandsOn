public class MyService {
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    /**
     * A method that uses the external API to fetch data.
     * @return The data fetched from the API.
     */
    public String fetchData() {
        System.out.println("MyService is fetching data...");
        return externalApi.getData();
    }
}
