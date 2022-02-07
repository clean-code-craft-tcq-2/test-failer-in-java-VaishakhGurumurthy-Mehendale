public class Misaligned {
    static String majorColors[] = {"White", "Red", "Black", "Yellow", "Violet"};
    static String minorColors[] = {"Blue", "Orange", "Green", "Brown", "Slate"};
    static String colorMap = new String();
    static String printColorMap() {

        int i = 0, j = 0;
        for(i = 0; i < 5; i++) {
            for(j = 0; j < 5; j++) {
                colorMap += i * 5 + j +1 +","+majorColors[i]+","+minorColors[i]+"\n";
            }
        }

        System.out.println(colorMap);
        return colorMap;
    }
    public static void main(String[] args) { 
        String colorMap = printColorMap();
        int result = colorMap.split("\n").length;

        assert(result == 25);
        assert("1,White,Blue".equals(colorMap.split("\n")[0]));

        System.out.println("All is well (maybe!)");
    }
}
