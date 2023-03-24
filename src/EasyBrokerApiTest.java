public class EasyBrokerApiTest {

    public void testGetEasyBroker() throws Exception {
        String uri = "https://api.stagingeb.com/v1/properties?page=1&limit=20";
        EasyBrokerApi.getEasyBroker(uri);
    }

}