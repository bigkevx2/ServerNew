import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConfigStateRep implements Serializable {
    // Create an instance of itself
    private static ConfigStateRep configStateRep = new ConfigStateRep();
    // the configurations repository
    private Map<String, String> configurations;
    // the state repository
    private Map<String, String> states;
    private Lock repositoryLock = new ReentrantLock();
    private
    ReadWriteToFile readWriteToFile = new ReadWriteToFile();

    /**
     * private constructor so no other object can instantiate.
     * While constructing this Singleton read configurations and states from file or create them if no file present.
     */
    private ConfigStateRep() {
        try {
            configurations = readWriteToFile.readFromFile("configurations.dat");

        } catch (IOException | ClassNotFoundException ex) {
            configurations = new HashMap<>();
        }
        try {
            states = readWriteToFile.readFromFile("states.dat");

        } catch (IOException | ClassNotFoundException ex) {
            states = new HashMap<>();
        }
    }

    /**
     * Static method to get this instance
     * @return this instance
     */
    static ConfigStateRep getConfigStateRep() {
        return configStateRep;
    }

    /**
     * Method to get a hc configuration from the repository
     * @param hc, the hc_id
     * @return String with configuration of hc or NULL
     */
    public String getConfiguration(String hc) {
        String config;
        repositoryLock.lock();
        try {
            config = configurations.get(hc);
        } finally {
            repositoryLock.unlock();
        }
        return config;
    }

    /**
     * Method to save a hc configuration to the repository
     * @param hc, the hc_id
     * @param configuration, the configuration String with parameters.
     * @return confirmation of save
     */
    public String setConfiguration(String hc, String configuration) {
        String response;
        repositoryLock.lock();
        try {
            configurations.put(hc,configuration);
            response = "setConfigOK";
        } catch (Exception e) {
            response = "setConfigNOK";
        } finally {
            repositoryLock.unlock();
        }
        return response;
    }

    /**
     * Method to get the state from the repository
     * @param hc, the hc_id
     * @return String with the state of the hc or NULL
     */
    public String getState(String hc) {
        String state;
        repositoryLock.lock();
        try {
            state = states.get(hc);
        } finally {
            repositoryLock.unlock();
        }
        return state;
    }

    /**
     * Method to save a hc state to the repository
     * @param hc, the hc_id
     * @param state, the state String with parameters.
     * @return confirmation of save
     */
    public String setState(String hc, String state) {
        repositoryLock.lock();
        try {
            states.put(hc,state);
        } finally {
            repositoryLock.unlock();
        }
        return "setStateOK";
    }

    public void saveConfigs() {
        try {
            readWriteToFile.writeToFile(configurations, "configurations.dat");
        } catch (IOException e) {
            System.out.println("saveConfigs gaat fout: " + e);
        }
    }

    public void saveStates() {
        try {
            readWriteToFile.writeToFile(states, "states.dat");
        } catch (IOException e) {
            System.out.println("saveStates gaat fout: " + e);
        }
    }

    public Map getConfigurations() {
        return this.configurations;
    }

    public void setConfigurations(Map<String, String> configReppository) {
        this.configurations = configReppository;
    }

    public Map getStates() {
        return this.states;
    }

    public void setStates(Map<String, String> stateRepository) {
        this.states = stateRepository;
    }
}
