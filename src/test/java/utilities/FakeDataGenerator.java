package utilities;

import io.codearte.jfairy.Fairy;

import java.util.Calendar;
import java.util.HashMap;

public class FakeDataGenerator {
    private static final Fairy fairy;
    private static final String validUsername;
    private static final String validPassword;

    static {
        fairy = Fairy.create();
        validUsername = fairy.person().getUsername();
        validPassword = fairy.person().getPassword();
    }

    public String getValidUsername() {
        return validUsername;
    }

    public String getValidPassword() { return validPassword; }

    public String getAnyUsername(){
        return fairy.person().getUsername();
    }

    public String getAnyPassword() {
        return fairy.person().getPassword();
    }

    public HashMap<String, String> getPlaceOrderData() {
        HashMap<String, String> data = new HashMap<>();
        data.put("NAME", fairy.person().getFullName());
        data.put("COUNTRY", PropertyReader.getData("PLACE.ORDER.COUNTRY"));
        data.put("CITY", PropertyReader.getData("PLACE.ORDER.CITY"));
        data.put("CARD", String.valueOf(fairy.creditCard().hashCode()));
        data.put("MONTH", String.valueOf(Calendar.getInstance().get(Calendar.MONTH)));
        data.put("YEAR", String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
        return data;
    }
}
