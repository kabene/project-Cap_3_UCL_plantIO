import java.io.*;

import telegram.TelegramClient;
import telegram.TelegramMessageListener;

public class TelegramListener {
    public static TelegramClient client = null;
    public static String name = "lsinf1102_p3_CAP_04_bot";
    public static String path = "486857440:AAEIydNKID7_HMT8pDC3jEcaPP9mmHIfVu0";
    public static String group = "-266642788";
    
    /*
     * @pre -
     * @post add listener to telegram
     */
    public static void listen() throws IOException {
        client = new TelegramClient(name, path, group);

        client.addListener (new TelegramMessageListener() {
            @Override
            public void messageReceived(String message) {
                TelegramDispatcher.dispatch(message);
                //TelegramCommand.run(message);
            }
        });
    }
}
