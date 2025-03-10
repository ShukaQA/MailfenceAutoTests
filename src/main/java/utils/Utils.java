package utils;

public class Utils {
    public String getTextFromString(String str) {
        int lastSpaceIndex = str.lastIndexOf("\n");
        return str.substring(0, lastSpaceIndex);
    }

    public String getNumberFromString(String str) {
        int lastSpaceIndex = str.lastIndexOf("\n");
        return str.substring(lastSpaceIndex + 1);
    }
}