public class QuadraticEquation {
    private double a;
    private double b;
    private double c;
    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminant() {
        return b * b - 4 * a * c;
    }

    public String getRoots() {
        double discriminant = getDiscriminant();
        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            return "Roots are: " + root1 + " and " + root2;
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            return "Root is: " + root;
        } else {
            return "The equation has no real roots.";
        }
    }
}
public static void main(String[] args) {
    QuadraticEquation equation = new QuadraticEquation(1, -3, 2);
    System.out.println(equation.getRoots());
}