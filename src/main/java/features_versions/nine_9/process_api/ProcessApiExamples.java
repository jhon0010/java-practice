package features_versions.nine_9.process_api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 * The Process API has been improved in Java 9 to provide more control over the operating system processes.
 * This allows you to:
 * - Manage and control operating system processes
 * - Get information about the processes
 * - Execute native commands
 */
public class ProcessApiExamples {

    public static void main(String[] args) {

        processHandleExample();

        try {
            nativeCommandExample(args);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * This method demonstrates how to use the ProcessHandle API to get information about the running processes in your OS.
     */
    public static void processHandleExample() {

        ProcessHandle.allProcesses().forEach(process -> {
            System.out.println("PID: " + process.pid());
            ProcessHandle.Info info = process.info();
            System.out.println("Command: " + info.command().orElse("Not available"));
            System.out.println("Start time: " + info.startInstant().orElse(Instant.now()).toString());
            System.out.println("User: " + info.user().orElse("Not available"));
            System.out.println("Arguments: " + Arrays.toString(info.arguments().orElse(new String[0])));
            System.out.println("Command line: " + info.commandLine().orElse("Not available"));
            System.out.println("Total CPU duration: " + info.totalCpuDuration().orElse(Duration.ZERO).toString());
            System.out.println("-------------------------------------------------");
        });
    }

    public static void nativeCommandExample(String[] args) throws IOException {

        // Command to execute. Adjust if necessary for your OS.
        // For Windows, you might need "cmd.exe", "/c", "ping -n 4 google.com"
        String[] command = {"ping", "-c", "4", "google.com"};

        ProcessBuilder processBuilder = new ProcessBuilder(command);
        Process process = null;
        try {
            process = processBuilder.start(); // Start the process

            // Read and print the output of the command
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor(); // Wait for the process to finish
            System.out.println("\nExited with code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (process != null) {
                process.destroy();
            }
        }
    }

}
