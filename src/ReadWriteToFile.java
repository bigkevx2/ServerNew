import java.io.*;
import java.util.Map;
import java.util.Scanner;

public class ReadWriteToFile {

    ReadWriteToFile() {
    }

    /**
     * txt read
     * @param file
     * @param kind
     * @return
     * @throws FileNotFoundException
     */
    public String readFromFile(String file, ConfigOrState kind) throws FileNotFoundException {
        String config = "";
        Scanner in = new Scanner(new File(kind + file + ".txt"));
        while (in.hasNext()) {
            config = in.nextLine();
        }
        in.close();
        return config;
    }

    /**
     * txt write
     * @param hc
     * @param kind
     * @param config
     * @throws FileNotFoundException
     */
    public void writeToFile(String hc, ConfigOrState kind, String config) throws FileNotFoundException{
        PrintWriter out = new PrintWriter(new File(kind + hc + ".txt"));
        out.println(config);
        out.close();
    }

    public void writeToFile(Map stateMap, String fileName) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
        out.writeObject(stateMap);
        out.close();
    }

    public Map<String, String> readFromFile(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
        Map<String, String> map = (Map<String, String>) in.readObject();
        in.close();
        return map;
    }

    public void testMainTester() {
        System.out.println("even testen");
    }

}
