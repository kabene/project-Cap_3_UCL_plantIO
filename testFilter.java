import data.Sample;
import interfaces.Filter;

public class testFilter implements Filter
{
    public boolean matchedBy(Sample s){
        return s.getHumidity() > 30;
    }
}
