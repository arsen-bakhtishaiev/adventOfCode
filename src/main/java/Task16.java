import java.util.*;

public class Task16 {

    public static void main( String[] args ) {
//        List<String> linesList = Utils.readFromFile( "7digistsSample.txt" );
        List<String> linesList = Utils.readFromFile( "7digists.txt" );

        int sum = 0;
        for ( String dataLine: linesList ){
            String codes = dataLine.split( "\\|" )[0];
            String data = dataLine.split( "\\|" )[1];
            Map<String, String> codeMap = decodeString( codes );
            String[] digits = data.split( " " );
            String valueString = "";
            for ( int counter = 0; counter < digits.length; counter++ ) {
                valueString =  valueString + findDigit( digits[counter], codeMap );
            }

            System.out.println(valueString);
            sum = sum + Integer.parseInt( valueString );
        }

        System.out.println(sum);

    }

    public static String findDigit(String valueString, Map<String, String> codeMap){
        String value = "0";

        switch ( valueString.length() ) {
            case 2:
                return "1";
            case 4:
                return "4";
            case 3:
                return "7";
            case 7:
                return "8";
        }

        Set<Character> valueChars = stringToCharacterSet( valueString );
        for ( String key: codeMap.keySet() ) {
            if(stringToCharacterSet( key ).containsAll( valueChars ) & key.length() == valueString.length() ){
                return codeMap.get( key );
            }
        }
//
//
//        if ( valueString.length() == 5 ){
//            Set<Character> value2 = stringToCharacterSet( codeMap.get( "2" ) );
//            Set<Character> value3 = stringToCharacterSet( codeMap.get( "3" ) );
//            Set<Character> value5 = stringToCharacterSet( codeMap.get( "5" ) );
//
//            if ( valueChars.containsAll( value2 ) ){
//                return "2";
//            } else if(valueChars.containsAll( value3 ) ){
//                return "3";
//            } else if(valueChars.containsAll( value5 ) ){
//                return "5";
//            };
//        }
//
//        if ( valueString.length() == 6 ){
//            Set<Character> value6 = stringToCharacterSet( codeMap.get( "6" ) );
//            Set<Character> value8 = stringToCharacterSet( codeMap.get( "8" ) );
//            Set<Character> value0 = stringToCharacterSet( codeMap.get( "0" ) );
//
//            if ( valueChars.containsAll( value6 ) ){
//                return "6";
//            } else if(valueChars.containsAll( value8 ) ){
//                return "8";
//            } else if(valueChars.containsAll( value0 ) ){
//                return "0";
//            };
//        }

        return value;
    }

    public static Set<Character> stringToCharacterSet(String string){
        Set<Character> set = new HashSet<>();
        for( char c : string.toCharArray()){
            set.add( c );
        }
        return set;
    }

    public static Map<String, String> decodeString(String codeString){
        Map<String, String> codeMap = new HashMap<>();
        Map<String, String> reverseMap = new HashMap<>();

        String[] codes = codeString.split( " " );
        String[] codes5 = new String[3];
        String[] codes6 = new String[3];
        int code5Counter = 0;
        int code6Counter = 0;
        for ( String code : codes ){
            switch ( code.length() ) {
                case 2: codeMap.put( code, "1" );
                    reverseMap.put("1", code);
                    break;
                case 4: codeMap.put( code, "4" );
                    reverseMap.put("4", code);
                    break;
                case 5: codes5[code5Counter++] = code;
                    break;
                case 3: codeMap.put( code, "7" );
                    reverseMap.put("7", code);
                    break;
                case 6: codes6[code6Counter++] = code;
                    break;
                case 7: codeMap.put( code, "8" );
                    reverseMap.put("8", code);
                    break;
            }
        }

        //3
        for(String code5: codes5){
            Set<String> elementsSet = new HashSet<>();
            for ( int characterCounter = 0; characterCounter < code5.length(); characterCounter++ ) {
                elementsSet.add( code5.substring( characterCounter, characterCounter +  1 ) );
            }
            for ( int characterCounter = 0; characterCounter < 2; characterCounter++ ) {
                elementsSet.add( reverseMap.get( "1" ).substring( characterCounter, characterCounter + 1 ) );
            }
            if ( elementsSet.size() == 5 ){
                codeMap.put( code5, "3" );
                reverseMap.put( "3", code5 );
                break;
            }
        }
        //2, 5
        for(String code5: codes5){
            Set<String> elementsSet = new HashSet<>();
            for ( int characterCounter = 0; characterCounter < code5.length(); characterCounter++ ) {
                elementsSet.add( code5.substring( characterCounter, characterCounter +  1 ) );
            }
            for ( int characterCounter = 0; characterCounter < 4; characterCounter++ ) {
                elementsSet.add( reverseMap.get( "4" ).substring( characterCounter, characterCounter + 1 ) );
            }
            if ( elementsSet.size() == 7 ){
                codeMap.put( code5, "2" );
                reverseMap.put( "2", code5 );
            }else if (code5 != reverseMap.get( "3" ) & elementsSet.size() != 7){
                codeMap.put( code5, "5" );
                reverseMap.put( "5", code5 );
            }
        }
        //6
        for(String code6: codes6){
            Set<String> elementsSet = new HashSet<>();
            for ( int characterCounter = 0; characterCounter < code6.length(); characterCounter++ ) {
                elementsSet.add( code6.substring( characterCounter, characterCounter +  1 ) );
            }
            for ( int characterCounter = 0; characterCounter < 2; characterCounter++ ) {
                elementsSet.add( reverseMap.get( "1" ).substring( characterCounter, characterCounter + 1 ) );
            }
            if ( elementsSet.size() == 7 ){
                codeMap.put( code6, "6" );
                reverseMap.put( "6", code6 );
                break;
            }
        }

        //0,9
        for(String code6: codes6){
            Set<String> elementsSet = new HashSet<>();
            for ( int characterCounter = 0; characterCounter < code6.length(); characterCounter++ ) {
                elementsSet.add( code6.substring( characterCounter, characterCounter +  1 ) );
            }
            for ( int characterCounter = 0; characterCounter < 5; characterCounter++ ) {
                elementsSet.add( reverseMap.get( "5" ).substring( characterCounter, characterCounter + 1 ) );
            }
            if ( elementsSet.size() == 7 &  code6 != reverseMap.get( "6" ) ){
                codeMap.put( code6, "0" );
                reverseMap.put( "0", code6 );
                continue;
            }else if( code6 != reverseMap.get( "6" ) & elementsSet.size() != 7){
                codeMap.put( code6, "9" );
                reverseMap.put( "9", code6 );
            }
        }

        return codeMap;
    }

}


