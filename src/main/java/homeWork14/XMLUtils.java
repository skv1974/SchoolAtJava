package homeWork14;

public class XMLUtils {
    public static String createEmptyElement(String tagName) {
        if (tagName == null || tagName.trim().isEmpty()) {
            return "<invalid/>";
        }
        return "<" + tagName + "></" + tagName + ">";
    }
}