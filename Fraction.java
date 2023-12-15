
/**
 * @Aaron Kang
 */
public class Fraction {

    private int numerator;
    private int denominator;


    /**
     * Default constructor. Creates a fraction of 1/1
     */
    public Fraction() {
        this.numerator = 1;
        this.denominator = 1;
    }

    /**
     * Parameterized constructor
     * @param numerator the desired numerator
     * @param denominator the desired denominator
     */
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * @param frac
     */
    public Fraction(String frac) {
        int i = 0;
        String[] fracs = frac.split("/");
        try {
            this.numerator = Integer.parseInt(fracs[0]);
            this.denominator = Integer.parseInt(fracs[1]);
        }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Please enter a valid input!");
        }
    }

    /**
     * @param frac
     */
    public Fraction(Fraction frac) {
        this.numerator = frac.numerator;
        this.denominator = frac.denominator;
    }


    /**
     * @return The numerator of the fraction
     */
    public int getNum() {
        return this.numerator;
    }

    /**
     * @return The denominator of the fraction
     */
    public int getDenom() {
        return this.denominator;
    }

    /**
     * @return The double representation of the fraction
     */
    public double toDouble() {
        return (double) this.numerator/this.denominator;
    }
    

    /**
     * Reduces the fraction to lowest terms
     */
    private void reduce() {
        int gcf = gcf(this.numerator, this.denominator);
        this.numerator /= gcf;
        this.denominator /= gcf;
    }


    /**
     * @param numerator
     */
    public void setNum(int numerator) {
        this.numerator = numerator;
    }


    /**
     * @param denominator
     */
    public void setDenom(int denominator) {
        this.denominator = denominator;
    }


    /**
     * @param a
     * @param b
     * @return A fraction object that is the product of a and b
     */
    public static Fraction multiply(Fraction a, Fraction b) {
        Fraction product = new Fraction(a.getNum()*b.getNum(), a.getDenom()*b.getDenom());
        product.reduce();
        return product;
    }

    /**
     *
     * @param a
     * @param b
     * @return A fraction object that is the quotient of a and b
     */
    public static Fraction divide(Fraction a, Fraction b) {
        Fraction quotient = new Fraction(a.getNum()*b.getDenom(), a.getDenom()*b.getNum());
        quotient.reduce();
        return quotient;
    }

    /**
     *
     * @param a
     * @param b
     * @return A fraction object that is the sum of a and b
     */
    public static Fraction add(Fraction a, Fraction b) {
        Fraction sum = new Fraction(a.getNum()*b.getDenom()+b.getNum()*a.getDenom(), a.getDenom()*b.getDenom());
        sum.reduce();
        return sum;
    }


    /**
     *
     * @param a
     * @param b
     * @return A fraction object that is the difference of a and b
     */
    public static Fraction subtract(Fraction a, Fraction b) {
        Fraction sub = new Fraction(a.getNum()*b.getDenom()-b.getNum()*a.getDenom(), a.getDenom()*b.getDenom());
        sub.reduce();
        return sub;
    }

    /**
     * @param a any integer
     * @param b any integer
     * @return the greatest common divisor of a and b
     */
    private static int gcf(int a, int b) {
        if (b == 0) return a;
        else return gcf(b, a%b);
    }
}

