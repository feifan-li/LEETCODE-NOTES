package OODesign.LC359LoggerRateLimiter;

import java.util.HashMap;

public class Logger {
    public HashMap<String,Integer> lastPrint;//lastest timestamp a msg got printed;

    public Logger() {
        lastPrint = new HashMap<>();
    }

    public boolean shouldPrintMessage(int ts, String message) {
        if(!lastPrint.containsKey(message) || ts-lastPrint.get(message)>=10){
            lastPrint.put(message,ts);
            return true;
        }
        return false;
    }
}