import java.io.FileNotFoundException;

public class TestMain {
    public static void main(String[] args) {
        ReadWriteToFile readWriteToFile = new ReadWriteToFile();

//        try {
//            readWriteToFile.writeToFile("5678", ConfigOrState.CONFIG, "testConfiguratie2");
//        } catch (FileNotFoundException f) {
//            System.out.println("das k*t, fileNotFound: " + f);
//        }
//        try {
//            String config = readWriteToFile.readFromFile("5678",ConfigOrState.CONFIG);
//
//            System.out.println(config);
//        } catch (FileNotFoundException f) {
//            System.out.println("das k*t, fileNotFound: " + f);
//        }
        try {
            readWriteToFile.testMainTester();
        } finally {
            System.out.println("einde main");
        }

    }
}
