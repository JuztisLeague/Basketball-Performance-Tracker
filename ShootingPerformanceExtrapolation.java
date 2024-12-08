package zznumericalMethodstrial;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShootingPerformanceExtrapolation {

    // Class to store shooting data for a single data point
    static class ShootingData {
        int skillLevel; // Skill level associated with this data point
        double shotsMade; // Number of shots made
        double percentage; // Shooting percentage for this data point
    }

    // Class to store training session data for a specific skill level
    static class TrainingSession {
        int level; // Skill level of the session
        List<ShootingData> data; // List of shooting data points for this skill level
        int totalAttempts; // Total attempts available for this skill level

        // Constructor to initialize the training session
        public TrainingSession(int level, int totalAttempts) {
            this.level = level;
            this.totalAttempts = totalAttempts;
            this.data = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<TrainingSession> trainingData = new ArrayList<>();
        initializeSkillLevels(trainingData); // Set up initial skill levels and their total attempts

        while (true) {
            // Main menu
            System.out.println("\n=== Shooting Performance Extrapolation ===");
            System.out.println("1. Enter Shooting Data");
            System.out.println("2. View Progress");
            System.out.println("3. Perform Extrapolation");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            // Handle user choice
            switch (choice) {
                case 1:
                    enterShootingData(scanner, trainingData); // Add shooting data
                    break;
                case 2:
                    viewProgress(trainingData); // View current training progress
                    break;
                case 3:
                    performExtrapolation(scanner, trainingData); // Perform extrapolation
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return; // Exit the program
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    // Initialize skill levels with predefined total attempts
    public static void initializeSkillLevels(List<TrainingSession> trainingData) {
        trainingData.add(new TrainingSession(1, 10)); // Level 1: 10 attempts
        trainingData.add(new TrainingSession(2, 25)); // Level 2: 25 attempts
        trainingData.add(new TrainingSession(3, 50)); // Level 3: 50 attempts
    }

    // Enter shooting data for a specific skill level
    public static void enterShootingData(Scanner scanner, List<TrainingSession> trainingData) {
        System.out.print("Enter skill level (1-3): ");
        int skillLevel = scanner.nextInt();

        // Validate skill level
        if (skillLevel < 1 || skillLevel > 3) {
            System.out.println("Invalid skill level. Must be between 1 and 3.");
            return;
        }

        TrainingSession session = trainingData.get(skillLevel - 1);
        System.out.println("Skill Level " + skillLevel + " - Total Attempts: " + session.totalAttempts);
        System.out.print("Enter the number of data points to add: ");
        int n = scanner.nextInt();

        // Add new data points for this skill level
        for (int i = 0; i < n; i++) {
            ShootingData data = new ShootingData();
            data.skillLevel = skillLevel;
            System.out.print("Shots Made [" + (i + 1) + "]: ");
            data.shotsMade = scanner.nextDouble();
            // Calculate shooting percentage
            data.percentage = (data.shotsMade / session.totalAttempts) * 100;
            System.out.printf("Shooting Percentage: %.1f%%%n", data.percentage);
            session.data.add(data); // Add data to the session
        }

        System.out.println("Shooting data saved for Level " + skillLevel + ".");
    }

    // View training progress for all skill levels
    public static void viewProgress(List<TrainingSession> trainingData) {
        System.out.println("\n=== Training Progress ===");
        for (TrainingSession session : trainingData) {
            System.out.println("Skill Level " + session.level + " Progress:");
            for (ShootingData data : session.data) {
                // Display details for each data point
                System.out.printf("  Shots Made: %.1f/%d, Shooting Percentage: %.1f%%%n",
                        data.shotsMade, session.totalAttempts, data.percentage);
            }
        }
    }

    // Perform extrapolation based on user input and training data
    public static void performExtrapolation(Scanner scanner, List<TrainingSession> trainingData) {
        System.out.print("Select skill level for extrapolation (1-3): ");
        int skillLevel = scanner.nextInt();

        // Validate skill level
        if (skillLevel < 1 || skillLevel > 3) {
            System.out.println("Invalid skill level. Must be between 1 and 3.");
            return;
        }

        TrainingSession session = trainingData.get(skillLevel - 1);
        if (session.data.isEmpty()) {
            System.out.println("No data available for extrapolation. Please enter data first.");
            return;
        }

        System.out.print("Enter the number of shots made to extrapolate: ");
        double shotsToExtrapolate = scanner.nextDouble();

        // Determine number of points to use (up to 10, or all available points if less than 10)
        int dataSize = session.data.size();
        int pointsToUse = Math.min(10, dataSize);   //if the number of data points is less than 10, it uses all available data points
        double[] shotsMade = new double[pointsToUse];
        double[] percentages = new double[pointsToUse];

        // Extract the latest points for extrapolation (10 most recent data points)
        for (int i = 0; i < pointsToUse; i++) {
            ShootingData data = session.data.get(dataSize - pointsToUse + i);
            shotsMade[i] = data.shotsMade;
            percentages[i] = data.percentage;
        }

        // Performs the DIVIDED DIFFERENCE METHOD for extrapolation
        double extrapolatedPercentage = dividedDifference(shotsMade, percentages, shotsToExtrapolate);
        System.out.printf("Extrapolated Shooting Percentage: %.1f%%%n", extrapolatedPercentage);
    }

    // Compute extrapolated value using Newton's divided difference method
    public static double dividedDifference(double[] x, double[] y, double value) {
        int n = x.length;
        double[][] diffTable = new double[n][n];

        // Fill the first column with y-values
        for (int i = 0; i < n; i++) {
            diffTable[i][0] = y[i];
        }

        // Calculate divided differences
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                diffTable[i][j] = (diffTable[i + 1][j - 1] - diffTable[i][j - 1]) / (x[i + j] - x[i]);
            }
        }

        // Compute the extrapolated value
        double result = diffTable[0][0];
        double product = 1;

        for (int i = 1; i < n; i++) {
            product *= (value - x[i - 1]);
            result += diffTable[0][i] * product;
        }

        return result;
    }
}
