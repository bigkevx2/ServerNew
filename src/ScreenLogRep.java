import java.io.PrintWriter;
import java.io.StringReader;
import java.security.PrivateKey;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.sql.Timestamp;

/**
 * Singleton class to collect Console output to show in the homeschreen of the server
 */
public class ScreenLogRep {
    private static ScreenLogRep screenLogRep = new ScreenLogRep();
    private Queue<String> screenLogQue = new LinkedList<>();
    private Lock repositoryLock = new ReentrantLock();
    private String consoleAreaText;
    private OpeningScreen openingScreen = new OpeningScreen();

    /**
     * Private constructor so no other class can instantiate
     */
    private ScreenLogRep(){
    }

    static ScreenLogRep getScreenLogRep() {
        return screenLogRep;
    }

//TODO: two methods added by dataBinding wizard
    public String getConsoleAreaText() {
        //TODO: moet deze threadlock krijgen?
        StringBuilder string = new StringBuilder();
        consoleAreaText = "";
        for (String text : screenLogQue) {
            string.append(text);
            string.append("\n");
            consoleAreaText = string.toString();
        }
        return consoleAreaText;
    }

    public void setConsoleAreaText(final String consoleAreaText) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        //TODO: deze moet nog threadlock krijgen
        if (screenLogQue.size() == 5) {
            screenLogQue.add(timestamp + consoleAreaText);
            screenLogQue.remove();
        } else {
            screenLogQue.add(timestamp + ": " + consoleAreaText);
        }
        //TODO deze aanroep zorgt ervoor dat we een OpeningScreen instance moeten maken hier, dit veroorzaakt waarschijnlijk het probleem
        // als we de server creeeren als we dit via de button action listener starten.
        openingScreen.setData(this);
    }
}
