package com.revature.dto;

import java.io.Serializable;
import java.util.Arrays;

public class ImageDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4962419739390909803L;
	
	private String mimetype;
	private byte[] value;
	
	public ImageDTO () { }

	public ImageDTO(String mimetype, byte[] value) {
		super();
		this.mimetype = mimetype;
		this.value = value;
	}

	public String getMimetype() {
		return mimetype;
	}

	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}

	public byte[] getValue() {
		return value;
	}

	public void setValue(byte[] value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "ImageDTO [mimetype=" + mimetype + ", value=" + Arrays.toString(value) + "]";
	} 
	
	

}
