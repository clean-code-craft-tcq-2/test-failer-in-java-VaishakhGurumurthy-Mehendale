import java.sql.Array;
import java.util.Arrays;
import java.util.Random;

public class Alerter {
    static int alertFailureCount = 0;
    static boolean failureFlag;

    static int networkAlertStub(float celcius) {
        System.out.println("ALERT: Temperature is " + celcius + " celcius");
        int random = new Random().nextInt(2);
        // assuming random network response, return some value
        return new int[]{200,500}[random];
    }

    static void alertInCelcius(float farenheit) {
        float celcius = (farenheit - 32) * 5 / 9;
        int returnCode = networkAlertStub(celcius);
        if (returnCode != 200) {
            failureFlag = true;
            alertFailureCount += 1;
        }
    }
    public static void main(String[] args) {

        // Random number of function calls to test if failureCounts are tracked properly
        alertInCelcius(400.5f);
        alertInCelcius(303.6f);

        if(failureFlag)
            assert (alertFailureCount > 0);
        else
            assert (alertFailureCount == 0);
        System.out.printf("%d alerts failed.\n", alertFailureCount);



        //Test to check if networkStud returns expected set of values
        assert (Arrays.asList(200, 500).contains(networkAlertStub(100)));

        System.out.println("All is well (maybe!)\n");
    }
}
