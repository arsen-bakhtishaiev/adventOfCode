import java.util.ArrayList;
import java.util.List;

public class Task12 {

    public static void main( String[] args ) {
//        List<String> linesList = Utils.readFromFile( "lanternFishSample.txt" );
        List<String> linesList = Utils.readFromFile( "lanternFish.txt" );

        List<Integer> lanternFishSchool = new ArrayList<>();
        for ( String s : linesList.get( 0 ).split( "," ) ) {
            lanternFishSchool.add( Integer.parseInt( s ) );
        }

        int days = 256;
        long counterOfDesc = 0;

        for(int currentFishId = 0; currentFishId < lanternFishSchool.size(); currentFishId++){
            long[] schoolState = new long[]{ 0,0,0,0,0,0,0,0,0 };
            schoolState[ lanternFishSchool.get( currentFishId ) ] = 1;
            for(int day=0; day < days; day++){
                long buffer = schoolState[0];
                schoolState[0] = schoolState[1];
                schoolState[1] = schoolState[2];
                schoolState[2] = schoolState[3];
                schoolState[3] = schoolState[4];
                schoolState[4] = schoolState[5];
                schoolState[5] = schoolState[6];
                schoolState[6] = schoolState[7]+ buffer;
                schoolState[7] = schoolState[8];
                schoolState[8] = buffer;
            }
            for ( int i = 0; i < 9; i++ ) {
                counterOfDesc = counterOfDesc + schoolState[i];
            }
        }

        System.out.println( linesList );
        System.out.println( counterOfDesc );
    }
}


