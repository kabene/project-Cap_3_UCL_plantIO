import data.Sample;

import interfaces.Stats;
import interfaces.Filter;

public class Statistics implements Stats {
    /*
     * @pre samples.length > 0, samples est un tableau de mesures. Toutes les mesures de températures sont exprimées dans la même unité.
     * @post retourne la moyenne mathématique de la température du tableau de mesures.
     */
    @Override
    public float getAverageTemp(Sample[] samples) {
        float averageTemp = 0;

        for (int i = 0; i < samples.length; i++) {
            averageTemp += samples[i].getTemperature();
        }

        return averageTemp / samples.length;
    }

    /*
     * @pre samples.length > 0, samples est un tableau de mesures. Toutes les mesures d'humidités sont exprimées dans la même unité.
     * @post retourne la moyenne mathématique de l'humidité du tableau de mesures.
     */
    @Override
    public float getAverageHum(Sample[] samples) {
        float averageHum = 0;

        for (int i = 0; i < samples.length; i++) {
            averageHum += samples[i].getHumidity();
        }
        return averageHum / samples.length;
    }

    /*
     * @pre samples.length > 0, samples est un tableau de mesures. Toutes les mesures de températures sont exprimées dans la même unité.
     * @post retourne la température minimale du tableau de mesures.
     */
    @Override
    public float getMinTemp(Sample[] samples) {
        float minTemp = samples[0].getTemperature();

        for (int i = 1; i < samples.length; i++) {
            if (samples[i].getTemperature() < minTemp) {
                minTemp = samples[i].getTemperature();
            }
        }

        return minTemp;
    }

    /*
     * @pre samples.length > 0, samples est un tableau de mesures. Toutes les mesures d'humidités sont exprimées dans la même unité.
     * @post retourne l'humidité minimale du tableau de mesures.
     */
    @Override
    public float getMinHum(Sample[] samples) {
        float minHum = samples[0].getHumidity();

        for (int i = 1; i < samples.length; i++) {
            if (samples[i].getHumidity() < minHum) {
                minHum = samples[i].getHumidity();
            }
        }

        return minHum;
    }

    /*
     * @pre samples.length > 0, samples est un tableau de mesures. Toutes les mesures de températures sont exprimées dans la même unité.
     * @post retourne la température maximale du tableau de mesures.
     */
    @Override
    public float getMaxTemp(Sample[] samples) {
        float maxTemp = samples[0].getTemperature();

        for (int i = 1; i < samples.length; i++) {
            if (samples[i].getTemperature() > maxTemp) {
                maxTemp = samples[i].getTemperature();
            }
        }

        return maxTemp;
    }

    /*
     * @pre samples.length > 0, samples est un tableau de mesures. Toutes les mesures d'humidités sont exprimées dans la même unité.
     * @post retourne l'humidité maximale du tableau de mesures.
     */
    @Override
    public float getMaxHum(Sample[] samples) {
        float maxHum = samples[0].getHumidity();

        for (int i = 1; i < samples.length; i++) {
            if(samples[i].getHumidity() > maxHum) {
                maxHum = samples[i].getHumidity();
            }
        }

        return maxHum;
    }

    /*
     * @pre samples.length > 0, samples est un tableau de mesures. Toutes les mesures de températures sont exprimées dans la même unité.
     * @post retourne la variance de la température du tableau de mesures.
     */
    @Override
    public float getVarianceTemp(Sample[] samples) {
        float varianceTemp = 0;

        for (int i = 0; i < samples.length; i++) {
            varianceTemp += Math.pow((samples[i].getTemperature() - getAverageTemp(samples)), 2);
        }

        return varianceTemp / samples.length;
    }

    /*
     * @pre samples.length > 0, samples est un tableau de mesures. Toutes les mesures d'humidité sont exprimées dans la même unité.
     * @post retourne la variance de l'humidité du tableau de mesures.
     */
    @Override
    public float getVarianceHum(Sample[] samples) {
        float varianceHum = 0;

        for (int i = 0; i < samples.length; i++) {
            varianceHum += Math.pow((samples[i].getHumidity() - getAverageHum(samples)), 2);
        }

        return varianceHum / samples.length;
    }

    /*
     * @pre samples.length > 0, samples est un tableau de mesures. Toutes les mesures de températures sont exprimées dans la même unité.
     * @post retourne l'écart-type de la température du tableau de mesures.
     */
    @Override
    public float getStandardDeviationTemp(Sample[] samples) {
        return (float) Math.sqrt(getVarianceTemp(samples));
    }

    /*
     * @pre samples.length > 0, samples est un tableau de mesures. Toutes les mesures d'humidité sont exprimées dans la même unité.
     * @post retourne l'écart-type de l'humidité du tableau de mesures.
     */
    @Override
    public float getStandardDeviationHum(Sample[] samples) {
        return (float) Math.sqrt(getVarianceHum(samples));
    }

    /*
     * @pre samples.length > 0, samples est un tableau de mesure. Toutes les mesures respectives sont exprimées dans la même unité.
     * @post retourne la covarience entre l'humidité et la température
     */
    public float getCovarianceTempHum(Sample[] samples) {
        float numCovariance = 0;

        for (int i = 0; i < samples.length; i++) {
            // TODO
            // ini (samples[i].getTemperature() - getAverageTemp(samples))
            // ini (samples[i].getHumidity() - getAverageHum(samples))
            numCovariance += ((samples[i].getTemperature() - getAverageTemp(samples)) * (samples[i].getHumidity() - getAverageHum(samples)));
        }

        return numCovariance / samples.length;
    }

    /*
     * @pre samples.length > 0, samples est un tableau de mesures. Toutes les mesures respectives sont exprimées dans la même unité.
     * @post retourne le coefficient de corrélation de Pearson (compris entre -1 et 1) entre la température et l'humidité.
     */
    @Override
    public float correlationTempHum(Sample[] samples) {
        return getCovarianceTempHum(samples) / (getStandardDeviationHum(samples) * getStandardDeviationTemp(samples));
    }

    /*
     * @pre samples != null, filter != null
     * @post retourn un nouveau tableau de Sample newSample qui passent par le Filter filter. L'ordre des samples doit être le même.
     */
    @Override
    public Sample[] filter(Sample[] samples, Filter filter) {
        int newSampleLength = 0;

        for (int i = 0; i < samples.length; i++) {
            if (filter.matchedBy(samples[i])) {
                newSampleLength++;
            }
        }

        Sample[] newSample = new Sample[newSampleLength];

        int newSampleIndex = 0;

        for (int i = 0; i < samples.length; i++) {
            if (filter.matchedBy(samples[i])) {
                newSample[newSampleIndex] = samples[i];
                newSampleIndex++;
            }
        }

        return newSample;
    }
}
