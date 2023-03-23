import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.json.JSONArray;
import org.json.JSONObject;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("-------------------------------------------- ");
        System.out.println("Get a Api de Propiedades para listar Titulos ");
        System.out.println("-------------------------------------------- ");
        getEasyBroker("https://api.stagingeb.com/v1/properties?page=1&limit=20");
        System.out.println("-------------------------------------------- ");
        System.out.println("Fin");
        System.out.println("------------------------------------------- ");
    }

    public static void getEasyBroker(String uri) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("accept", "application/json")
                .header("X-Authorization", "l7u502p8v46ba3ppgvj5y2aad50lb9")
                .build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        JSONObject json = new JSONObject(response.body());
        JSONArray properties = json.getJSONArray("content");

        for (int i = 0; i < properties.length(); i++) {
            JSONObject property = properties.getJSONObject(i);
            String title = property.getString("title");
            System.out.println(i +" - "+ title);
        }

    }
}

