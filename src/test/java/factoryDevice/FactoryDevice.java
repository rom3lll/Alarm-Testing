package factoryDevice;

public class FactoryDevice {
    public enum DeviceType {
        ANDROID,
        CLOUD
    }

    public static IDevice make(DeviceType type) {
        IDevice device;

        switch (type) {
            case ANDROID:
                device = new Android();
                break;
            default:
                device = new Android();
                break;
        }

        return device;


    }

}
