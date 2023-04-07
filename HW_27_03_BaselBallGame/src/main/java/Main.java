/**
 * Baseball Game
 *
 * You are keeping the scores for a baseball game with strange rules. At the beginning of the game,
 * you start with an empty record.
 * You are given a list of strings operations, where operations[i]
 * is the ith operation you must apply to the record and is one of the following:
         * An integer x - Record a new score of x.
 *      '+' - Record a new score that is the sum of the previous two scores.
 *      'D' - Record a new score that is the double of the previous score.
 *      'C' - Invalidate the previous score, removing it from the record.
 * Return the sum of all the scores on the record after applying all the operations.
 *
 * Example 1:
 * Input: ops = ["5","2","C","D","+"]
 * Output: 30
 * Explanation:
 * "5" - Add 5 to the record, record is now [5].
 * "2" - Add 2 to the record, record is now [5, 2].
 * "C" - Invalidate and remove the previous score, record is now [5].
 * "D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
 * "+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
 * The total sum is 5 + 10 + 15 = 30.
 *
 * Example 2:
 * Input: ops = ["1","C"]
 * Output: 0
 * Explanation:
 * "1" - Add 1 to the record, record is now [1].
 * "C" - Invalidate and remove the previous score, record is now [].
 * Since the record is empty, the total sum is 0.
 *
 * Задача довольно легко решается, если придумать, какую структуру данных лучше использовать. Вы уже прошли все коллекции в Java. Какая из них лучше всего подходит для решения этой задачи?
 */



public class Main {

    public static void main(String[] args) {
        BaseBallGame baseBallGame = new BaseBallGame();
        String basebol[]={"5", "2", "C", "D", "+"};
        //String basebol[]={"1",  "C", };
        System.out.println(baseBallGame.findTotalScore(basebol));

    }

}
