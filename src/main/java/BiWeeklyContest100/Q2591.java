package BiWeeklyContest100;

public class Q2591 {
    public int distMoney(int money, int children) {
        // If children > money -> that means cannot give at least one money to every child, return -1
        if (money < children) return -1;
        // If money > children * 8 -> that means that all of the children can have 8 dollar, but one of them need to accept more dollar, so need to -1
        if (money > 8 * children) return children - 1;
        // Ensure at least all child have 1 dollar
        money -= children;
        // figure out how many children can have 8 dollar
        int result = money / 7;
        // find out whether money left after spliting all the 8 dollar to children
        int remainder = money % 7;
        // avoid 4 dollar
        if (remainder == 3 && result + 1 == children) return result - 1;
        return result;
    }
}
