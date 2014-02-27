package javax.sdp;

public class SdpFactoryFinder {

    /**
     * The current path.
     */
    public static String currentPath;

    /**
     * Set the path.
     * @param path  the fully qualified class name of the Class that implements SdpFactory interface
     *              and is to be instantiated by this SdpFactoryFinder
     */
    public static void setPath(String path) {
        currentPath = path;
    }

    /**
     * Returns an instance of SdpFactory from a given path. Note: The method expects an empty constructor.
     * @return an instance of SdpFactory from a given path.
     */
    public static SdpFactory getSdpFactory() {
        if (currentPath == null) {
            throw new NullPointerException();
        }
        try {
            Class sdpFactoryClass = Class.forName(currentPath);
            return (SdpFactory) sdpFactoryClass.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException("The Sdp Factory: " + currentPath
                    + "could not be instantiated. Ensure the Path Name has been set.");
        }
    }
}
