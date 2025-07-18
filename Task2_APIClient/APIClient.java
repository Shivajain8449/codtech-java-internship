import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class APIClient {

    public static void main(String[] args) {
        try {
            // API URL
            String url = "https://jsonplaceholder.typicode.com/posts/1";

            // Create connection
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            // Read response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder responseContent = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                responseContent.append(inputLine);
            }
            in.close();

            // Parse JSON using Gson
            JsonObject post = JsonParser.parseString(responseContent.toString()).getAsJsonObject();

            // Display structured output
            System.out.println("ID: " + post.get("id").getAsInt());
            System.out.println("Title: " + post.get("title").getAsString());
            System.out.println("Body: " + post.get("body").getAsString());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
