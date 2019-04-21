import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpeningScreen {

    private JPanel openingPanel;
    private JButton btnStartServer;
    private JButton btnStopServer;
    private JTextArea consoleArea;
    private Server server;
//todo: openingscreen singleton maken? 1 instance overal hetzelfde?
    public OpeningScreen() {
        JFrame frame = new JFrame("Server onsDOMein");
        frame.setContentPane(openingPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(500,500);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.pack();
        centreWindow(frame);
        frame.setVisible(true);
        btnStartServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Start server by creating an instance of Server, if an instance already exists it will be overwritten
                server = new Server();
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

    public void getData(ScreenLogRep data) {
        data.setConsoleAreaText(consoleArea.getText());
    }

    //TODO: deze methode is alleen handig als we de textarea openzetten voor de gebruiker om in te voeren.
    public boolean isModified(ScreenLogRep data) {
        if (consoleArea.getText() != null ? !consoleArea.getText().equals(data.getConsoleAreaText()) : data.getConsoleAreaText() != null)
            return true;
        return false;
    }
}
