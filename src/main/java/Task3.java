import java.util.List;
import java.util.Map;

public class Task3 {

    public static void main( String[] args ) {
        List<String> directions = Utils.readFromFile( "directions.txt" );

        int depth = 0;
        int horizontal = 0;

        for( String direction: directions){
            int shift = Integer.parseInt( direction.split( " " )[1]);
            if(direction.contains("down")){
                depth = depth + shift;
            }else if(direction.contains("up")){
                depth = depth - shift;
            }else if(direction.contains("forward")){
                horizontal = horizontal + shift;
            }
        }

        System.out.println( depth * horizontal);
    }

}
