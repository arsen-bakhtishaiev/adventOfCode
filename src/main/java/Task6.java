import java.util.List;
import java.util.stream.Collectors;

public class Task6 {

    public static void main( String[] args ) {
        List<String> dataReadings = Utils.readFromFile( "dataReadings.txt" );

        int readingLength = dataReadings.get( 0 ).length();

        String oxygenGenerator = "";
        String co2Scrubber = "";

        List<String> filteredForOxygen = dataReadings;
        for(int i = 0; i < readingLength; i++){
            String mostCommonValue = findMostCommontValue( filteredForOxygen, i );
            int finalI = i;
            filteredForOxygen = filteredForOxygen.stream().filter( reading -> reading.substring( finalI, finalI + 1 ).equals( mostCommonValue ) ).collect( Collectors.toList());
            if ( filteredForOxygen.size() == 1 ){
                oxygenGenerator = filteredForOxygen.get( 0 ).toString();
                break;
            }
        }

        List<String> filteredForCO2 = dataReadings;
        for(int i = 0; i < readingLength; i++){
            String leastCommonValue = findLeastCommonValue( filteredForCO2, i );
            int finalI = i;
            filteredForCO2 = filteredForCO2.stream().filter( reading -> reading.substring( finalI, finalI + 1 ).equals( leastCommonValue ) ).collect( Collectors.toList());
            if(filteredForCO2.size()==1){
                co2Scrubber = filteredForCO2.get( 0 ).toString();
                break;
            }
        }

        int oxygenGeneratorInt = Integer.parseInt( oxygenGenerator, 2 );
        int co2ScrubberInt = Integer.parseInt( co2Scrubber, 2 );

        System.out.println( oxygenGenerator + " " + oxygenGeneratorInt );
        System.out.println( co2Scrubber + " " + co2ScrubberInt );
        System.out.println( oxygenGeneratorInt * co2ScrubberInt );

    }

    public static String findMostCommontValue(List<String> readings, int position){
        String gamma = "";

        int readingLength = readings.get( 0 ).length();

            int quantityOfOnes = 0;
            int quantityOfZeroes = 0;
            for ( String reading : readings ) {
                if ( reading.substring( position, position + 1 ).equals( "0")){
                    quantityOfZeroes++;
                } else {
                    quantityOfOnes++;
                }
            }
        return quantityOfOnes >= quantityOfZeroes ? "1" : "0";
    }

    public static String findLeastCommonValue(List<String> readings, int position){
        String epsilon = "";

        int readingLength = readings.get( 0 ).length();

            int quantityOfOnes = 0;
            int quantityOfZeroes = 0;
            for ( String reading : readings ) {
                if ( reading.substring( position, position + 1 ).equals( "0")){
                    quantityOfZeroes++;
                } else {
                    quantityOfOnes++;
                }
            }
        return quantityOfZeroes <= quantityOfOnes ? "0": "1";
    }

}
