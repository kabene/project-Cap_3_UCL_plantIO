import java.io.*;
import java.util.*;
import java.util.regex.*;

public class LangBlueprint {
    public static ArrayList<String> origin = new ArrayList<String>(Arrays.asList(
        "TelegramMenu.java",
        "Alert.java",
        "TelegramCommand.java"
    ));
    
    public static String destination = "lang/blueprint.txt";
    
    public static void read() {
        for (String file : origin) {
            String line = null;
            BufferedReader reader = null;
            
            try {
                reader = new BufferedReader(new FileReader(file));
                
                while ((line = reader.readLine()) != null) {
                    if (needToParse(line)) {
                        String parse = parse(line);
                        String clean = clean(parse);
                        
                        if (needToSave(clean)) {
                            save(clean);
                        }
                    }
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
    }
    
    public static boolean needToParse(String string) {
        return string.contains("Lang.get");
    }
    
    public static String parse(String string) {
        String result = null;
        Pattern pattern = Pattern.compile("Lang.get\\(\".+\"\\)");
        Matcher matcher = pattern.matcher(string);
        
        if (matcher.find()) {
            result = matcher.group(0);
        }
        
        return result;
    }
    
    public static String clean(String string) {
        String result = null;
        Pattern pattern = Pattern.compile("\".+\"");
        Matcher matcher = pattern.matcher(string);
        
        if (matcher.find()) {
            result = matcher.group(0).replaceAll("\"", "");
        }
        
        return result;
    }
    
    public static boolean needToSave(String string) {
        String line = null;
        BufferedReader reader = null;
            
        try {
            reader = new BufferedReader(new FileReader(destination));
            
            while ((line = reader.readLine()) != null) {
                String[] split = line.split("=");
                String key = split[0];
                
                if (string.equals(key)) {                
                    return false;
                }
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
        
        return true;
    }
    
    public static void save(String string) {
        BufferedWriter writer = null;
        
        try {
            writer = new BufferedWriter(new FileWriter(destination, true));
            writer.write(string + "=");
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
