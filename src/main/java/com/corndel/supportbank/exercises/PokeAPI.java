package com.corndel.supportbank.exercises;

import kong.unirest.Unirest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * This class represents a Pokemon. It uses Java's record syntax to
 * automatically generate a class with getters and utility methods.
 * See this url for more info:
 * https://www.baeldung.com/java-record-keyword
 */



public class PokeAPI {

  @JsonIgnoreProperties(ignoreUnknown = true)
  record Pokemon(Integer id, String name, Integer height, Integer weight) {
  }
  /**
   * Get a Pokemon by its name.
   *
   * Makes a GET request to the PokeAPI, and uses Jackson to parse the JSON
   * response into a Pokemon object.
   *
   * @param name The name of the Pokemon to retrieve.
   * @return The Pokemon object.
   */



  public static Pokemon getPokemonByName(String name) throws Exception {
    // TODO: Create the url by appending the name to the base url
    String url = "https://pokeapi.co/api/v2/pokemon/" + name;

    // TODO: Make a GET request to the url
    // Hint: Use Unirest.get()
    var response = Unirest
            .get(url)
            .header("Accept", "application/json")
            .asString();

    String json = response.getBody();

    // TODO: Parse the response body into a Pokemon object
    // Hint: Use Jackson's ObjectMapper to map the response body to Pokemon.class
    ObjectMapper mapper = new ObjectMapper();
  return mapper.readValue(json, Pokemon.class);

  }
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class PokemonList {
    public List<Pokemon> results;
  }

  public static List<Pokemon> getPokemonList() throws Exception {
    String url = "https://pokeapi.co/api/v2/pokemon?limit=100"; // You can adjust the limit

    var response = Unirest
            .get(url)
            .header("Accept", "application/json")
            .asString();

    String json = response.getBody();
    System.out.println(json);

    ObjectMapper mapper = new ObjectMapper();
    PokemonList pokemonList = mapper.readValue(json, PokemonList.class);
    return pokemonList.results;
  }
  /**
   * For debugging purposes..
   */
  public static void main(String[] args) {
    try {
      Pokemon pokemon = getPokemonByName("pikachu");
      System.out.println(pokemon);


      List<Pokemon> pokemonList = getPokemonList();
      pokemonList.forEach(System.out::println);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
