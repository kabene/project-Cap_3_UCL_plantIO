import java.io.*;
import java.util.Date;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import data.Sample;
import time.Instant;

public class Database {
    /*
     * @pre sample != null
     * @post parse (transform) sample into String
     */
    public static String sampleToString(Sample sample) {
        assert sample != null;
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy@hh:mm:ss");
        
        String date = dateFormat.format(sample.getTime().toDate());
        float temperature = sample.getTemperature();
        float humidity = sample.getHumidity();
        
        return date + "=" + temperature + "," + humidity + "," + Database.getLast("lum");
    }
    
    /*
     * @pre plant != null
     *      sample != null
     * @post save sample in file
     */
    public static void save(String file, Sample sample) {
        assert file != null;
        assert sample !=null;
        
        BufferedWriter writer = null;
        
        // Parse sample to string
        String data = sampleToString(sample);
        
        try {
            writer = new BufferedWriter(new FileWriter("sample/" + file + ".txt", true));
            writer.write(data);
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
    
    /*
     * @pre string != null, string must be of format "key=value";
     * @post parse (transform) String into sample
     */
    public static Sample stringToSample(String string) {
        assert string != null;
        
        String[] split = string.split("=");
        
        Date date = null;
        float temperature = Float.parseFloat(split[1].split(",")[0]);
        float humidity = Float.parseFloat(split[1].split(",")[1]);
        
        try {
            date = new SimpleDateFormat("dd/MM/yyyy@hh:mm:ss").parse(split[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return new Sample(temperature, humidity, new Instant(date));
    }
    
    /*
     * @pre file != null
     * @post load data from file
     */
    public static Sample[] load(String file) {
        assert file != null;
        
        BufferedReader reader = null;
        ArrayList<Sample> samples = new ArrayList<Sample>();
        
        try {
            reader = new BufferedReader(new FileReader("sample/" + file + ".txt"));
            String line;
            
            while ((line = reader.readLine()) != null) {
                Sample sample = stringToSample(line);
                samples.add(sample);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        
        return samples.toArray(new Sample[samples.size()]);
    }
    
    /*
     * @pre -
     * @post return last line of file
     */
    public static String getLast(String file) {
        String line = null;
        String lastLine = null;
        BufferedReader reader = null;
        
        try {
            reader = new BufferedReader(new FileReader("sample/" + file + ".txt"));

            while ((lastLine = reader.readLine()) != null) {
                line = lastLine;
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
        
        return line;
    }
    
    /*
     * @pre file != null
     * @post clear the content of a file
     */
    public static void clear(String file) {
        assert file != null;
        
        FileWriter writer = null;
        
        try {
            writer = new FileWriter("sample/" + file + ".txt");
        } catch(IOException e) {
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
    
    public static Sample stringToSampleLuminosity(String string) {
        assert string != null;
        
        String[] split = string.split("=");
        
        Date date = null;
        float luminosity = Float.parseFloat(split[1].split(",")[2]);
        float humidity = Float.parseFloat(split[1].split(",")[1]);
        
        try {
            date = new SimpleDateFormat("dd/MM/yyyy@hh:mm:ss").parse(split[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return new Sample(luminosity, humidity, new Instant(date));
    }
    
    public static Sample[] loadLuminosity(String file) {
        assert file != null;
        
        BufferedReader reader = null;
        ArrayList<Sample> samples = new ArrayList<Sample>();
        
        try {
            reader = new BufferedReader(new FileReader("sample/" + file + ".txt"));
            String line;
            
            while ((line = reader.readLine()) != null) {
                Sample sample = stringToSampleLuminosity(line);
                samples.add(sample);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        
        return samples.toArray(new Sample[samples.size()]);
    }
}
