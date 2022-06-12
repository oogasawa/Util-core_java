package net.laddercode.util.type;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;

import net.laddercode.util.bdd.BddUtil;
import net.laddercode.util.collection.BooleanListUtil;


public class toIntegerSpec {


    public static boolean exec(PrintStream out) {

        out.println("### toInteger");

        ArrayList<Boolean> results = new ArrayList<>();
        results.add(ToInteger_boolean(out));
        results.add(toInteger_long(out));
        results.add(toInteger_Integer(out));
        results.add(toInteger_Long(out));

        return BooleanListUtil.allTrue(results);
    }


    public static boolean ToInteger_boolean(PrintStream out) {

        // Description
        String[] description = {
            "",
            "#### toInteger <= boolean",
            "",
            "引数が`true`なら1を、`false`なら0を`Optional`オブジェクトとして返す。",
            ""
            };
        Arrays.stream(description)
            .forEach(out::println);

        // Expectations
        String[] expectations = {
            "Type.toInteger(true).get() => 1",
            "Type.toInteger(false).get() => 0"
        };
        String expectation = String.join("\n",expectations);


        // Reality
        StringJoiner answers = new StringJoiner("\n");
        answers.add(String.format("Type.toInteger(true).get() => %d", Type.toInteger(true).get()));
        answers.add(String.format("Type.toInteger(false).get() => %d", Type.toInteger(false).get()));
        String answer = answers.toString();

        // Check the answer.
        boolean result = BddUtil.assertTrue(expectation, answer);
        assert result;
        return result;
    }



    public static boolean toInteger_long(PrintStream out) {

        // Description
        String[] description = {
            "",
            "### toInteger <= long",
            "",
            "`long`を`Integer`に変換し`Optional`オブジェクトとして返す。",
            "値が大きい場合はオーバーフローする。",
            ""
            };
        Arrays.stream(description)
            .forEach(out::println);

        // Expectations
        String[] expectations = {
            "Integer.MAX_VALUE:  2147483647",
            "long\tInteger",
            "2147483645 => 2147483645",
            "2147483646 => 2147483646",
            "2147483647 => 2147483647",
            "2147483648 => -2147483648",
            "2147483649 => -2147483647",
        };
        String expectation = String.join("\n",expectations);

        // Reality
        StringJoiner answer = new StringJoiner("\n");
        answer.add(String.format("Integer.MAX_VALUE:  %d", Integer.MAX_VALUE));

        answer.add("long\tInteger");
        long val = Integer.MAX_VALUE;
        for (long l = val - 2; l <= val + 2; l++) {
            answer.add(String.format("%d => %d", l, Type.toInteger(l).get()));
        }

        // Check the answer.
        boolean result = BddUtil.assertTrue(expectation, answer.toString());
        assert result;
        return result;
    }



    public static boolean toInteger_Integer(PrintStream out) {

        // Description
        String[] description = {
            "",
            "#### toInteger <= Integer",
            "",
            "`Optional<Integer>`を返す。",
            "引数が`null`の場合は`Optional.empty`を返す。",
            ""
            };
        Arrays.stream(description)
            .forEach(out::println);

        // Expectations
        String[] expectations = {
            "Type.toInteger(Integer.valueOf(0)) => Optional[0]",
            "Type.toInteger((Integer)null) => Optional.empty",
        };
        String expectation = String.join("\n",expectations);

        // Reality
        StringJoiner answers = new StringJoiner("\n");
        answers.add(String.format("Type.toInteger(Integer.valueOf(0)) => %s", Type.toInteger(Integer.valueOf(0))));
        answers.add(String.format("Type.toInteger((Integer)null) => %s", Type.toInteger((Integer)null)));
        String answer = answers.toString();

        // Check the answer.
        boolean result = BddUtil.assertTrue(expectation, answer);
        assert result;
        return result;
    }


    public static boolean toInteger_Long(PrintStream out) {

        // Description
        String[] description = {
            "",
            "### toInteger <= Long",
            "",
            "`Long`を`Integer`に変換し`Optional`オブジェクトとして返す。",
            "値が大きい場合はオーバーフローする。",
            ""
            };
        Arrays.stream(description)
            .forEach(out::println);

        // Expectations
        String[] expectations = {
            "Integer.MAX_VALUE:  2147483647",
            "Long  =>  Integer",
            "2147483645 => 2147483645",
            "2147483646 => 2147483646",
            "2147483647 => 2147483647",
            "2147483648 => -2147483648",
            "2147483649 => -2147483647",
        };
        String expectation = String.join("\n",expectations);

        // Reality
        StringJoiner answer = new StringJoiner("\n");
        answer.add(String.format("Integer.MAX_VALUE:  %d", Integer.MAX_VALUE));
        answer.add("Long  =>  Integer");
        long val = Integer.MAX_VALUE;
        for (long l = val - 2; l <= val + 2; l++) {
            answer.add(String.format("%d => %d", Long.valueOf(l), Type.toInteger(Long.valueOf(l)).get()));
        }

        // Check the answer.
        boolean result = BddUtil.assertTrue(expectation, answer.toString());
        assert result;
        return result;
    }



}
