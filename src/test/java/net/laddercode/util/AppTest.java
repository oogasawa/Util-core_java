package net.laddercode.util;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

import net.laddercode.util.type.TypeSpec;
import net.laddercode.util.type.toIntegerSpec;


public class AppTest {

    // Logger logger = System.getLogger("net.laddercode.util.AppTest");


    public void testAll() {
        System.out.println(System.getProperty("laddercode.bdd.basedir"));
        PrintStream out = new PrintStream(System.out);
        out.println("Howdy!!");
        assert TypeSpec.exec(out);
    }


}
