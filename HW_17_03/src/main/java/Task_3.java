import java.util.HashMap;
import java.util.Map;

/**
 *
 Task 3. Дана строка. Вывести количество появлений каждого символа в этой строке. Например:
 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer eu feugiat tellus. Nam molestie diam sed libero egestas pellentesque. Nulla.

 Символ e встречается 20 раз.
 Символ пробел/space встречается 19 раз.
 Символ l встречается 11 раз.
 Символ i встречается 11 раз.
 Символ t встречается 11 раз.
 Символ s встречается 10 раз.
 Символ u встречается 7 раз.
 Символ a встречается 7 раз.
 Символ n встречается 6 раз.
 Символ m встречается 6 раз.
 Символ o встречается 6 раз.
 Символ r встречается 5 раз.
 Символ . встречается 4 раз.
 Символ g встречается 4 раз.
 Символ d встречается 4 раз.
 Символ c встречается 3 раз.
 Символ p встречается 3 раз.
 Символ , встречается 1 раз.
 Символ f встречается 1 раз.
 Символ b встречается 1 раз.
 Символ q встречается 1 раз.
 */

public class Task_3 {
    public static void main(String[] args) {
        getUniqueCharMapEx("Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Integer eu feugiat tellus. Nam molestie diam sed libero egestas pellentesque. Nulla.");
    }

    public static void getUniqueCharMapEx (String s) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz ,.:;-";
        String str = s.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < alphabet.length(); i++) {
            map.put(alphabet.charAt(i), 0);
        }

        for(Map.Entry<Character, Integer> pair: map.entrySet())
        {
            Character key = pair.getKey();
            Integer value = pair.getValue();
            for (int i = 0; i < str.length(); i++) {
                if (key == str.charAt(i)) {
                    value += 1;
                }
            }
            map.put(key, value);
        if (value != 0 ) System.out.println("Символ \"" + key + "\" встречается -> " +  value + " раз.");
        }
    }
}
