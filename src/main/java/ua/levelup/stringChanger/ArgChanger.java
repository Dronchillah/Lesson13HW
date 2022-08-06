package ua.levelup.stringChanger;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.spi.StringArrayOptionHandler;



public class ArgChanger {
    @Option(name = "-ch", aliases = "-change", handler = StringArrayOptionHandler.class)
    String[] pair;

    @Option(name = "-r", aliases = "-reverse")
    boolean reverse;

    @Option(name = "-s", aliases = "-string", handler = StringArrayOptionHandler.class, required = true)
    String[] words;

    private String string;

    public static void main(String[] args) {
        ArgChanger changer = new ArgChanger();

        CmdLineParser parser = new CmdLineParser(changer);

        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            throw new RuntimeException(e);
        }

        ArgChanger changer1 = changer;
        System.out.println(changer1.getResultString());

    }

    public String getResultString() {
        concatArrToString();
        symbolSwap();
        reverseString();
        return this.string;
    }
    private void concatArrToString(){
        StringBuilder build = new StringBuilder();
        for(String str : words){
            build.append(str + " ");
        }
        this.string = build.toString();
    }
    private void symbolSwap(){
        if(pair.length > 0){
            this.string = this.string.replace(pair[0], pair[1]);
        }
    }
    private void reverseString(){
        if(reverse){
            this.string = new StringBuilder(this.string).reverse().toString();
        }
    }
}