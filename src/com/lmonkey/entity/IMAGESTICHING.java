package com.lmonkey.entity;

public class IMAGESTICHING {
	private int IMAGE_ID;
	private String IMAGE_ONE_FILE;
	private String IMAGE_ONE_DESCRIPTION;
	private String IMAGE_TWO_FILE;
	private String IMAGE_TWO_DESCRIPTION;
	private String IMAGE_RESULT;
	public IMAGESTICHING(int iMAGE_ID, String iMAGE_ONE_FILE,
			String iMAGE_ONE_DESCRIPTION, String iMAGE_TWO_FILE,
			String iMAGE_TWO_DESCRIPTION, String iMAGE_RESULT) {
		super();
		IMAGE_ID = iMAGE_ID;
		IMAGE_ONE_FILE = iMAGE_ONE_FILE;
		IMAGE_ONE_DESCRIPTION = iMAGE_ONE_DESCRIPTION;
		IMAGE_TWO_FILE = iMAGE_TWO_FILE;
		IMAGE_TWO_DESCRIPTION = iMAGE_TWO_DESCRIPTION;
		IMAGE_RESULT = iMAGE_RESULT;
	}
	public int getIMAGE_ID() {
		return IMAGE_ID;
	}
	public void setIMAGE_ID(int iMAGE_ID) {
		IMAGE_ID = iMAGE_ID;
	}
	public String getIMAGE_ONE_FILE() {
		return IMAGE_ONE_FILE;
	}
	public void setIMAGE_ONE_FILE(String iMAGE_ONE_FILE) {
		IMAGE_ONE_FILE = iMAGE_ONE_FILE;
	}
	public String getIMAGE_ONE_DESCRIPTION() {
		return IMAGE_ONE_DESCRIPTION;
	}
	public void setIMAGE_ONE_DESCRIPTION(String iMAGE_ONE_DESCRIPTION) {
		IMAGE_ONE_DESCRIPTION = iMAGE_ONE_DESCRIPTION;
	}
	public String getIMAGE_TWO_FILE() {
		return IMAGE_TWO_FILE;
	}
	public void setIMAGE_TWO_FILE(String iMAGE_TWO_FILE) {
		IMAGE_TWO_FILE = iMAGE_TWO_FILE;
	}
	public String getIMAGE_TWO_DESCRIPTION() {
		return IMAGE_TWO_DESCRIPTION;
	}
	public void setIMAGE_TWO_DESCRIPTION(String iMAGE_TWO_DESCRIPTION) {
		IMAGE_TWO_DESCRIPTION = iMAGE_TWO_DESCRIPTION;
	}
	public String getIMAGE_RESULT() {
		return IMAGE_RESULT;
	}
	public void setIMAGE_RESULT(String iMAGE_RESULT) {
		IMAGE_RESULT = iMAGE_RESULT;
	}
	
}
