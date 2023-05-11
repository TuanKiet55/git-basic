package P0050;

import java.util.Scanner;

public class QuadraticEquation extends LinearEquation {

    private double a;

    public QuadraticEquation() {
    }

    public QuadraticEquation(double a, double b, double c) {
        super(b, c);
        this.a = a;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    @Override
    public void input() {
        System.out.print("Enter A: ");
        a = Validate.input();
        super.input();
    }

    public String solve() {
        if (a == 0) {
            return super.solve();
        } else {
            double denta = getB() * getB() - 4 * a * getC();
            if(denta < 0) return "the equation has no solution";
            return "Solution: x1 = " + Math.round(((-getB()+Math.sqrt(denta))/2/a)*1000.0)/1000.0 +
                    " and x2 = " + Math.round(((-getB()-Math.sqrt(denta))/2/a)*1000.0)/1000.0;
        }
    }

    @Override
    public String toString() {
        double[] arr = {a,getB(),getC()};
        return solve() + "\n"+ Validate.all(arr);
    }

    public static void main(String[] args) {
        QuadraticEquation fx = new QuadraticEquation();
        fx.input();
        System.out.println(fx);
    }
}
