public class Irrigation {
    /*
     * @pre plant != null, plant must be "bamboo", "cactus", "orchidea", "rose"
     * @post irrigate plant if lower than half of its bound
     */
    public static void irrigate(String plant) {
        assert plant != null;
        assert plant.equals("bamboo") || plant.equals("cactus") || plant.equals("orchidea") || plant.equals("rose");
        
        float irrigationQty;
        
        if (plant.equals("bamboo")) {
            // Calculate the "middle" bound (lower - higher)
            irrigationQty = PlantListener.bamboo.getLowerBound() + ((PlantListener.bamboo.getHigherBound() - PlantListener.bamboo.getLowerBound()) / 2);
            
            if (PlantListener.bambooLastSample.getHumidity() < irrigationQty) {
                PlantListener.bamboo.water(5 * (int) (irrigationQty - PlantListener.bambooLastSample.getHumidity()));
            }
        }
        
        if (plant.equals("cactus")) {
            irrigationQty = PlantListener.cactus.getLowerBound() + ((PlantListener.cactus.getHigherBound() - PlantListener.cactus.getLowerBound()) / 2);
            
            if (PlantListener.cactusLastSample.getHumidity() < irrigationQty) {
                PlantListener.cactus.water(5 * (int) (irrigationQty - PlantListener.cactusLastSample.getHumidity()));
            }
        }
        
        if (plant.equals("orchidea")) {
            irrigationQty = PlantListener.orchidea.getLowerBound() + ((PlantListener.orchidea.getHigherBound() - PlantListener.orchidea.getLowerBound()) / 2);
            
            if (PlantListener.orchideaLastSample.getHumidity() < irrigationQty) {
                PlantListener.orchidea.water(5 * (int) (irrigationQty - PlantListener.orchideaLastSample.getHumidity()));
            }
        }
        
        if (plant.equals("rose")) {
            irrigationQty = PlantListener.rose.getLowerBound() + ((PlantListener.rose.getHigherBound() - PlantListener.rose.getLowerBound()) / 2);
            
            if (PlantListener.roseLastSample.getHumidity() < irrigationQty) {
                PlantListener.rose.water(5 * (int) (irrigationQty - PlantListener.roseLastSample.getHumidity()));
            }
        }
    }
}
