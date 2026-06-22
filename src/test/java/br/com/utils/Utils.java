package br.com.utils;

public class Utils {

    public static String getSchemaBasePath(String pack, String nameSchema) {
        return System.getProperty("user.dir") + "/src/test/resources/schemas/" + pack + "/" + nameSchema + ".json";
    }
}
