import java.sql.Time;
import java.sql.Timestamp;
import java.util.Scanner;

public class Main {
    //TODO: deze regel code starten bij drukken op knop 'start server'.
    public static void main(String[] args) {
//        ScreenLogRep screenLogRep = ScreenLogRep.getScreenLogRep();
//        Server server = new Server();// deze met openingscherm gaat goed, alleen heeft de knop geen nut en als je daar op drukt gaat het alsnog mis.
        OpeningScreen openingScreen = new OpeningScreen(); // alleen deze lijn actief: opent na druk op start server een tweede lege scherm, andere
        //instance, dus gegevens gaan verloren. Openingscherm singleton maken??
        //TODO: GUI hier starten
//        Scanner in = new Scanner(System.in);
        // starten met een instance van ScreenLogRep, in deze class wordt het openingscherm gestart
        // Hierdoor hoeft bij een nieuwe logging alleen de singleton ScreenlogRep als instance worden gebruikt in de aanroepende class
        // het verversen van het scherm gaat dan via de singleton
//        ScreenLogRep screenLogRep = ScreenLogRep.getScreenLogRep();
//        while (true) {
//            System.out.println("Print iets in het textarea veld:\n");
//            if (in.hasNext()) {
//                screenLogRep.setConsoleAreaText(in.nextLine());
////                openingScreen.setData(screenLogRep);
//            }
//        }
    }

}
