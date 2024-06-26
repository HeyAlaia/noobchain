package com.noob;

import com.noob.util.StringUtil;

import java.util.Date;

public class Block {

	public String hash;
	public String previousHash;

	public String data; //our data will be a simple message.
	private long timeStamp; //as number of milliseconds since 1/1/1970.

	//Block Constructor.
	public Block(String data,String previousHash ) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.hash = calculateHash(); //Making sure we do this after we set the other values.

	}

	public String calculateHash() {
        return StringUtil.applySha256(
				previousHash +
						Long.toString(timeStamp) +
						data
		);
	}
}