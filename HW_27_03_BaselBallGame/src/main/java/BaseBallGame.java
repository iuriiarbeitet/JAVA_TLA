import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {

    public int findTotalScore(String[] basebol) {
        List<Integer> score=new ArrayList<>();
        int totalScore=0;

        for (int i=0; i < basebol.length; i++) {
            String event=basebol[i];
            switch (event) {
                case "0":
                    score.add(0);
                    break;
                case "1":
                    score.add(1);
                    break;
                case "2":
                    score.add(2);
                    break;
                case "3":
                    score.add(3);
                    break;
                case "4":
                    score.add(4);
                    break;
                case "5":
                    score.add(5);
                    break;
                case "6":
                    score.add(6);
                    break;
                case "7":
                    score.add(7);
                    break;
                case "8":
                    score.add(8);
                    break;
                case "9":
                    score.add(9);
                    break;
                case "C":
                    if (score.size() > 0) {
                        score.remove(score.size() - 1);
                    }
                    break;
                case "D":
                    score.add(2 * (score.get(score.size() - 1)));
                    break;
                case "+":
                    if (score.size() > 1) {
                        score.add((score.get(score.size() - 1)) + (score.get(score.size() - 2)));
                    }
                    if (score.size() == 1) {
                        score.add((score.get(score.size() - 1)));
                    }
                    break;
            }
        }
        for (int i=0; i < score.size(); i++) {
            totalScore+=score.get(i);
        }
        return totalScore;
    }
}
