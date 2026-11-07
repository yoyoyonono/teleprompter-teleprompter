// Application main code. Must call into VelocityMain.
// NOT PART OF VELOCITY!

import com.rsc_games.velocity.VelocityMain;
import com.rsc_games.velocity.util.Version;
import appcode.AppConfig;
import appcode.SceneDefs;

public class Main {
    public static void main(String[] args) {
        // Require a minimum Velocity version for running.
        Version velocityVersion = new Version(0, 7, 0, 0);
        if (!velocityVersion.isOlder(VelocityMain.VELOCITY_VER)
            && !velocityVersion.equals(VelocityMain.VELOCITY_VER)) {

            System.err.println("ERROR! Provided Velocity binary is too old!");
            System.err.println("Requested " + velocityVersion + ", got " 
                               + VelocityMain.VELOCITY_VER + "!");
            System.err.println("Fatal. Exiting application.");
            System.exit(1);
        }

        // Versions of velocity that are too new may pose a compatibility issue.
        Version unsupportedVersion = new Version(0, 7, 5, 0);
        if (!unsupportedVersion.isNewer(VelocityMain.VELOCITY_VER)) {
            System.err.println("ERROR! Provided Velocity version is unsupported/API incompatible!");
            System.err.println("Got " + VelocityMain.VELOCITY_VER + ", minimum supported "
                               + velocityVersion + "!");
            System.err.println("Fatal. Exiting application.");
            System.exit(1);
        }

        // Run the application.
        VelocityMain.app_main(new AppConfig(), new SceneDefs());
    }
}