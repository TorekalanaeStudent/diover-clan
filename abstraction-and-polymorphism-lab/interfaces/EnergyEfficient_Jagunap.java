package interfaces;

/**
 * Energy behavior contract for devices.
 */
public interface EnergyEfficient_Jagunap {

    // =========================
    // Abstract Method
    // =========================
    int energyUsagePerTask();

    // =========================
    // Default Method
    // =========================
    default void displayEnergyRating() {
        int usage = energyUsagePerTask();

        if (usage <= 5) {
            System.out.println("Energy Rating: ★★★★★ (Excellent)");
        } else if (usage <= 10) {
            System.out.println("Energy Rating: ★★★★☆ (Good)");
        } else {
            System.out.println("Energy Rating: ★★☆☆☆ (Poor)");
        }
    }
}
