package common;

import java.io.File;

public class FileManager {

    private static final FileManager fileManager = new FileManager();

    private FileManager() {
    }

    public static FileManager getInstance() {
        return fileManager;
    }

    public String getPath() {
        return (String) RamDB.CachedDB.get("path");
    }

    public void setPath(String path) {
        RamDB.CachedDB.put("path", path);
    }

    public boolean isTokenValid(String token) {
        return RamDB.CachedDB.get("token").equals(token);
    }

    public void setToken(String path) {
        RamDB.CachedDB.put("token", path);
    }

    public String getFileName() {
        String path = (String) RamDB.CachedDB.get("path");
        File file = new File(path);
        return file.getName();
    }


}
