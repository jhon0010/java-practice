package practice.eight_8.interfaces.defualt.method;

/**
 * In addition, they can be used to provide additional functionality around an existing abstract method:
 */
public interface VehicleInterface {

    // additional interface methods
    double getSpeed();

    default double getSpeedInKMH(double speed) {
        return speed * 1000;
    }
}
