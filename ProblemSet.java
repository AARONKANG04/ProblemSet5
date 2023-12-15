
/**
 * @Aaron Kang
 */
import java.util.Scanner;
import java.util.Random;
public class ProblemSet {
//    public static void main(String[] args) {
//        Fraction initialEstimate = new Fraction("52518/16717"); // You can set an initial estimate here
//        Fraction best = pi(initialEstimate);
//        while (best.toDouble() != Math.PI) {
//            best = pi(best);
//        }
//        FractionGame();
//    }


    /**
     * @param currentBest
     * @return the next Fraction that more accurately represents pi
     */
    public static Fraction pi(Fraction currentBest) {
        double best = Math.abs(Math.PI - currentBest.toDouble());
        Fraction estimate = currentBest;
        double epsilon = 1.0;
        while (Math.abs(Math.PI - estimate.toDouble()) >= best) {
            if (estimate.toDouble() < Math.PI) {
                estimate = new Fraction(estimate.getNum()+1, estimate.getDenom());
            }
            else {
                estimate = new Fraction(estimate.getNum(), estimate.getDenom()+1);
            }
        }
        System.out.println(estimate.getNum() + "/" + estimate.getDenom() + " -> " + estimate.toDouble());
        return estimate;
    }



    /**
     * Fraction Quiz Game: Generates random arithmetic questions with Fractions for the user to solve.
     */
    public static void FractionGame() {
        Scanner scanner = new Scanner(System.in);
        int correct = 0;
        int total = 0;
        while (true) {
            Fraction first = randomFrac();
            Fraction second = randomFrac();
            char op = randomOp();
            System.out.print(first.getNum() + "/" + first.getDenom() + " " + op + " " + second.getNum() + "/" + second.getDenom() + " = ");
            String input = scanner.nextLine().trim();
            Fraction userInput = new Fraction();
            if (input.equalsIgnoreCase("quit")) {
                System.out.println(total);
                if (total == 0) {
                    System.out.println("Your win/loss ratio was 0/0 for a total of 0 percent...");
                }
                else {
                    System.out.println("Your win/loss ratio was " + correct + "/" + total + " for a total of " + Math.round((double)correct/total*100) + " percent!");
                }
                break;
            }
            else {
                userInput = new Fraction(input);
            }
            Fraction answer = calculateAnswer(first, second, op);
            if (answer.getNum() == userInput.getNum() && answer.getDenom() == userInput.getDenom()) {
                correct++;
                total++;
                System.out.println("Correct!");
            }
            else {
                total++;
                System.out.println("Wrong, the answer was " + answer.getNum() + "/" + answer.getDenom());
            }
        }
    }


    /**
     * @param first
     * @param second
     * @param op
     * @return A Fraction object that is the result of op on first and second
     */
    public static Fraction calculateAnswer(Fraction first, Fraction second, char op) {
        Fraction answer;
        switch (op) {
            case '+':
                answer = Fraction.add(first, second);
                break;
            case '-':
                answer = Fraction.subtract(first, second);
                break;
            case '*':
                answer = Fraction.multiply(first, second);
                break;
            case '/':
                answer = Fraction.divide(first, second);
                break;
            default:
                throw new IllegalArgumentException("Invalid operator: " + op);
        }
        return answer;
    }

    /**
     * Operations are +, -, *, or /
     * @return A random operation as a char
     */
    public static char randomOp() {
        Random random = new Random();
        char[] operators = {'+', '-', '*', '/'};
        return operators[random.nextInt(operators.length)];
    }


    /**
     * @return A Fraction object with a random numerator (0-10) and denominator (1-10)
     */
    public static Fraction randomFrac() {
        return new Fraction((int)(Math.random()*10), (int)(Math.random()*9)+1);
    }
}

