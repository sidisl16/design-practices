package com.deisgn.practice.inmemory.file.system;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Directory extends Entry {

	private Set<Entry> files;

	public Directory(String name, Directory parent) {
		this.name = name;
		this.parent = parent;
		this.createdAt = new Date();
		this.lastModified = new Date();
		files = new HashSet<>();
	}

	@Override
	public int getSize() {
		calculateDirSize(this.files);
		return this.size;
	}

	private void calculateDirSize(Set<Entry> files) {
		for (Entry file : files) {
			if (file instanceof File) {
				size += ((File) file).getSize();
			} else {
				calculateDirSize(((Directory) file).getFiles());
			}
		}
	}

	public boolean deleteEntry(Entry file) {
		return files.remove(file);
	}

	/**
	 * To add new element in entry list use getFiles method e.g. getFiles().add(...)
	 * 
	 */
	public Set<Entry> getFiles() {
		return this.files;
	}
}
