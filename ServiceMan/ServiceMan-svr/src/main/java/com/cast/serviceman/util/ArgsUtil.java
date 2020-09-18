package com.cast.serviceman.util;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import java.util.HashMap;
import java.util.Map;

/**
 * 参数获取方法,主要解析key、value格式数据
 */
public class ArgsUtil {

    public static Map<String, String> getArgMap(String[] args) {
        Map<String, String> map = new HashMap<>();
        for (String arg : args) {
            String[] strings = arg.split("=");
            map.put(strings[0], strings[1]);
        }
        return map;
    }

    public static void main(String[] args) throws Exception {
        // ,"java -jar xx.jar -a23","java xxxx -h"
        String[] ss = new String[]{ "-a","13" };
        getCommand(ss);
    }

    public static Map<String, String> getCommand(String[] args) throws Exception {
        Map<String, String> map = new HashMap<>();
        CommandLineParser parser = new BasicParser();
        Options options = new Options();
        options.addOption("a", "a", true, "an");
//        options.addOption("b", "b", true, "an");
        CommandLine commandLine = parser.parse(options, args);

        for (Option opt1 : commandLine.getOptions()) {
            String name = opt1.getLongOpt();
            String value = commandLine.getOptionValue(name);
            System.out.println(name + "=>" + value);
            map.put(name, value);
        }
        return map;
    }

}
