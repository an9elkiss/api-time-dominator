package com.an9elkiss.api.timedo.constant;

public enum TimeEntryType {

	SPORTS_EXERCISE(1,"运动"),
	READING(2,"阅读"),
	IT_LEARNING(3,"IT技术"),
	ENTERTAINMENT(4,"休息娱乐"),
	FINANCE(5,"金融理财"),
	CHILD_EDUCATION(6,"育儿");

	private Integer typeId;
	private String typeName;
	

	private TimeEntryType(Integer typeId, String typeName) {
		this.typeId = typeId;
		this.typeName = typeName;
	}


	public Integer getTypeId() {
		return typeId;
	}


	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}


	public String getTypeName() {
		return typeName;
	}


	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}
