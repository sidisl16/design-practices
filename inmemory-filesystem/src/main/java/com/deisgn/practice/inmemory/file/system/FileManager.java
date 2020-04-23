package com.deisgn.practice.inmemory.file.system;

import java.util.Set;

/**
 * This class is Out of scope for now I will try to implement in better way
 **/
public class FileManager extends Entry {

	private Directory directory;

	public FileManager(Directory directory) {
		this.directory = directory;
	}

	public Directory getDirectory() {
		return directory;
	}

	public void setDirectory(Directory directory) {
		this.directory = directory;
	}

	public void addFile(Entry entry) {
		this.directory.getFiles().add(entry);
	}

	@Override
	public boolean delete() {
		return this.directory.delete();
	}

	@Override
	public int getSize() {
		return this.directory.getSize();
	}

	public Set<Entry> getFiles() {
		return this.directory.getFiles();
	}
}
