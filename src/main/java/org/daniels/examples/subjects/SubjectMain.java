package org.daniels.examples.subjects;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class SubjectMain {
	public static void main(String[] args) throws Exception {

		Subject subject = createSubject();

		JAXBContext jaxbContext = JAXBContext.newInstance(Subject.class, SubSubject.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(subject, System.out);

	}

	private static Subject createSubject() {
		SubSubject subject = new SubSubject();
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
