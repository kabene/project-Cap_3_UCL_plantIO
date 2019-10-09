import java.io.*;

public class TelegramMenu {
    public static void display(String menu) {
        String title = "";
        String body = "";
        
        if (menu.contains("main")) {
            title = Lang.get("main_menu");
            body = "/get : " + Lang.get("get_data") + "\n" +
                   "/save : " + Lang.get("save_data") + "\n" +
                   "/add : " + Lang.get("add_plants") + "\n" +
                   "/remove : " + Lang.get("remove_plants") + "\n" +
                   "/stat : " + Lang.get("get_stats") + "\n" +
                   "/graph : " + Lang.get("get_graphs") + "\n" +
                   "/prediction : " + Lang.get("get_preds") + "\n" +
                   "/lang : " + Lang.get("change_lang") + "\n";

        }
        
        if (menu.contains("save")) {
            title = Lang.get("save_menu");
            body = "/save\\_bamboo \n" +
                   "/save\\_cactus \n" +
                   "/save\\_orchidea \n" +
                   "/save\\_rose \n" +
                   "\n /back : " + Lang.get("back_main");
        }
        
        if (menu.contains("lang")) {
            title = Lang.get("lang_menu");
            body = "/lang\\_en : English \n" +
                   "/lang\\_fr : Français \n" +
                   "/lang\\_du : Nederlands \n" +
                   "/lang\\_it : Italiano \n" +
                   "\n /back : " + Lang.get("back_main");
        }
        
        if (menu.contains("get")) {
            title = Lang.get("get_menu");
            body += "/get\\_sensor : " + Lang.get("get_sensor_data") + "\n";
            
            if (PlantListener.isActive("bamboo")) {
                body += "/get\\_bamboo : " + Lang.get("get_bamboo_data") + "\n";
            }
            
            if (PlantListener.isActive("cactus")) {
                body += "/get\\_cactus : " + Lang.get("get_cactus_data") + "\n";
            }
            
            if (PlantListener.isActive("orchidea")) {
                body += "/get\\_orchidea : " + Lang.get("get_orchidea_data") + "\n";
            }
            
            if (PlantListener.isActive("rose")) {
                body += "/get\\_rose : " + Lang.get("get_rose_data") + "\n";
            }
            
            body += "\n /back : " + Lang.get("back_main");
        }
        
        if (menu.contains("add")) {
            title = Lang.get("add_menu");
            
            if (!PlantListener.isActive("bamboo")) {
                body += "/add\\_bamboo : " + Lang.get("add_bamboo") + "\n";
            }
            
            if (!PlantListener.isActive("cactus")) {
                body += "/add\\_cactus : " + Lang.get("add_cactus") + "\n";
            }
            
            if (!PlantListener.isActive("orchidea")) {
                body += "/add\\_orchidea : " + Lang.get("add_orchidea") + "\n";
            }
            
            if (!PlantListener.isActive("rose")) {
                body += "/add\\_rose : " + Lang.get("add_rose") + "\n";
            }
            
            if (body.equals("")) {
                body += Lang.get("all_plants_added") + "\n";
            }
            
            body += "\n /back : " + Lang.get("back_main");
        }
        
        if (menu.contains("remove")) {
            title = Lang.get("remove_menu");
            
            if (PlantListener.isActive("bamboo")) {
                body += "/remove\\_bamboo : " + Lang.get("remove_bamboo") + "\n";
            }
            
            if (PlantListener.isActive("cactus")) {
                body += "/remove\\_cactus : " + Lang.get("remove_cactus") + "\n";
            }
            
            if (PlantListener.isActive("orchidea")) {
                body += "/remove\\_orchidea : " + Lang.get("remove_orchidea") + "\n";
            }
            
            if (PlantListener.isActive("rose")) {
                body += "/remove\\_rose : " + Lang.get("remove_rose") + "\n";
            }
            
            if (body.equals("")) {
                body += Lang.get("all_plants_removed");
            }
            
            body += "\n /back : " + Lang.get("back_main");
        }
        
        if (menu.contains("stat_luminosity")) {
            title = Lang.get("lum_stats_menu");
            
            if (PlantListener.isActive("bamboo")) {
                body += "/stat\\_luminosity\\_bamboo : " + Lang.get("get_lum_stats_bamboo") + "\n";
            }
            
            if (PlantListener.isActive("cactus")) {
                body += "/stat\\_luminosity\\_cactus : " + Lang.get("get_lum_stats_cactus") + "\n";
            }
            
            if (PlantListener.isActive("orchidea")) {
                body += "/stat\\_luminosity\\_orchidea : " + Lang.get("get_lum_stats_orchidea") + "\n";
            }
            
            if (PlantListener.isActive("rose")) {
                body += "/stat\\_luminosity\\_rose : " + Lang.get("get_lum_stats_rose") + "\n";
            }
            
            if (body.equals("")) {
                body += Lang.get("no_lum_stats") + "\n";
            }
            
            body += "\n /stats : " + Lang.get("back_stats");
        }
        
        if (menu.contains("stat_humidity")) {
            title = Lang.get("hum_stats_menu");
            
            if (PlantListener.isActive("bamboo")) {
                body += "/stat\\_humidity\\_bamboo : " + Lang.get("get_hum_stats_bamboo") + "\n";
            }
            
            if (PlantListener.isActive("cactus")) {
                body += "/stat\\_humidity\\_cactus : " + Lang.get("get_hum_stats_cactus") + "\n";
            }
            
            if (PlantListener.isActive("orchidea")) {
                body += "/stat\\_humidity\\_orchidea : " + Lang.get("get_hum_stats_orchidea") + "\n";
            }
            
            if (PlantListener.isActive("rose")) {
                body += "/stat\\_humidity\\_rose : " + Lang.get("get_hum_stats_rose") + "\n";
            }
            
            if (body.equals("")) {
                body += Lang.get("no_hum_stats") + "\n";
            }
            
            body += "\n /stats : " + Lang.get("back_stats");
        }
        
        if (menu.contains("stat_temperature")) {
            title = Lang.get("temp_stats_menu");
            
            if (PlantListener.isActive("bamboo")) {
                body += "/stat\\_temperature\\_bamboo : " + Lang.get("get_temp_stats_bamboo") + "\n";
            }
            
            if (PlantListener.isActive("cactus")) {
                body += "/stat\\_temperature\\_cactus : " + Lang.get("get_temp_stats_cactus") + "\n";
            }
            
            if (PlantListener.isActive("orchidea")) {
                body += "/stat\\_temperature\\_orchidea : " + Lang.get("get_temp_stats_orchidea") + "\n";
            }
            
            if (PlantListener.isActive("rose")) {
                body += "/stat\\_temperature\\_rose : " + Lang.get("get_temp_stats_rose") + "\n";
            }
            
            if (body.equals("")) {
                body += Lang.get("no_temp_stats")+" \n";
            }
            
            body += "\n /stats : " + Lang.get("back_stats");
        }
        
        if (menu.contains("stat") && !menu.contains("humidity") && !menu.contains("temperature") && !menu.contains("luminosity")) {
            title = Lang.get("stats_menu");
            body = "/stat\\_humidity : " + Lang.get("hum_stats_menu") + "\n" +
                   "/stat\\_temperature : " + Lang.get("temp_stats_menu") + "\n" +
                   "/stat\\_luminosity : " + Lang.get("lum_stats_menu") + "\n" +
                   "\n /back : " + Lang.get("back_main");
        }
        
        if (menu.contains("graph_luminosity")) {
            title = Lang.get("graphics_luminosity_menu");
            
            if (PlantListener.isActive("bamboo")) {
                body += "/graph\\_luminosity\\_bamboo : " + Lang.get("get_bamboo_luminosity_graphic") + "\n";
            }
            
            if (PlantListener.isActive("cactus")) {
                body += "/graph\\_luminosity\\_cactus : " + Lang.get("get_cactus_luminosity_graphic") + "\n";
            }
            
            if (PlantListener.isActive("orchidea")) {
                body += "/graph\\_luminosity\\_orchidea : " + Lang.get("get_orchidea_luminosity_graphic") + "\n";
            }
            
            if (PlantListener.isActive("rose")) {
                body += "/graph\\_luminosity\\_rose : " + Lang.get("get_rose_luminosity_graphic") + "\n";
            }
            
            if (body.equals("")) {
                body += Lang.get("there_is_no_luminosity_graphic_to_display") + "\n";
            }
            
            body += "\n /graph : " + Lang.get("back_graphics");
        }
        
        if (menu.contains("graph_humidity")) {
            title = Lang.get("graphics_humidity_menu");
            
            if (PlantListener.isActive("bamboo")) {
                body += "/graph\\_humidity\\_bamboo : " + Lang.get("get_bamboo_humidity_graphic") + "\n";
            }
            
            if (PlantListener.isActive("cactus")) {
                body += "/graph\\_humidity\\_cactus : " + Lang.get("get_cactus_humidity_graphic") + "\n";
            }
            
            if (PlantListener.isActive("orchidea")) {
                body += "/graph\\_humidity\\_orchidea : " + Lang.get("get_orchidea_humidity_graphic") + "\n";
            }
            
            if (PlantListener.isActive("rose")) {
                body += "/graph\\_humidity\\_rose : " + Lang.get("get_rose_humidity_graphic") + "\n";
            }
            
            if (body.equals("")) {
                body += Lang.get("there_is_no_humidity_graphic_to_display") + "\n";
            }
            
            body += "\n /graph : " + Lang.get("back_graphics");
        }
        
        if (menu.contains("graph_temperature")) {
            title = Lang.get("graphic_temperature_menu");
            
            if (PlantListener.isActive("bamboo")) {
                body += "/graph\\_temperature\\_bamboo : " + Lang.get("get_bamboo_temperature_graphic") + "\n";
            }
            
            if (PlantListener.isActive("cactus")) {
                body += "/graph\\_temperature\\_cactus : " + Lang.get("get_cactus_temperature_graphic") + "\n";
            }
            
            if (PlantListener.isActive("orchidea")) {
                body += "/graph\\_temperature\\_orchidea : " + Lang.get("get_orchidea_temperature_graphic") + "\n";
            }
            
            if (PlantListener.isActive("rose")) {
                body += "/graph\\_temperature\\_rose : " + Lang.get("get_rose_temperature_graphic") + "\n";
            }
            
            if (body.equals("")) {
                body += Lang.get("there_is_no_temperature_statistics_to_display") + "\n";
            }
            
            body += "\n /graph : " + Lang.get("back_graphics");
        }
        
        if (menu.contains("graph") && !menu.contains("humidity") && !menu.contains("temperature") && !menu.contains("luminosity")) {
            title = Lang.get("graphic_menu");
            body = "/graph\\_humidity : " + Lang.get("humidity_graphics_menu") + "\n" +
                   "/graph\\_temperature : " + Lang.get("temperature_graphics_menu") + "\n" +
                   "/graph\\_luminosity : " + Lang.get("luminosity_graphics_menu") + "\n" +
                   "\n /back : " + Lang.get("back_graphics");
        }
                
        if (menu.contains("prediction")) {
            title =Lang.get("prediction_menu");
            
            if (PlantListener.isActive("bamboo")) {
                body += "/prediction\\_bamboo : " + Lang.get("get_bamboo_prediction") + "\n";
            }
            
            if (PlantListener.isActive("cactus")) {
                body += "/prediction\\_cactus : " + Lang.get("get_cactus_prediction") + "\n";
            }
            
            if (PlantListener.isActive("orchidea")) {
                body += "/prediction\\_orchidea : " + Lang.get("get_orchidea_prediction") + "\n";
            }
            
            if (PlantListener.isActive("rose")) {
                body += "/prediction\\_rose : " + Lang.get("get_rose_prediction") + "\n";
            }
            
            if (body.equals("")) {
                body += Lang.get("there_is_no_prediction_to_display") + "\n";
            }
            
            body += "\n /back : " + Lang.get("back_main");
        }
        
        try {
            TelegramListener.client.sendMessage(title, body);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
