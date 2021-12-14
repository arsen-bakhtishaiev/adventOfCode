import java.util.List;

public class Task27 {

    public static void main( String[] args ) {
//        List<String> linesList = Utils.readFromFile( "heightsSample.txt" );
        List<String> linesList = Utils.readFromFile( "heights.txt" );

        int sumOfLowPoints = 0;
        int[][] heightMap = new int[linesList.size()][linesList.get( 0 ).length()];
        for ( int counterOfLines = 0; counterOfLines < linesList.size(); counterOfLines++ ) {
            String string = linesList.get( counterOfLines );
            for ( int counter = 0; counter < string.length(); counter++ ) {
                heightMap[counterOfLines][counter] = Integer.parseInt( string.substring( counter, counter + 1 ) );
            }
        }

//        List<int[][]> lowPoint = new ArrayList<>();
//        Set<int[][]> point = new HashSet<>();
//        List<Integer> areas = new ArrayList<>();
//        for ( int y = 0; y < heightMap.length; y++ ) {
//            for ( int x = 0; x < heightMap[y].length; x++ ) {
//
//                }
//            }
//            System.out.println( points + " " + lowPoints );
//        }
//
//        System.out.println(sumOfLowPoints);

    }

}


