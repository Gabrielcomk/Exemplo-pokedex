
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Busque seu pokémon favorito: ");
        String search = scanner.nextLine();

        String url = "https://pokeapi.co/docs/v2/" + search;

        try {
            // Criando a conexão HTTP
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}