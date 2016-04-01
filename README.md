@XmlRootElement(name = "Subject")
//@XmlType(name = "Subject")
//@XmlAccessorType(XmlAccessType.NONE)
public class Subject  {

	@XmlElement(name = "ID")
	private int id;
	private String name;
	private int age;
	
	
	
Because it will fail and you got an error like:

Exception in thread "main" com.sun.xml.internal.bind.v2.runtime.IllegalAnnotationsException: 1 counts of IllegalAnnotationExceptions
Class has two properties of the same name "id"
	this problem is related to the following location:
		at public int org.daniels.examples.subjects.Subject.getId()
		at org.daniels.examples.subjects.Subject
		at private org.daniels.examples.subjects.Subject org.daniels.examples.subjects.SubjectWrapper.subject
		at org.daniels.examples.subjects.SubjectWrapper
	this problem is related to the following location:
		at private int org.daniels.examples.subjects.Subject.id
		at org.daniels.examples.subjects.Subject
		at private org.daniels.examples.subjects.Subject org.daniels.examples.subjects.SubjectWrapper.subject
		at org.daniels.examples.subjects.SubjectWrapper

	at com.sun.xml.internal.bind.v2.runtime.IllegalAnnotationsException$Builder.check(IllegalAnnotationsException.java:91)
	at com.sun.xml.internal.bind.v2.runtime.JAXBContextImpl.getTypeInfoSet(JAXBContextImpl.java:445)
	at com.sun.xml.internal.bind.v2.runtime.JAXBContextImpl.<init>(JAXBContextImpl.java:277)
	at com.sun.xml.internal.bind.v2.runtime.JAXBContextImpl.<init>(JAXBContextImpl.java:124)
	at com.sun.xml.internal.bind.v2.runtime.JAXBContextImpl$JAXBContextBuilder.build(JAXBContextImpl.java:1123)
	at com.sun.xml.internal.bind.v2.ContextFactory.createContext(ContextFactory.java:147)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:497)
	at javax.xml.bind.ContextFinder.newInstance(ContextFinder.java:247)
	at javax.xml.bind.ContextFinder.newInstance(ContextFinder.java:234)
	at javax.xml.bind.ContextFinder.find(ContextFinder.java:462)
	at javax.xml.bind.JAXBContext.newInstance(JAXBContext.java:641)
	at javax.xml.bind.JAXBContext.newInstance(JAXBContext.java:584)
	at org.daniels.examples.subjects.SubjectMain.main(SubjectMain.java:15)

	
-------------------

1st Option is

@XmlAccessorType(XmlAccessType.NONE)
and
@XmlElement or @XmlAttribute

2nd Option is

you NOT provide
@XmlAccessorType(XmlAccessType.NONE)

and NOT provide	
@XmlElement or @XmlAttribute	