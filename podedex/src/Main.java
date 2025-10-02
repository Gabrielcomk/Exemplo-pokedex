import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Busque seu pokémon favorito: ");
        String search = scanner.nextLine();

        String url = "https://pokeapi.co/api/v2/pokemon/" + search;

        try {
            //conexão
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                System.out.println("Erro: Pokémon não encontrado ou problema na API (código " + response.statusCode() + ")");
                return;
            }

            String json = response.body();
            Gson gson = new Gson();

            // Convertendo o JSON para objeto usando o GSON
            PokemonAtributos meuPokemon = gson.fromJson(json, PokemonAtributos.class);

            // Exibe as info
            System.out.println("Name: " + meuPokemon.getName());
            System.out.println("ID: " + meuPokemon.getId());
            System.out.println("Tipo: " + meuPokemon.getTypes());
            System.out.println("Info: " + meuPokemon.getStats());

        } catch (IOException | InterruptedException e) {
            System.out.println("Erro de conexão: " + e.getMessage());
        } catch (JsonSyntaxException e) {
            System.out.println("Erro ao interpretar o JSON da API.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
}
