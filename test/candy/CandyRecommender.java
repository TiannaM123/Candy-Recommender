//Creator: Tianna
package candy;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import candy.Candy;
import candy.IngredientMap;

public class CandyRecommender {
private static List<Candy> candies = new ArrayList<>();
    
    // The ingredients the user likes
    private static List<String> likes = new ArrayList<>();
    
 // The ingredients the user loves
    private static List<String> loves = new ArrayList<>();
    
    // The ingredients the user dislikes
    private static List<String> dislikes = new ArrayList<>();
    //Ingredients list for candy object
    private List<String> ingredients = new ArrayList<>();
    
    //Ingredients list for candy object
    private List<String> ingredientsTwo = new ArrayList<>();
    
    // A map from ingredients to candies containing the ingredient.
    private static IngredientMap ingredientMap = new IngredientMap();
    
    //A candy object to test the candyRecommender class
    Candy twizzlers = new Candy("twizzlers", ingredients);
    
    //A candy object to test the candyRecommender class
    Candy snickers = new Candy("snickers", ingredientsTwo);
    
    @BeforeEach
    void setUp() throws Exception {
        ingredients.add("sugar");
        ingredients.add("corn syrup");
        ingredients.add("flour");
        ingredients.add("sugar");
        ingredientsTwo.add("chocolate");
        ingredientsTwo.add("peanuts");
        ingredientsTwo.add("sugar");
        loves.add("chocolate");
        loves.add("peanuts");
        likes.add("strawberry");
        likes.add("sugar");
        likes.add("peanuts");
        dislikes.add("nougut");
    }
    //This tests the findLikedCandies method
    @Test
    void testFindLikedCandies() {
        loves.add("chocolate");
        loves.add("peanuts");
        likes.add("strawberry");
        likes.add("sugar");
        Set<Candy> likedCandies = findLikedCandies();
        assertEquals(likes, likedCandies);
   
        }

    //This tests the findLovedCandies method 
    @Test
    void testFindLovedCandies() {
        Set<Candy> lovedCandies = new HashSet<>();
        loves.add("chocolate");
        loves.add("peanuts");
        likes.add("strawberry");
        likes.add("sugar");
        lovedCandies = findLovedCandies();
        assertEquals(loves, lovedCandies);
        }
    //This tests when there are no loved candies
    @Test
    void testFindLovedCandiesTwo() {
        Set<Candy> lovedCandies = new HashSet<>();
        likes.add("strawberry");
        likes.add("sugar");
        lovedCandies = findLovedCandies();
        assertEquals(loves, lovedCandies);
   
        }
  //This tests when there are only loved candies
    @Test
    void testFindLikedCandiesTwo() {
        //Candy twizzlers = new Candy("twizzlers", ingredients);
        Set<Candy> lovedCandies = new HashSet<>();
        lovedCandies = findLovedCandies();
        loves.add("strawberry");
        loves.add("sugar");
        assertEquals(loves, lovedCandies);
   
        }

}