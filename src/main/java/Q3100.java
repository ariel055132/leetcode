public class Q3100 {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int maximumBottles = numBottles;
        int drunkBottles = numBottles; // Drink any number of full water bottles turning them into empty bottles
        while (drunkBottles >= numExchange) {
            drunkBottles -= numExchange; // Exchange numExchange empty bottles with one full water bottle
            numExchange++; // increase numExchange by one
            maximumBottles++; // Because get one full water bottle at the code above, increment them
            drunkBottles++; // drunkBottles ++
        }
        return maximumBottles;
    }
}
