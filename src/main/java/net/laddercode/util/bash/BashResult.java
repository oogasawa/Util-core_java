package net.laddercode.util.bash;

import lombok.Data;

@Data
public class BashResult {

	String stdout;
	String stderr;
	int    exitValue;

}
