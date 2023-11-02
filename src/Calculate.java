import java.text.DecimalFormat;

public class Calculate {
    public String quadratics(double a, double b, double c) {
        DecimalFormat df = new DecimalFormat("#.##");
        double sqrtPart = b * b - 4 * a * c;
        double x1, x2;
        if (sqrtPart < 0) {
            return "roots are on imaginary axis!";
        }

        x1 = ((-1 * b) + Math.sqrt(sqrtPart)) / (2 * a);
        x2 = ((-1 * b) - Math.sqrt(sqrtPart)) / (2 * a);
        return "x1 = " + df.format(x1) + ", x2 = " + df.format(x2);
    }

    public String linear(double b, double c) {
        DecimalFormat df = new DecimalFormat("#.##");
        double x = (-1 * c) / b;

        return "x = " + df.format(x);
    }

    public String squared(double a, double c) {
        DecimalFormat df = new DecimalFormat("#.##");
        double sqrtPart = (-1 * c) / a;
        double x = Math.sqrt(sqrtPart);

        if (sqrtPart < 0) {
            return "roots are on imaginary axis!";
        }
        return "x = ± " + df.format(x);
    }

}
