import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task11 {

    public static void main( String[] args ) {
        List<String> linesList = Utils.readFromFile( "lanternFishSample.txt" );
//        List<String> linesList = Utils.readFromFile( "lanternFish.txt" );

        List<Integer> lanternFishSchool = new ArrayList<>();
        for ( String s : linesList.get( 0 ).split( "," ) ) {
            lanternFishSchool.add( Integer.parseInt( s ) );
        }

        int days = 80;
        int counterOfDesc = 0;

        for(int currentFishId = 0; currentFishId < lanternFishSchool.size(); currentFishId++){
            List<Integer> descendants = new ArrayList<>();
            descendants.add( lanternFishSchool.get( currentFishId ) );
            for(int day=0; day < days; day++){
               // System.out.println(descendants);
                for ( int currentDesc = 0; currentDesc < descendants.size(); currentDesc++ ){
                    if ( descendants.get( currentDesc ) == 0 ){
                        descendants.set( currentDesc, 6 );
                        descendants.add( 9 );
                    }else {
                        descendants.set( currentDesc, descendants.get( currentDesc ) - 1 );
                    }
                }
            }
            counterOfDesc = descendants.size() + counterOfDesc;
        }

        System.out.println( linesList );
        System.out.println( counterOfDesc );
    }
}


