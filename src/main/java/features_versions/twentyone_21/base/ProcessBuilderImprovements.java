package features_versions.twentyone_21.base;

import java.io.IOException;

/**
 *
 * Java 21 has enhanced its tools such as ‘Runtime.exec’ and ‘ProcessBuilder’ which are used to start new processes like
 * running a new program.
 * Java program that frequently starts new processes using ‘Runtime.exec’ or ‘ProcessBuilder’, this feature helps you
 * track or log these activities.
 * You would generally have a logger setup for your application, with this new feature, you’d specifically want to monitor
 * the logger named ‘java.lang.ProcessBuilder’ as shown below.
 */
public class ProcessBuilderImprovements {

    public static void main(String[] args) throws IOException {
        System.Logger logger = System.getLogger("java.lang.ProcessBuilder");

        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("ping", "www.google.com");

        logger.log(System.Logger.Level.INFO, "Starting a new process");
        Process process = processBuilder.start();
        System.out.println(STR."Process started info : \{process.info()}");
        System.out.println(STR."Process started PID : \{process.pid()}");
        process.destroy();
    }

}
