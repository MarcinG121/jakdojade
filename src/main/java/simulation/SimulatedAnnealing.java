package simulation;

import java.util.*;


public class SimulatedAnnealing {

    // Final temperature to which the system cools (iteration terminates)
    public static double T_min = 1;

    // Coefficient of decrease temperature
    public static double collingRate = 0.9;

    // Number of iterations before decreasing temperature
    public static int numIterations = 100;

    // Initial temperature
    public static double T = 1000;

    // Calculate the acceptance probability
    public static double acceptanceProbability(int time, int newTime, double temperature) {
        return newTime < time ? 1 : Math.exp((time - newTime) / temperature);
    }


    public static void main(String[] args) {
        System.out.println("Simulated annealing is running...");

        while(T_min < T) {
            for(int i = 0; i < numIterations; i++) {
                // TO DO
            }

            // Get time of solutions
            int time = 0;
            int newTime = 0;

            // Decide to accept solution
            Random r = new Random();
            if(r.nextDouble() < acceptanceProbability(time, newTime, T)) {
                // create current solution
            }

            // Keep best solution
            // TO DO

            // System cooling
            T *= collingRate;
        }
        System.out.println("Final solution is: ...");
    }
}
