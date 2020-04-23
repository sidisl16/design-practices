package com.deisgn.practice.inmemory.file.system;

import java.util.Arrays;
import java.util.Date;

public class File extends Entry {

	private byte[] content;
	private String type;

	public File(String name, Directory parent, byte[] content, String type) {
		this.name = name;
		this.content = content;
		this.type = type;
		this.createdAt = new Date();
		this.lastModified = new Date();
	}

	@Override
	public int getSize() {
		if (this.content == null) {
			return 0;
		}
		return this.content.length;
	}

	public String getType() {
		return this.type;
	}

	public void changeContent(byte content[]) {
		this.content = content;
		this.lastModified = new Date();
	}

	public byte[] getContent() {
		return this.content;
	}

	@Override
	public String toString() {
		return "File [content=" + Arrays.toString(content) + ", type=" + type + ", parent=" + parent + ", name=" + name
				+ ", size=" + size + ", createdAt=" + createdAt + ", lastModified=" + lastModified + "]";
	}
}