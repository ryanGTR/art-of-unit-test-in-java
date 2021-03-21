package ch3;

import org.apache.commons.io.FilenameUtils;

public class LogAnalyzer {

    private IExtensionManager mgr;

    public LogAnalyzer() {
        mgr = ExtensionManagerFactory.create();
    }


    public LogAnalyzer(IExtensionManager mgr) {
        this.mgr = mgr;
    }

    public boolean isValidFileName(String fileName)  {
        return mgr.isValid(fileName)
                   && FilenameUtils.getExtension(fileName).length() > 5;
    }

    public IExtensionManager getMgr() {
        return mgr;
    }

    public void setMgr(IExtensionManager mgr) {
        this.mgr = mgr;
    }
}
