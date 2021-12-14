import java.util.List;

public class Task5 {

    public static void main( String[] args ) {
        List<String> dataReadings = Utils.readFromFile( "dataReadings.txt" );

        String gamma = "";
        String epsilon = "";

        int readingLength = dataReadings.get( 0 ).length();

        for(int i = 0; i< readingLength; i++) {
            int quantityOfOnes = 0;
            int quantityOfZeroes = 0;
            for ( String reading : dataReadings ) {
                if ( reading.substring( i, i + 1 ).equals( "0")){
                    quantityOfZeroes++;
                } else {
                    quantityOfOnes++;
                }
            }
            if ( quantityOfOnes > quantityOfZeroes ){
                gamma = gamma + "1";
                epsilon = epsilon + "0";
            }else {
                gamma = gamma + "0";
                epsilon = epsilon + "1";
            }
        }
        int gammaInt = Integer.parseInt(gamma, 2);
        int epnsilonInt = Integer.parseInt(epsilon, 2);
        System.out.println( gamma + " * "+ epsilon );
        System.out.println( gammaInt + " * "+ epnsilonInt );
        System.out.println( gammaInt * epnsilonInt );

    }

}
