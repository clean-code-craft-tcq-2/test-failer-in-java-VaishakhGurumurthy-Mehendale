import java.util.*;
public class Tshirts {

    static Map<String, List<Integer>> sizeMap = new HashMap<String, List<Integer>>();
    static {
        sizeMap.put("XS", Arrays.asList(22, 23, 24, 25, 26, 27, 28));
        sizeMap.put("S", Arrays.asList(29, 30, 31, 32));
        sizeMap.put("M", Arrays.asList(33, 34, 35, 36, 37, 38));
        sizeMap.put("L", Arrays.asList(39, 40, 41, 42));
        sizeMap.put("XL", Arrays.asList(43, 44, 45, 46, 47, 48));
    }

    static String size(int cms) {
        if(cms > 21 && cms <= 28 ) {
            return "XS";
        } else if(cms > 28 && cms <= 32) {
            return "S";
        } else if(cms >32 && cms <= 38){
            return "M";
        }else if(cms > 38 && cms <= 42){
            return "L";
        }else if(cms > 42 && cms <=48 ){
            return "XL";
        }else{
            return "Invalid";
        }
    }



    public static void main(String[] args) {


        //Test to cover all possible test values
        for(int textSize=0; textSize<100; textSize++){

            if(textSize<22 || textSize>48){
                assert(size(textSize).equals("Invalid"));
            }else {
                assert (sizeMap.get(size(textSize)).contains(textSize));
            }

        }

        System.out.println("All is well (maybe!)");
    }

}
