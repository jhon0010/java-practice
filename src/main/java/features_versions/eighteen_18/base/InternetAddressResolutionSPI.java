package features_versions.eighteen_18.base;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * JEP 400: Internet Address Resolution SPI
 * By default, the java.net.InetAddress API uses the operating system’s built-in resolver to resolve host names to
 * Internet Protocol (IP) addresses.
 */
public class InternetAddressResolutionSPI {

    public static void main(String[] args) throws UnknownHostException {

        InetAddress ip = InetAddress.getByName("google.com");
        System.out.println("Host Name: " + ip.getHostName() + " IP Address: " + ip.getHostAddress());



    }

}
