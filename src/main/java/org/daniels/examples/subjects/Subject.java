package org.daniels.examples.subjects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Subject")
@XmlType(name = "Subject")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso(value = ExtendedSubject.class)
public  class Subject  {

	@XmlElement(name = "Id")
	private int id;
	@XmlElement(name = "Name")
	private String name;
	@XmlElement(name = "Age")
	private int age;

	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int getId() {
		return id;
	}



}