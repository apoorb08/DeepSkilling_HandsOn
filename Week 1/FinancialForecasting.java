import java.util.HashMap;
import java.util.Map;

public class FinancialForecasting {

    // 1. Naive Recursive Implementation
    public static double calculateFutureValueRecursive(double presentValue, double growthRate, int periods) {
        System.out.println("Calculating for period: " + periods + "...");
        // Base Case: If there are no periods left, the value is the present value.
        if (periods == 0) {
            System.out.println("Base case reached.");
            return presentValue;
        }

        // Recursive Step: Calculate the value for the previous period and apply growth.
        double previousValue = calculateFutureValueRecursive(presentValue, growthRate, periods - 1);
        return previousValue * (1 + growthRate);
    }

    // 2. Optimized Recursive Implementation with Memoization
    public static double calculateFutureValueOptimized(double presentValue, double growthRate, int periods, Map<Integer, Double> memo) {
        // Check if the result for this period is already calculated
        if (memo.containsKey(periods)) {
            System.out.println("Returning memoized result for period: " + periods);
            return memo.get(periods);
        }
        
        System.out.println("Calculating for period: " + periods + "...");
        // Base Case: If there are no periods left, the value is the present value.
        if (periods == 0) {
            System.out.println("Base case reached.");
            return presentValue;
        }

        // Recursive Step:
        double previousValue = calculateFutureValueOptimized(presentValue, growthRate, periods - 1, memo);
        double futureValue = previousValue * (1 + growthRate);

        // Store the result in the memo before returning
        memo.put(periods, futureValue);
        System.out.println("Storing result for period " + periods + " in memo.");
        
        return futureValue;
    }

    public static void main(String[] args) {
        double initialInvestment = 1000.0;
        double annualGrowth = 0.08; // 8%
        int years = 5;

        System.out.println("--- Naive Recursive Calculation ---");
        double finalValueNaive = calculateFutureValueRecursive(initialInvestment, annualGrowth, years);
        System.out.printf("\nFinal Value after %d years (Naive): $%,.2f\n\n", years, finalValueNaive);

        System.out.println("\n--- Optimized Recursive Calculation with Memoization ---");
        // For this specific linear problem, memoization doesn't prevent re-calculations
        // because there are no overlapping subproblems, but it demonstrates the technique.
        Map<Integer, Double> memo = new HashMap<>();
        double finalValueOpt = calculateFutureValueOptimized(initialInvestment, annualGrowth, years, memo);
        System.out.printf("\nFinal Value after %d years (Optimized): $%,.2f\n", years, finalValueOpt);
    }
}
