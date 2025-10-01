
import com.google.gson.Gson;

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

        String url = "https://pokeapi.co/api/v2/pokemon/" + search;

            // Criando a conexão HTTP
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());


        String json = response.body();
        Gson gson = new Gson();

        //convertendo o JSON para objeto usando o GSON
        PokemonAtributos meuPokemon = gson.fromJson(json, PokemonAtributos.class);




        System.out.println("Name: " + meuPokemon.getName());
        System.out.println("ID: " + meuPokemon.getId());
        System.out.println("Tipo: " + meuPokemon.getTypes());
        System.out.println("Info: " + meuPokemon.getStats());



    }
}