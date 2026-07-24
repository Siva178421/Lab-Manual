class ParkingSystem {
    // Array to hold capacities for big (index 1), medium (index 2), and small (index 3)
    private int[] slots;

    public ParkingSystem(int big, int medium, int small) {
        // Size 4 array allows direct 1-based indexing matching the carType values
        this.slots = new int[]{0, big, medium, small};
    }
    
    public boolean addCar(int carType) {
        // If slots are available for the specific car type, decrement and return true
        if (this.slots[carType] > 0) {
            this.slots[carType]--;
            return true;
        }
        return false;
    }
}
