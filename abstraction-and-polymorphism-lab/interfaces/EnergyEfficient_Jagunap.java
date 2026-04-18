package interfaces;

public interface EnergyEfficient_Jagunap {
    int energyUsagePerTask();

    default void displayEnergyRating() {
        int usage = energyUsagePerTask();
        String rating;
        if (usage <= 5) {
            rating = "High Efficiency";
        } else if (usage <= 10) {
            rating = "Medium Efficiency";
        } else {
            rating = "Low Efficiency";
        }
        System.out.println("Energy Rating: " + rating + " (Usage: " + usage + " units)");
    }
}