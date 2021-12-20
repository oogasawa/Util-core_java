package net.trelliscode.util.bash;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Bash {

    public enum STDIO {
        IGNORE,
        INHERIT,
        STORE
    }


    public static void main(String[] args) {

        String com = "echo 'Bash start'; sleep 3; echo 'Bash end'";
        //BashResult result = Bash.exec(com, false);

        //System.out.println(result.toString());
        System.out.println("finished.");
    }


    public static BashResult exec(String com) {
        return exec(com, STDIO.INHERIT, STDIO.INHERIT);
    }

    public static BashResult exec(String com, STDIO stdout, STDIO stderr) {

        var result = new BashResult();
        var builder = new ProcessBuilder();

        try {
            Process p = builder.command("/bin/bash", "-c", com).start();


            if (stdout == STDIO.INHERIT) {
                Runnable r_out = () -> {
                    try {
                        InputStream input = p.getInputStream();
                        int b;
                        while ((b = input.read()) != -1) {
                            System.out.write(b);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                };

                var t1 = new Thread(r_out);
                t1.start();
            }
            else if (stdout == STDIO.STORE) {
                Runnable r_out = () -> {
                    try {
                        InputStream input = p.getInputStream();
                        int b;
                        while ((b = input.read()) != -1) {
                            System.out.write(b);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                };

                var t1 = new Thread(r_out);
                t1.start();
            }



            if (stderr == STDIO.INHERIT) {
                Runnable r_err = () -> {
                    try {
                        InputStream input = p.getErrorStream();
                        int b;
                        while ((b = input.read()) != -1) {
                            System.out.write(b);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                };

                var t1 = new Thread(r_err);
                t1.start();
            }
            else if (stdout == STDIO.STORE) {
                Runnable r_err = () -> {
                    try {
                        InputStream input = p.getErrorStream();
                        int b;
                        while ((b = input.read()) != -1) {
                            System.out.write(b);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                };

                var t1 = new Thread(r_err);
                t1.start();
            }

            p.waitFor();
            result.setExitValue(p.exitValue());

        } catch (IOException e) {
            System.err.println(e);
        } catch (InterruptedException e) {
            System.err.println(e);
        }

        return result;
    }




}
