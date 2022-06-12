package net.laddercode.util;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import net.laddercode.util.io.FileIO;

public class App {

    public static void main(String[] args) throws UnsupportedEncodingException {
        PrintWriter stdout = FileIO.stdout();
        stdout.println("Hello world");
        stdout.flush();
    }
}
