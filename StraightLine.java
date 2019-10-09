/**
 * A class that represents a straight line equation
 */
public class StraightLine {

    private  double a,b;

    /**
     * y = slope * x + intercept
     * @param slope
     * @param intercept
     */
    public StraightLine(double slope,double intercept) {
        a = slope;
        b = intercept;
    }

    public double evaluate(double x ) {
        return a * x + b;
    }

    public double getIntercept() {
        return b;
    }

    public double getSlope() {
        return a;
    }

    @Override
    public String toString() {
        return "y="+a+"*x+"+b;
    }
}
