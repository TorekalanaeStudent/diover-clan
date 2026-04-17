package interfaces;

/**
 * @author Onte, Vince Gian D.
 * @vinceonte
 */

public interface DeviceSystem_Onte {

    // Abstract method
    void syncData(String device);

    // Default method
    default void autoBackup() {
        System.out.println("Data automatically backed up to cloud.");
    }
}