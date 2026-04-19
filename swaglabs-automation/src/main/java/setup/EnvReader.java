package setup;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvReader {

    private static final Dotenv dotenv = Dotenv.configure()
            .directory("./")  
            .ignoreIfMissing() 
            .load();

    public static String get(String key) {
        return dotenv.get(key);
    }
}