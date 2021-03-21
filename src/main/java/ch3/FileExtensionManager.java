package ch3;

public class FileExtensionManager implements IExtensionManager {

    @Override
    public boolean isValid(String fileName) {
        if (fileName.equals("abc.json")) {
            return true;
        }
        return false;
    }

}
