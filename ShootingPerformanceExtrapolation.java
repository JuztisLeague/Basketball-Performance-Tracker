package zznumericalMethodstrial;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShootingPerformanceExtrapolation {
    static class ShootingData {
        int skillLevel;
        double shotsMade;
        double percentage;
    }

    static class TrainingSession {
        int level; // Skill level
        List<ShootingData> data; // Shooting data points
        int totalAttempts;

        public TrainingSession(int level, int totalAttempts) {
            this.level = level;
            this.totalAttempts = totalAttempts;
            this.data = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<TrainingSession> trainingData = new ArrayList<>();
        initializeSkillLevels(trainingData);

        while (true) {
            System.out.println("\n=== Shooting Performance Extrapolation ===");
            System.out.println("1. Enter Shooting Data");
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
                    performExtrapolation(scanner, trainingData);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    public static void initializeSkillLevels(List<TrainingSession> trainingData) {
        trainingData.add(new TrainingSession(1, 10)); // Level 1: 10 attempts
        trainingData.add(new TrainingSession(2, 25)); // Level 2: 25 attempts
        trainingData.add(new TrainingSession(3, 50)); // Level 3: 50 attempts
    }

    public static void enterShootingData(Scanner scanner, List<TrainingSession> trainingData) {
        System.out.print("Enter skill level (1-3): ");
        int skillLevel = scanner.nextInt();

        if (skillLevel < 1 || skillLevel > 3) {
            System.out.println("Invalid skill level. Must be between 1 and 3.");
            return;
        }

        TrainingSession session = trainingData.get(skillLevel - 1);
        System.out.println("Skill Level " + skillLevel + " - Total Attempts: " + session.totalAttempts);
        System.out.print("Enter the number of data points to add: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            ShootingData data = new ShootingData();
            data.skillLevel = skillLevel;
            System.out.print("Shots Made [" + (i + 1) + "]: ");
            data.shotsMade = scanner.nextDouble();
            data.percentage = (data.shotsMade / session.totalAttempts) * 100;
            System.out.printf("Shooting Percentage: %.1f%%%n", data.percentage);
            session.data.add(data);
        }

        System.out.println("Shooting data saved for Level " + skillLevel + ".");
    }

    public static void viewProgress(List<TrainingSession> trainingData) {
        System.out.println("\n=== Training Progress ===");
        for (TrainingSession session : trainingData) {
            System.out.println("Skill Level " + session.level + " Progress:");
            for (ShootingData data : session.data) {
                System.out.printf("  Shots Made: %.1f/%d, Shooting Percentage: %.1f%%%n",
                        data.shotsMade, session.totalAttempts, data.percentage);
            }
        }
    }

    public static void performExtrapolation(Scanner scanner, List<TrainingSession> trainingData) {
        System.out.print("Select skill level for extrapolation (1-3): ");
        int skillLevel = scanner.nextInt();

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

        double[] shotsMade = new double[session.data.size()];
        double[] percentages = new double[session.data.size()];

        for (int i = 0; i < session.data.size(); i++) {
            shotsMade[i] = session.data.get(i).shotsMade;
            percentages[i] = session.data.get(i).percentage;
        }

        double extrapolatedPercentage = dividedDifference(shotsMade, percentages, shotsToExtrapolate);
        System.out.printf("Extrapolated Shooting Percentage: %.1f%%%n", extrapolatedPercentage);
    }

    public static double dividedDifference(double[] x, double[] y, double value) {
        int n = x.length;
        double[][] diffTable = new double[n][n];

        for (int i = 0; i < n; i++) {
            diffTable[i][0] = y[i];
        }

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                diffTable[i][j] = (diffTable[i + 1][j - 1] - diffTable[i][j - 1]) / (x[i + j] - x[i]);
            }
        }

        double result = diffTable[0][0];
        double product = 1;

        for (int i = 1; i < n; i++) {
            product *= (value - x[i - 1]);
            result += diffTable[0][i] * product;
        }

        return result;
    }
}
