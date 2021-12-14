import java.util.Arrays;
import java.util.List;

public class Task15 {

    public static void main( String[] args ) {
//        List<String> linesList = Utils.readFromFile( "7digistsSample.txt" );
        List<String> linesList = Utils.readFromFile( "7digists.txt" );

        int counterOfUnique = 0;

        for ( int counter = 0; counter < linesList.size(); counter++ ) {
            String substring = linesList.get( counter ).split( "\\|" )[1];
            String[] digits = substring.split( " " );
            for ( String digit: digits
                   ) {
                if( digit.length() == 2
                        || digit.length() == 4
                        || digit.length() == 3
                        || digit.length() == 7
                ){
                    counterOfUnique ++;
                }
            }
        }

        System.out.println(counterOfUnique);

    }

}


