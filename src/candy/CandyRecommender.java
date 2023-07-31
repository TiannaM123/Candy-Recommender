//Creator:Tianna Major
//Collaborators: Linda and Zineb
package candy;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * This program reads candies and their ingredients from a file.  It then asks
 * the user which of those ingredients they like/dislike.  Finally, it rates
 * the candies and tells the user which ones they would probably like.
 */
public class CandyRecommender {
    // All known candies
    private static List<Candy> candies = new ArrayList<>();

    //The ingredients the user loves
   private static List<String> loves = new ArrayList<>();


    // The ingredients the user likes
    private static List<String> likes = new ArrayList<>();

    // The ingredients the user dislikes
    private static List<String> dislikes = new ArrayList<>();

    // A map from ingredients to candies containing the ingredient.
    private static IngredientMap ingredientMap = new IngredientMap();

    /**
     * Read the candy information from the file called Candy.txt.  The file
     * should be formatted like this:  candy name:ingredient 1, ingredient 2
     * Initializes the candies list and the ingredientMap.
     * @throws FileNotFoundException if the Candy.txt file cannot be found.
     */
    private static void readCandyFile() throws FileNotFoundException {
      File newFile = new File("Candy/Candy.txt");
      try (Scanner in = new Scanner (newFile)) {
            // Read in each candy
            while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] parsedLine = line.split(":");
                String name = parsedLine[0];
                String[] ingredients = parsedLine[1].split(",");
                List <String> ingredientList = Arrays.asList(ingredients);
                Candy candy = new Candy(name, ingredientList);
                candies.add(candy);

                // Add the information to the ingredient map.
                for (String ingredient : ingredients) {
                    ingredientMap.add(ingredient, candy);
                }
            }

        }
        System.out.println("Read " + candies.size() +
                           " candies from the file.");
    }

    /**
     * For each ingredient found in any candy, ask the user if they like,
     * dislike, or are neutral about that ingredient.
     */
    private static void getUserPreferences() {
        try (Scanner in = new Scanner (System.in)) {

            // Ask the user about each ingredient
            for (String ingredient : ingredientMap.ingredients()) {
                System.out.print ("How much do you like " + ingredient +
                                  "? (2-love, 1-like, 0-ok, -1-dislike) ");
                String answer = in.nextLine();
                try {
                    int pref = Integer.parseInt(answer);
                    switch (pref) {
                    case 1:
                        likes.add(ingredient);
                        break;
                    case -1:
                        dislikes.add(ingredient);
                        break;
                   case 2:
                       loves.add(ingredient);
                       break;
                    default:
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter 2, 1, 0, or -1");
                }
            }
        }
    }

    /**
     * Recommend candies that you think the user will like based upon their
     * likes and dislikes and what the candies contain.  It will not suggest
     * any candidates that contain ingredients the user dislikes.  It will
     * give a score to candies that contain only ingredients the user likes with at least one love ingredient.
     * A higher score is better.
     * @return the candies that this user would probably like
     */
    private static Set<Candy> findLikedCandies() {
      //hashset of candies that are filled with ingredients the user likes
        Set<Candy> possible = new HashSet<>();
        for (String ingredient : likes) {
            possible.addAll (ingredientMap.getCandyWith(ingredient));
        }
        for (String ingredient : dislikes) {
            possible.removeAll (ingredientMap.getCandyWith(ingredient));
        }
        for (String ingredient : loves) {
            possible.addAll(ingredientMap.getCandyWith(ingredient));
        }
        return possible;
    }


    /* Recommend candies that you think the user will like based upon their
    * loves, likes, and dislikes and what the candies contain.  It will not suggest
    * any candidates that contain ingredients the user dislikes.  It will
    * give a score to candies that contain only ingredients the user loves.
    * A higher score is better.
    * @return the candies that this user would probably like
    */
   private static Set<Candy> findLovedCandies() {
     //the hashset of candies that are filled with ingredients the user loves
     Set<Candy> possibleTwo = new HashSet<>();
     for (String ingredient : likes) {
         possibleTwo.removeAll (ingredientMap.getCandyWith(ingredient));
     }
     for (String ingredient : dislikes) {
         possibleTwo.removeAll (ingredientMap.getCandyWith(ingredient));
     }
     for (String ingredient : loves) {
         possibleTwo.addAll (ingredientMap.getCandyWith(ingredient));
     }
     return possibleTwo;
  }




    /**
     * Outputs the list of candies to the screen
     * @param possible the candies to output
     */
    private static void recommendCandies(Set<Candy> possible) {
      System.out.println("Recommend Candies You Will Like:");
      for (Candy c: possible) {
          System.out.println(c.getName() + ": " + c.score(likes));
        }
    }
    /**
     * Outputs the list of candies to the screen
     * @param possibleTwo the candies to output
     */
    private static void recommendLovedCandies(Set<Candy> possibleTwo) {
      System.out.println("Recommend Candies You Will Love:");
      for (Candy c: possibleTwo) {
          System.out.println(c.getName() + ": " + c.scoreLove(loves));
        }
    }


    /**
     * Reads the candies from a file, asks the user for their likes and
     * dislikes, and makes a recommendation
     * @param args none
     */
    public static void main(String[] args) {
        try {
            readCandyFile();
            getUserPreferences();
            Set<Candy> likedCandies = findLikedCandies();
            Set<Candy> lovedCandies = findLovedCandies();
            recommendCandies(likedCandies);
            recommendLovedCandies(lovedCandies);
        } catch (FileNotFoundException e) {
            System.out.println ("Unable to read the Candy.txt file");
        }
    }

}
