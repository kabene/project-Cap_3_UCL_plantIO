import java.io.*;
import java.util.HashMap;

public class Lang {
    public static HashMap<String, String> text;
    
    /*
     * @pre lang != null
     * @post load lang file
     */
    public static void load(String lang) {
        assert lang != null;
      
        BufferedReader reader = null;
        Lang.text = new HashMap<String, String>();
        
        try {
            reader = new BufferedReader(new FileReader("lang/" + lang + ".txt"));
            String line;
            
            while ((line = reader.readLine()) != null) {
                String[] split = line.split("=");
                
                String key = split[0];
                String value = split[1];
       
                Lang.text.put(key, value);                
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    /*
     * @pre key != null
     * @post return translation of key
     */
    public static String get(String key) {
        assert key != null;
        
        return text.get(key);
    }
}
