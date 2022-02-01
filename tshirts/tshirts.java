public class Tshirts {
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
            return "Size not available";
        }
    }

    public static void main(String[] args) { 
        assert(size(22) == "XS");
        assert(size(32) == "S");
        assert(size(38) == "M");
        assert(size(42) == "L");
        assert(size(48) == "XL");
        assert(size(49) == "Size not available");
        System.out.println("All is well (maybe!)");
    }
}
