package org.daniels.examples.subjects;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "SubSubject")
@XmlType(name = "ExtendedSubject")
public class ExtendedSubject extends Subject {

	@XmlElement(name = "ExtraName")
	private String extraName;
	@XmlElement(name = "Created")
	private Date created;
	
	private String createdStr;
	
	public String getCreatedStr() {
		return createdStr;
	}
	public void setCreatedStr(String createdStr) {
		this.createdStr = createdStr;
	}
	public String getExtraName() {
		return extraName;
	}
	public void setExtraName(String extraName) {
		this.extraName = extraName;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	
	
}
