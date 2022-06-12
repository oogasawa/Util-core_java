package net.laddercode.util.type;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;

public class TypeSpec {

    public static boolean exec(PrintStream out) {

        out.println(System.getProperty("laddercode.bdd.basedir"));

        // # Feature description
        String[] featureDescription = {
            "# `Type` class",
            "",
            "コーディングの効率化を目的として、型変換の呼び出しかたを統一するためのクラス。",
            "変換できない場合は`Exception`をthrowするのではなく`Optional`を用いるようにする",
            ""
        };

        // PrintWriter out = new PrintWriter(System.out);
        Arrays.stream(featureDescription)
            .forEach(out::println);

        // ## Business rules or Acceptance Criteria.
        // ## Additional details.

        // ### Examples 1, 2, 3, ...
        var test = new toIntegerSpec();
        return test.exec(out);


    }

}
