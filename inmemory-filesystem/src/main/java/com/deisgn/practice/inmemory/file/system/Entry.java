package com.deisgn.practice.inmemory.file.system;

import java.util.Date;

public abstract class Entry {

	protected Directory parent;
	protected String name;
	protected int size;
	protected Date createdAt;
	protected Date lastModified;

	public String getName() {
		return this.name;
	}

	public void rename(String name) {
		this.name = name;
		lastModified = new Date();
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public Date getlastModified() {
		return this.lastModified;
	}

	public Entry getParent() {
		return this.parent;
	}

	public boolean delete() {
		if (parent != null) {
			return this.parent.deleteEntry(this);
		}
		return false;
	}

	protected abstract int getSize();

}
