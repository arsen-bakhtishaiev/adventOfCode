import java.util.List;
import java.util.jar.JarEntry;

public class Task17 {

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

        for ( int y = 0; y < heightMap.length; y++ ) {
            String lowPoints = "";
            String points = "";
            for ( int x = 0; x < heightMap[y].length; x++ ) {
                int leftValue = x - 1 < 0 ? 9 : heightMap[y][x - 1];
                int rightValue = x + 1 >= heightMap[y].length  ? 9 : heightMap[y][x + 1];
                int upValue = y - 1 < 0 ? 9 : heightMap[y-1][x];
                int downValue = y + 1 >= heightMap.length ? 9 : heightMap[y+1][x];
                if ( heightMap[y][x] < leftValue &
                        heightMap[y][x] < rightValue &
                        heightMap[y][x] < upValue &
                        heightMap[y][x] < downValue
                ){
                    sumOfLowPoints = sumOfLowPoints + heightMap[y][x] + 1 ;
                    lowPoints = lowPoints + heightMap[y][x];
                }
                points = points + heightMap[y][x];
            }
            System.out.println( points + " " + lowPoints );
        }

        System.out.println(sumOfLowPoints);

    }

}


