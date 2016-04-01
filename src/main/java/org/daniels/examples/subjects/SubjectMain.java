package org.daniels.examples.subjects;

import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class SubjectMain {
	public static void main(String[] args) throws Exception {

		Subject subject = createSubject();
		ExtendedSubject extendedSubject = createExtendedSubject();
		
		SubjectWrapper subjectWrapper = new SubjectWrapper();
		subjectWrapper.setSubject(extendedSubject);

		JAXBContext jaxbContext = JAXBContext.newInstance(SubjectWrapper.class, Subject.class, ExtendedSubject.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(subjectWrapper, System.out);

	}

	private static Subject createSubject() {
		Subject subject = new Subject();
		subject.setId(100);
		subject.setName("daniels");
		subject.setAge(29);
		return subject;
	}
	
	private static ExtendedSubject createExtendedSubject() {
		ExtendedSubject subject = new ExtendedSubject();
		subject.setId(100);
		subject.setName("daniels");
		subject.setAge(29);
		subject.setCreated(new Date());
		subject.setExtraName("some extra name");
		
		final String formatedDate = String.format("%1$tFT%1$tT", subject.getCreated());
		subject.setCreatedStr(formatedDate);
		return subject;
	}
}
