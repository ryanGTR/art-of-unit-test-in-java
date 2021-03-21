package ch3;

public class ExtensionManagerFactory {

    private static IExtensionManager customManager = null;
    public static IExtensionManager create() {
        if (customManager != null) {
            return customManager;
        }
        return new FileExtensionManager();
    }

    public static void setCustomManager(IExtensionManager mgr) {
        customManager = mgr;
    }
}
