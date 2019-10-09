public class TelegramDispatcher {
    /*
     * @pre message != null
     * @post match message to command and dispatch it
     */
    public static void dispatch(String message) {
        assert message != null;

        if (message.contains("/main") || message.contains("back")) {
            TelegramMenu.display("main");
            return;
        }
        
        if (message.contains("save_bamboo")) {
            TelegramCommand.saveFile("bamboo");
            return;
        }
        
        if (message.contains("save_cactus")) {
            TelegramCommand.saveFile("cactus");
            return;
        }
        
        if (message.contains("save_orchidea")) {
            TelegramCommand.saveFile("orchidea");
            return;
        }
        
        if (message.contains("save_rose")) {
            TelegramCommand.saveFile("rose");
            return;
        }
        
        if (message.contains("save")) {
            TelegramMenu.display("save");
            return;
        }

        if (message.contains("/add_bamboo")) {
            TelegramCommand.addPlant("bamboo");
            return;
        }
        
        if (message.contains("/add_cactus")) {
            TelegramCommand.addPlant("cactus");
            return;
        }
        
        if (message.contains("/add_orchidea")) {
            TelegramCommand.addPlant("orchidea");
            return;
        }
        
        if (message.contains("/add_rose")) {
            TelegramCommand.addPlant("rose");
            return;
        }
        
        if (message.contains("/remove_bamboo")) {
            TelegramCommand.removePlant("bamboo");
            return;
        }
        
        if (message.contains("/remove_cactus")) {
            TelegramCommand.removePlant("cactus");
            return;
        }
        
        if (message.contains("/remove_orchidea")) {
            TelegramCommand.removePlant("orchidea");
            return;
        }
        
        if (message.contains("/remove_rose")) {
            TelegramCommand.removePlant("rose");
            return;
        }

        if (message.contains("/get_sensor")) {
            TelegramCommand.getData("sensor");
            return;
        }
        
        if (message.contains("/get_bamboo")) {
            TelegramCommand.getData("bamboo");
            return;
        }
        
        if (message.contains("/get_cactus")) {
            TelegramCommand.getData("cactus");
            return;
        }
        
        if (message.contains("/get_orchidea")) {
            TelegramCommand.getData("orchidea");
            return;
        }
        
        if (message.contains("/get_rose")) {
            TelegramCommand.getData("rose");
            return;
        }
        
        if (message.contains("/stat_luminosity_bamboo")) {
            TelegramCommand.getLuminosityStats("bamboo");
            return;
        }
        
        if (message.contains("/stat_luminosity_cactus")) {
            TelegramCommand.getLuminosityStats("cactus");
            return;
        }
        
        if (message.contains("/stat_luminosity_orchidea")) {
            TelegramCommand.getLuminosityStats("orchidea");
            return;
        }
        
        if (message.contains("/stat_luminosity_rose")) {
            TelegramCommand.getLuminosityStats("rose");
            return;
        }
        
        if (message.contains("/stat_temperature_bamboo")) {
            TelegramCommand.getTemperatureStats("bamboo");
            return;
        }
        
        if (message.contains("/stat_temperature_cactus")) {
            TelegramCommand.getTemperatureStats("cactus");
            return;
        }
        
        if (message.contains("/stat_temperature_orchidea")) {
            TelegramCommand.getTemperatureStats("orchidea");
            return;
        }
        
        if (message.contains("/stat_temperature_rose")) {
            TelegramCommand.getTemperatureStats("rose");
            return;
        }
        
        if (message.contains("/stat_humidity_bamboo")) {
            TelegramCommand.getHumidityStats("bamboo");
            return;
        }
        
        if (message.contains("/stat_humidity_cactus")) {
            TelegramCommand.getHumidityStats("cactus");
            return;
        }
        
        if (message.contains("/stat_humidity_orchidea")) {
            TelegramCommand.getHumidityStats("orchidea");
            return;
        }
        
        if (message.contains("/stat_humidity_rose")) {
            TelegramCommand.getHumidityStats("rose");
            return;
        }
        
        if (message.contains("/get")) {
            TelegramMenu.display("get");
            return;
        }
        
        if (message.contains("/add")) {
            TelegramMenu.display("add");
            return;
        }
        
        if (message.contains("/remove")) {
            TelegramMenu.display("remove");
            return;
        }
        
        if (message.contains("/stat_humidity")) {
            TelegramMenu.display("stat_humidity");
            return;
        }
        
        if (message.contains("/stat_temperature")) {
            TelegramMenu.display("stat_temperature");
            return;
        }
        
        if (message.contains("/stat_luminosity")) {
            TelegramMenu.display("stat_luminosity");
            return;
        }
        
        if (message.contains("/stat")) {
            TelegramMenu.display("stat");
            return;
        }
        
        if (message.contains("/graph_luminosity_bamboo")) {
            TelegramCommand.getLuminosityGraph("bamboo");
            return;
        }
        
        if (message.contains("/graph_luminosity_cactus")) {
            TelegramCommand.getLuminosityGraph("cactus");
            return;
        }
        
        if (message.contains("/graph_luminosity_orchidea")) {
            TelegramCommand.getLuminosityGraph("orchidea");
            return;
        }
        
        if (message.contains("/graph_luminosity_rose")) {
            TelegramCommand.getLuminosityGraph("rose");
            return;
        }
        
        if (message.contains("/graph_temperature_bamboo")) {
            TelegramCommand.getTemperatureGraph("bamboo");
            return;
        }
        
        if (message.contains("/graph_temperature_cactus")) {
            TelegramCommand.getTemperatureGraph("cactus");
            return;
        }
        
        if (message.contains("/graph_temperature_orchidea")) {
            TelegramCommand.getTemperatureGraph("orchidea");
            return;
        }
        
        if (message.contains("/graph_temperature_rose")) {
            TelegramCommand.getTemperatureGraph("rose");
            return;
        }
        
        if (message.contains("/graph_humidity_bamboo")) {
            TelegramCommand.getHumidityGraph("bamboo");
            return;
        }
        
        if (message.contains("/graph_humidity_cactus")) {
            TelegramCommand.getHumidityGraph("cactus");
            return;
        }
        
        if (message.contains("/graph_humidity_orchidea")) {
            TelegramCommand.getHumidityGraph("orchidea");
            return;
        }
        
        if (message.contains("/graph_humidity_rose")) {
            TelegramCommand.getHumidityGraph("rose");
            return;
        }
        
        if (message.contains("/graph_luminosity")) {
            TelegramMenu.display("graph_luminosity");
            return;
        }
        
        if (message.contains("/graph_humidity")) {
            TelegramMenu.display("graph_humidity");
            return;
        }
        
        if (message.contains("/graph_temperature")) {
            TelegramMenu.display("graph_temperature");
            return;
        }
        
        if (message.contains("/graph")) {
            TelegramMenu.display("graph");
            return;
        }
        
        if (message.contains("/prediction_bamboo")) {
            TelegramCommand.getPrediction("bamboo");
            return;
        }
        
        if (message.contains("/prediction_cactus")) {
            TelegramCommand.getPrediction("cactus");
            return;
        }
        
        if (message.contains("/prediction_orchidea")) {
            TelegramCommand.getPrediction("orchidea");
            return;
        }
        
        if (message.contains("/prediction_rose")) {
            TelegramCommand.getPrediction("rose");
            return;
        }
        
        if (message.contains("/prediction")) {
            TelegramMenu.display("prediction");
            return;
        }
        
        if (message.contains("/lang_")) {
            TelegramCommand.setLang(message);
            return;
        }
        
        if (message.contains("/lang")) {
            TelegramMenu.display("lang");
        }
    }
}
