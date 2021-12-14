import java.util.Arrays;
import java.util.List;

public class Task14 {

    public static void main( String[] args ) {
//        List<String> linesList = Utils.readFromFile( "whalesSample.txt" );
        List<String> linesList = Utils.readFromFile( "whales.txt" );

        String[] positionsString = linesList.get( 0 ).split( "," );
        int[] positions = new int[positionsString.length];
        for ( int i = 0; i < positionsString.length; i++ ) {
            positions[i] = Integer.parseInt( positionsString[i] );
        }

        int maxValue = Arrays.stream( positions ).reduce( Integer::max ).getAsInt();

        int[]fuelCost = new int[maxValue + 1];

        for ( int endPosition = 0; endPosition <= maxValue; endPosition++ ) {
            int currentFuelCost = 0;
            for ( int positionIndex = 0; positionIndex < positions.length; positionIndex++ ) {
                currentFuelCost = currentFuelCost + arithmProgr( Math.abs( endPosition - positions[positionIndex] ) );
            }
            fuelCost[endPosition] = currentFuelCost;
        }

        int optimalCost = Arrays.stream( fuelCost ).reduce( Integer::min ).getAsInt();

        System.out.println(optimalCost);

    }

    private static int arithmProgr(int shift){
        return shift *(1+shift) / 2;
    }
}


