package brooklyn.util;

import java.util.List;

public class CommandLineUtil {

    public static String getCommandLineOption (List<String> args, String param){
        return getCommandLineOption(args, param, null);
    }

    /** given a list of args, e.g. --name Foo --owner Bob
     * will return "Foo" as param name, and remove those entries from the args list
     */
    public static String getCommandLineOption(List<String> args, String param, String defaultValue) {
        int i = args.indexOf(param);
        if (i >= 0) {
            String result = args.get(i + 1);
            args.remove(i + 1);
            args.remove(i);
            return result;
        } else {
            return defaultValue;
        }
    }

    public static int getCommandLineOptionInt(List<String> args, String param, int defaultValue) {
        String s = getCommandLineOption(args, param,null);
        if (s == null) return defaultValue;
        return Integer.parseInt(s);
    }

    //we don't want instances.
    private CommandLineUtil(){}
}
