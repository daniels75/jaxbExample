package org.daniels.examples;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Currency")
@XmlAccessorType(XmlAccessType.NONE)
public class Currency implements Serializable{
    
    @XmlElement(name = "Name")
    private String name;

    public Currency(){
        
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	@Override
	public String toString() {
		return "Currency [name=" + name + "]";
	}
    
    
    

}