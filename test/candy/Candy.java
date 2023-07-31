package candy;
//Creator: Tianna
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

class CandyTest {
    private List<String> ingredients = new ArrayList<>();
    private List<String> ingredientsTwo = new ArrayList<>();
    Candy twizzlers = new Candy("twizzlers", ingredients);
    Candy airhead = new Candy("airhead", ingredientsTwo);

    @BeforeEach
    void setUp() throws Exception {
        ingredients.add("strawberry");
        ingredientsTwo.add("sugar");
        //Candy twizzlers = new Candy("twizzlers", ingredients);
    }
    /*This test tests the constructor, to see if it correctly makes a candy object**/
    @Test
    public void testCandy() {
       Candy hersheys = new Candy("hersheys", ingredients);
    }
    /*This test tests the get name method, to see if it correctly gets the name from the 
     * candy object**/
    @Test
    void testGetName() {
        //String ingredientName = twizzlers.getName();
        //assertEquals("twizzlers", ingredientName);
        assertEquals("twizzlers", twizzlers.getName());
    }
    /*This tests to see if score correctly returns 0 if there are no ingredients in the
     * like list**/
    @Test
    void testScore() {
        List<String> like = new ArrayList<String>();
        like.add("chocolate");
        assertEquals(0,twizzlers.score(like));
   
        }
    /*This tests to see if score correctly returns the number 10 if the candy has all the 
     * ingredients the user likes in the like list**/
    @Test
    void testScoreTwo() {
        List<String> like2 = new ArrayList<String>();
        like2.add("strawberry");
        assertEquals(10, twizzlers.score(like2));
        
    }
    /*This tests what the score method returns if there is nothing in the like list**/
    @Test
    void testScoreThree() {
        List<String> like3 = new ArrayList<String>();
        assertEquals(0, twizzlers.score(like3));
    }
    /*This tests what the scoreLove method returns if there is nothing in the like list**/
    @Test
    void testScoreLove() {
        List<String> love = new ArrayList<String>();
        assertEquals(0, airhead.scoreLove(love));
    }
    /*This tests to see what will happen if score correctly returns the number 10 if the candy has all the 
     * ingredients the user loves in the love list**/
    @Test
    void testScoreLoveTwo() {
        List<String> loveTwo = new ArrayList<String>();
        loveTwo.add("suagr");
        assertEquals(10, airhead.scoreLove(loveTwo));
    }
    
}