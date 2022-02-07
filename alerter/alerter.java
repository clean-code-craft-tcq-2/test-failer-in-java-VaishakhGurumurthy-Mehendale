import java.sql.Array;
import java.util.Arrays;
import java.util.Random;

public class Alerter {
    static int alertFailureCount = 0;

    //Stub to replicate real-time scenario: response can be anything in real-world
    static int networkAlertStub(float celcius) {
        System.out.println("ALERT: Temperature is " + celcius + " celcius");
        int random = new Random().nextInt(2);
        // assuming random network response, return some value
        return new int[]{200,500}[random];
    }
    
    //Stub to test fail condition
    static int networkAlertFailStub(float celcius) {
        return 500;
    }
    
    //Stub to test pass condition
    static int networkAlertPassStub(float celcius) {
        return 200;
    }
    
    //farenheit to celcius converter
    static int returnCelcius(float farenheit){
        return  (farenheit - 32) * 5 / 9;
    }

    
    static void alertInCelcius(float farenheit, String testTo) {
        float celcius = returnCelcius(farenheit);
        int responseCode = 0;
        
        if(testTo == "fail"){
            returnCode = networkAlertFailStub(celcius);
        }else if(testTo == "pass"){
            returnCode = networkAlertPassStub(celcius);
        }else{
            returnCode = networkAlertStub(celcius);
        }
        if (returnCode != 200) {
            alertFailureCount += 1;
        }
    }
    
    static void resetFailureCount(){
        
        alertFailureCount = 0;
        
    }
    
    
    public static void main(String[] args) {
        
        //Test to check converter
        assert(returnCelcius(30) == 86);

        // Test to check fail condition
        alertInCelcius(400.5f, "fail");
        assert (alertFailureCount == 1);
        
        alertInCelcius(303.6f, "fail");
        assert (alertFailureCount == 2);
        
        resetFailureCount();
        
        //test to check pass condition
        alertInCelcius(303.6f, "pass");
        assert (alertFailureCount == 0);
        
        System.out.printf("%d alerts failed.\n", alertFailureCount);


        //Test to check if networkStud returns expected set of values
        assert (Arrays.asList(200, 500).contains(networkAlertStub(100)));

        System.out.println("All is well (maybe!)\n");
    }
}
