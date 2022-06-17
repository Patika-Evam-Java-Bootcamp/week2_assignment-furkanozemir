package week2.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Response {

    private String timestamp;
    private String returnCode;

    public static String getNow() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yy HH:mm");
        return df.format(new Date());
    }

    public Response() {
    }

    public Response(String returnStatus) {
        this.timestamp = getNow();
        this.returnCode = returnStatus;
    }

    public String getReturnStatus() {
        return this.returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getTimestamp() {
        return getNow();
    }
}
