public class LinearRegressionGradientDescent {
    /**
     * @param x the x coordinates
     * @param y the y coordinates i.e. point i is defined as (x[i],y[i])
     * @param alpha the learning rate of the gradient descent
     *      (a small positive value, typically 0.001)
     * @param iter  the number of iteration of the gradient descent algorithm
     * @return a line equation that fits at best (least-square error) the given points using the "gradient descent algorihtm" initialized with m=0 (slope), b=0 (intercept).
     */
    public static StraightLine fitLine(double [] x, double [] y, double alpha, int iter) {
        double slope = 0;
        double intercept = 0;

        // On change l'équation de la droite à chaque itération en minimisant l'erreur.
        for (int j = 0, i = (int) (Math.random() * x.length); j < iter; j++, i = (int) (Math.random() * x.length)) {
            double guess = slope * x[i] + intercept;
            double error = y[i] - guess;

            // Corrige la pente
            slope += (error * x[i]) * alpha;

            // Corrige l'ordonnée à l'origine
            intercept += error * alpha;
        }

        return new StraightLine(slope, intercept);
    }
}
