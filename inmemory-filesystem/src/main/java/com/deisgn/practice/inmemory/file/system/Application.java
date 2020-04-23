package com.deisgn.practice.inmemory.file.system;

/**
 *
 * ----------------------------------
 * |   In - Memory File System      |
 * ----------------------------------
 * 
 * 
 * Problem Description:
 * ----------------------
 * Design data structures and algorithms for in-memory file system Explain the
 * data structures and algorithms that you would use to design an in-memory file
 * system. Illustrate with an example in the code logic where possible.
 * 
 * Solution:
 * ----------------------
 * 
 * There are two entities involve in this problem File and Directory, 
 * each directory can have multiple files and directories
 * Both shares some common properties and can be inherit from one single 
 * class 'Entry'.  
 * 
 * 
 * Entry <abstract> -> extends File<concrete>
 *   |
 *   v
 * extends Directory<concrete>
 * 
 * We can also add more functionality to it and better way is to use design pattern
 * Strategy pattern - we can also include FileManager class to do operation like
 * add, delete, traverse, search etc. This has not been implemented in this project.
 *   
 * @author siddharth.prasad
 *
 */
public class Application {
	
	/**
	 * 
	 * Client Application:
	 * 
	 * Let's create in memory file system structure
	 * 
	 * 					/root
	 * 					  |	
	 *    ----------------------------------
	 * 	  |	              |                |
	 *   /var             /opt            /home
	 *    |                                 |
	 *  -------------                     /sid  
	 *  |            |                      |  
	 *  /lib       /log                  misc.txt 
	 *               |
	 *              catalina.log
	 *  
	 */
	public static void main(String[] args) {

		Entry root = Application.createInMemoryFileSystemStructure();
		// You can iterate or do more operation e.g. get size or add or delete files in a directory
		// or modify content of a file
		System.out.println(root.getSize());
	}

	public static Entry createInMemoryFileSystemStructure() {
		Directory root = new Directory("root", null);

		Directory var = new Directory("var", root);
		Directory opt = new Directory("opt", root);
		Directory home = new Directory("home", root);

		root.getFiles().add(var);
		root.getFiles().add(opt);
		root.getFiles().add(home);

		Directory lib = new Directory("lib", var);
		Directory log = new Directory("log", var);
		File logFile = new File("catalina.log", log, "Log test".getBytes(), "log");
		var.getFiles().add(lib);
		var.getFiles().add(log);
		log.getFiles().add(logFile);

		Directory sid = new Directory("sid", home);
		File textFile = new File("misc.txt", sid, "miscelenious".getBytes(), "txt");
		home.getFiles().add(sid);
		sid.getFiles().add(textFile);

		return root;
	}

}