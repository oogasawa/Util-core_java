package net.laddercode.util.bdd;

import java.io.FileNotFoundException;

import net.laddercode.util.io.FileIO;

public class MdToArray {

    public static void main(String[] args) {

        try (var br = FileIO.getBufferedReader(args[1])) {
            br.lines()
                .forEach(line->{
                        System.out.println("\"" + line + "\",");
                    });
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }


}
