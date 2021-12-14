import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<String> readFromFile(String pathToFile){
        List<String> fileReadings = new ArrayList<>();
        try {
            URL resource = Task1.class.getResource( pathToFile);
            fileReadings = Files.readAllLines( Paths.get( resource.toURI()) );
        } catch ( IOException | URISyntaxException e ) {
            e.printStackTrace();
        }
        return  fileReadings;
    }

    public static int[] convertToIntArray(List<String> inputList){
        int[] arrayOfInts = new int[inputList.size()];
        int counter = 0;
        for( String s: inputList){
            arrayOfInts[counter++] = Integer.parseInt( s );
        }
        return  arrayOfInts;
    }
}
