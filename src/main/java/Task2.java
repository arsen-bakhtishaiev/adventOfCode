import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Task2 {

    public static void main( String[] args ) {
        int[] readings = Utils.convertToIntArray( Utils.readFromFile( "depths.txt" ));

        int counter = 0;
        int previousMetric = readings[0] + readings[1] + readings[2];;

        for( int i = 0; i < readings.length - 2; i++ ){
            int currentMetric = readings[i] + readings[i+1] + readings[i+2];
            System.out.println(readings[i] + " " +  readings[i+1] + " " + readings[i+2] + ";" + currentMetric);
            if( currentMetric > previousMetric){
                counter++;
            }
            previousMetric = currentMetric;
        }

        System.out.println(counter);
    }


}
