package candy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IngredientMapTest {
    private Map<String, List<Candy>> ingredientMap = new HashMap<>();
    private List<String> ingredients = new ArrayList<>();
    private List<String> ingredientsTwo = new ArrayList<>();
    //Candy twizzlers = new Candy("twizzlers", ingredients);
    Candy airhead = new Candy("airhead", ingredientsTwo);
    
    
   // add("strawberry", twizzlers);
    
    @BeforeEach
    void setUp() throws Exception {
       // ingredients.add("strawberry");
        ingredientsTwo.add("sugar");
    }


    //This tests to see if the ingredients method works
    @Test
    void testIngredients() {
        Map<String, List<Candy>> ingredientMap2 = new HashMap<>();
        Candy twizzlers = new Candy("twizzlers", ingredients);
        ingredients.add("strawberry");
        ingredientMap2.add("strawberry", twizzlers);
        Set<String> output = twizzlers.ingredients();
        assertTrue(output.contains("strawberry"));
        
    }
  //This tests to see if the add method works properly
    @Test
    void testAdd() {
        Map<String, List<Candy>> ingredientMap3 = new HashMap<>();
        Candy twizzlers = new Candy("twizzlers", ingredients);
        ingredients.add("strawberry");
        ingredientMap3.add("strawberry", twizzlers);
        assertTrue(ingredientMap3.containsKey("strawberry")||ingredientMap3.containsValue(twizzlers));
      
    }
    //This tests to see if the add works if two candies have the same ingredients
    @Test
    void testAddTwo() {
        Map<String, List<Candy>> ingredientMap3 = new HashMap<>();
        Candy twizzlers = new Candy("twizzlers", ingredients);
        Candy sourStraw = new Candy("sourStraw", ingredients);
        ingredients.add("strawberry");
        ingredientMap3.add("strawberry", twizzlers);
        ingredientMap3.add("strawberry", sourStraw);
        assertTrue(ingredientMap3.containsKey("strawberry")||ingredientMap3.containsValue(twizzlers)||ingredientMap3.containsValue(sourStraw));
      
    }
    
 //This tests to see if the getCandyWith method works
   @Test
   void testGetCandyWith() {
       Map<String, List<Candy>> ingredientMap4 = new HashMap<>();
       Candy twizzlers = new Candy("twizzlers", ingredients);
       Candy sourStraw = new Candy("sourStraw", ingredients);
       ingredients.add("strawberry");
       assertTrue(getCandyWith("strawberry").contains(twizzlers)||getCandyWith("strawberry").contains(sourStraw));
       
   }
}
