package P0050;

import java.util.Scanner;

public class LinearEquation {

    private double b;
    private double c;

    public LinearEquation() {
    }

    public LinearEquation(double b, double c) {
        this.b = b;
        this.c = c;
    }
    
    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public void input() {
        System.out.print("Enter B: ");
        b = Validate.input();
        System.out.print("Enter C: ");
        c = Validate.input();
    }
    
    public String toString(){
        double[] arr = {b,c};
        return solve() +"\n"+ Validate.all(arr);
    }
    public String solve(){
        if(b == 0 && c != 0) return "the equation has no solution";
        if(b == 0 && c == 0) return "infinitely many solutions";
        return "Solution: x = " + Math.round((-c/b)*1000.0)/1000.0 ;
    }
    public static void main(String[] args) {
        LinearEquation fx = new LinearEquation();
        fx.input();
        System.out.println(fx);
    }
}
