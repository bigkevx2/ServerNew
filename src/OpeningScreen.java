import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpeningScreen {

    private JPanel openingPanel;
    private JButton btnStopServer;
    private JTextArea consoleArea;

    public OpeningScreen() {
        JFrame frame = new JFrame("Server onsDOMein");
        frame.setContentPane(openingPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1000, 1000));
        frame.pack();
        centreWindow(frame);
        frame.setVisible(true);
        btnStopServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
    }

    private void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x,y);
    }

    //TODO: three methods added by dataBinding wizard
    public void setData(ScreenLogRep data) {
        consoleArea.setText(data.getConsoleAreaText());

    }

//    public void getData(ScreenLogRep data) {
//        data.setConsoleAreaText(consoleArea.getText());
//    }
//
//    //TODO: deze methode is alleen handig als we de textarea openzetten voor de gebruiker om in te voeren.
//    public boolean isModified(ScreenLogRep data) {
//        if (consoleArea.getText() != null ? !consoleArea.getText().equals(data.getConsoleAreaText()) : data.getConsoleAreaText() != null)
//            return true;
//        return false;
//    }
}
