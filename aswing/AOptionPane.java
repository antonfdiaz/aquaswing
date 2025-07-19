package aswing;

public class AOptionPane {

    public static void showMessageDialog(String message) {
        String safeMessage = message.replace("\"", "\\\"");
        String script = String.format("display alert \"%s\"", safeMessage);

        try {
            ProcessBuilder pb = new ProcessBuilder("osascript", "-e", script);
            Process process = pb.start();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showClassicMessageDialog(String message) {
        String safeMessage = message.replace("\"", "\\\"");

        String script = String.format("display dialog \"%s\"",safeMessage);

        try {
            ProcessBuilder pb = new ProcessBuilder("osascript", "-e", script);
            Process process = pb.start();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //this isnt very well done, but it works :D
    public static void showClassicMessageDialog(String message,String title) {
        String safeMessage = message.replace("\"", "\\\"");
        String safeTitle = title.replace("\"", "\\\"");

        String script = String.format("display dialog \"%s\" with title \"%s\"", safeMessage,safeTitle);

        try {
            ProcessBuilder pb = new ProcessBuilder("osascript", "-e", script);
            Process process = pb.start();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void showNotification(String message) {
        String safeMessage = message.replace("\"","\\\"");
        String safeTitle = "java".replace("\"","\\\"");

        String script = String.format("display notification \"%s\" with title \"%s\"",safeMessage,safeTitle);

        try {
            ProcessBuilder pb = new ProcessBuilder("osascript","-e",script);
            Process process = pb.start();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showNotification(String message,String soundName) {
        String safeMessage = message.replace("\"","\\\"");
        String safeTitle = "java".replace("\"","\\\"");

        String safeSoundName = soundName.replace("\"","\\\"");

        String script = String.format("display notification \"%s\" with title \"%s\" sound name \"%s\"",safeMessage,safeTitle,safeSoundName);

        try {
            ProcessBuilder pb = new ProcessBuilder("osascript","-e",script);
            Process process = pb.start();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}