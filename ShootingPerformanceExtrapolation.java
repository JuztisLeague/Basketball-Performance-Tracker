package zznumericalMethodstrial;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShootingPerformanceExtrapolation {

    // Class to store shooting and dribbling data for a single data point
    static class ShootingData {
        int skillLevel;          // Skill level associated with this data point
        double shotsMade;        // Number of shots made
        double percentage;       // Shooting percentage for this data point
        double dribblesMade;     // Number of dribbles made
        double dribblePercentage; // Dribbling percentage for this data point
        double runningTime;      // Running time for the session

        public ShootingData(int skillLevel, double shotsMade, double percentage, double dribblesMade, double dribblePercentage, double runningTime) {
            this.skillLevel = skillLevel;
            this.shotsMade = shotsMade;
            this.percentage = percentage;
            this.dribblesMade = dribblesMade;
            this.dribblePercentage = dribblePercentage;
            this.runningTime = runningTime;
        }
    }

    // Class to store training session data for a specific skill level
    static class TrainingSession {
        int level;                  // Skill level of the session
        List<ShootingData> data;    // List of shooting data points for this skill level
        int totalAttempts;          // Total attempts available for this skill level
        int maxDribbles;            // Max dribbles for this skill level

        public TrainingSession(int level, int totalAttempts, int maxDribbles) {
            this.level = level;
            this.totalAttempts = totalAttempts;
            this.maxDribbles = maxDribbles;
            this.data = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<TrainingSession> trainingData = new ArrayList<>();
        initializeSkillLevels(trainingData);

        while (true) {
            System.out.println("\n=== Shooting and Dribbling Performance Extrapolation ===");
            System.out.println("1. Enter Shooting and Dribbling Data");
            System.out.println("2. View Progress");
            System.out.println("3. Perform Extrapolation");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    enterShootingData(scanner, trainingData);
                    break;
                case 2:
                    viewProgress(trainingData);
                    break;
                case 3:
                    performExtrapolation(trainingData);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    // Initialize skill levels with predefined total attempts and max dribbles
    public static void initializeSkillLevels(List<TrainingSession> trainingData) {
        trainingData.add(new TrainingSession(1, 10, 20)); // Skill 1
        trainingData.add(new TrainingSession(2, 25, 40)); // Skill 2
        trainingData.add(new TrainingSession(3, 50, 50)); // Skill 3
    }

    // Function to enter shooting and dribbling data, including running time
    public static void enterShootingData(Scanner scanner, List<TrainingSession> trainingData) {
        System.out.print("Enter skill level (1-3): ");
        int skillLevel = scanner.nextInt();

        if (skillLevel < 1 || skillLevel > 3) {
            System.out.println("Invalid skill level. Must be between 1 and 3.");
            return;
        }

        TrainingSession session = trainingData.get(skillLevel - 1);
        System.out.println("Skill Level " + skillLevel + " - Total Attempts: " + session.totalAttempts + "  Dribbling Max: " + session.maxDribbles);
        System.out.print("Enter the number of data points to add: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Shots Made [" + (i + 1) + "]: ");
            double shotsMade = scanner.nextDouble();
            double percentage = (shotsMade / session.totalAttempts) * 100;

            System.out.print("Dribbles Made [" + (i + 1) + "]: ");
            double dribblesMade = scanner.nextDouble();
            double dribblePercentage = (dribblesMade / session.maxDribbles) * 100;

            System.out.print("Enter the running time in seconds: ");
            double runningTime = scanner.nextDouble();

            ShootingData newData = new ShootingData(skillLevel, shotsMade, percentage, dribblesMade, dribblePercentage, runningTime);
            session.data.add(newData);

            System.out.printf("Shooting Percentage: %.1f%%, Dribbling Percentage: %.1f%%, Running Time: %.1f seconds%n", percentage, dribblePercentage, runningTime);
        }
    }

    // Function to view progress
    public static void viewProgress(List<TrainingSession> trainingData) {
        System.out.println("\n=== Training Progress ===");
        for (TrainingSession session : trainingData) {
            System.out.println("Skill Level " + session.level + " Progress:");
            for (ShootingData data : session.data) {
                System.out.printf("  Shots Made: %.1f/%d, Shooting Percentage: %.1f%%, Dribbles Made: %.1f/%d, Dribbling Percentage: %.1f%%, Running Time: %.1f seconds%n",
                        data.shotsMade, session.totalAttempts, data.percentage, data.dribblesMade, session.maxDribbles, data.dribblePercentage, data.runningTime);
            }
        }
    }

    // Perform extrapolation using existing data points
    public static void performExtrapolation(List<TrainingSession> trainingData) {
        System.out.print("Select skill level for extrapolation (1-3): ");
        Scanner scanner = new Scanner(System.in);
        int skillLevel = scanner.nextInt();

        if (skillLevel < 1 || skillLevel > 3) {
            System.out.println("Invalid skill level. Must be between 1 and 3.");
            return;
        }

        TrainingSession session = trainingData.get(skillLevel - 1);
        if (session.data.size() < 5) { // Ensure we have enough data points (5)
            System.out.println("Not enough data points for extrapolation. At least 5 data points are required.");
            return;
        }

        int dataSize = session.data.size();
        double[] days = new double[5];
        double[] shotsMade = new double[5];
        double[] percentages = new double[5];
        double[] dribbles = new double[5];
        double[] dribblePercentages = new double[5];
        double[] runningTimes = new double[5];

        // Use the last 5 data points for extrapolation
        for (int i = 0; i < 5; i++) {
            days[i] = dataSize - 5 + i + 1; // Day number
            ShootingData data = session.data.get(dataSize - 5 + i);
            shotsMade[i] = data.shotsMade;
            percentages[i] = data.percentage;
            dribbles[i] = data.dribblesMade;
            dribblePercentages[i] = data.dribblePercentage;
            runningTimes[i] = data.runningTime;
        }

        double nextDay = days[4] + 1;

        System.out.println("Extrapolating for Day " + (int) nextDay + "...");

        // Predict values using divided difference method for extrapolation
        double predictedShots = dividedDifference(days, shotsMade, nextDay);
        double predictedDribbles = dividedDifference(days, dribbles, nextDay);
        double predictedDribblePercentage = dividedDifference(days, dribblePercentages, nextDay);
        double predictedRunningTime = dividedDifference(days, runningTimes, nextDay);

        // Calculate predicted shooting percentage based on predicted shots and total attempts
        double predictedPercentage = (predictedShots / session.totalAttempts) * 100;

        // Clamp values to realistic ranges
        predictedShots = Math.max(0, predictedShots);  // Shots made can't be negative
        predictedPercentage = Math.max(0, Math.min(100, predictedPercentage));  // Percentage should be between 0 and 100
        predictedDribbles = Math.max(0, predictedDribbles);  // Dribbles can't be negative
        predictedDribblePercentage = Math.max(0, Math.min(100, predictedDribblePercentage));  // Percentage should be between 0 and 100

        // Enforce skill-level-specific limits for shots and dribbles
        if (skillLevel == 1) {
            predictedShots = Math.min(predictedShots, session.totalAttempts);  // Skill level 1 max shots = total attempts
            predictedDribbles = Math.min(predictedDribbles, session.maxDribbles);  // Skill level 1 max dribbles
        } else if (skillLevel == 2) {
            predictedShots = Math.min(predictedShots, session.totalAttempts);  // Skill level 2 max shots = total attempts
            predictedDribbles = Math.min(predictedDribbles, session.maxDribbles);  // Skill level 2 max dribbles
        } else if (skillLevel == 3) {
            predictedShots = Math.min(predictedShots, session.totalAttempts);  // Skill level 3 max shots = total attempts
            predictedDribbles = Math.min(predictedDribbles, session.maxDribbles);  // Skill level 3 max dribbles
        }

        // Display the predicted values
        System.out.printf("Predicted Results for Day %.0f:%n", nextDay);
        System.out.printf("  Predicted Shots Made: %.1f (Max: %d)%n", predictedShots, session.totalAttempts);
        System.out.printf("  Predicted Shooting Percentage: %.1f%%%n", predictedPercentage);
        System.out.printf("  Predicted Dribbles Made: %.1f (Max: %d)%n", predictedDribbles, session.maxDribbles);
        System.out.printf("  Predicted Dribbling Percentage: %.1f%%%n", predictedDribblePercentage);
        System.out.printf("  Predicted Running Time: %.1f seconds%n", predictedRunningTime);
    }

    // Divided difference method for extrapolation
    public static double dividedDifference(double[] x, double[] y, double value) {
        int n = x.length;
        double[][] diffTable = new double[n][n];

        // Initialize the first column with y values
        for (int i = 0; i < n; i++) {
            diffTable[i][0] = y[i];
        }

        // Calculate the divided differences
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                diffTable[i][j] = (diffTable[i + 1][j - 1] - diffTable[i][j - 1]) / (x[i + j] - x[i]);
            }
        }

        // Evaluate the polynomial at the given value
        double result = diffTable[0][0];
        double product = 1;

        for (int i = 1; i < n; i++) {
            product *= (value - x[i - 1]);
            result += diffTable[0][i] * product;
        }

        return result;
    }
}

