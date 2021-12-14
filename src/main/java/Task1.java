import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Task1 {


    public static void main( String[] args ) {
        List<String> fileReadings = new ArrayList<>();
        try {
            URL resource = Task1.class.getResource( "depths.txt");
            fileReadings = Files.readAllLines( Paths.get(resource.toURI()) );
        } catch ( IOException | URISyntaxException e ) {
            e.printStackTrace();
        }

        int counter = 0;
        int previousDepth = Integer.parseInt( fileReadings.get( 0 ));

        for( String s : fileReadings ){
            int currentDepth = Integer.parseInt( s );
            if( currentDepth > previousDepth){
                counter++;
            }
            previousDepth = currentDepth;
        }

        System.out.println(counter);
    }

}
