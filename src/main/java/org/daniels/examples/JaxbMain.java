package org.daniels.examples;

import static javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JaxbMain {

	private static final String JAXB_FILE_NAME = "example.xml";
	JAXBContext context;
	
	public static void main(String[] args) throws Exception {
		JaxbMain serializer = new JaxbMain();
		final Currency currency = new Currency();
		currency.setName("EUR");
		
		final String marshalledStr = serializer.marshall(JAXB_FILE_NAME, currency);
		System.out.println(marshalledStr);
		
		final Object unmarshaledObj1 = serializer.unmarshallFromFile(JAXB_FILE_NAME);
		System.out.println(unmarshaledObj1);
		
		final String exampleStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Currency><Name>EUR</Name></Currency>";
		final String jaxbStr = serializer.readFile(JAXB_FILE_NAME).toString();
		final Object unmarshaledObj2 = serializer.unmarshallFromString(jaxbStr);
		System.out.println(unmarshaledObj2);
	}

	

	public JaxbMain() throws JAXBException {
		context = JAXBContext.newInstance(Currency.class);
	}

	private String marshall(final String fileName, Currency currency) throws JAXBException {


		Marshaller marshaller = context.createMarshaller();
		//marshaller.setProperty(JAXB_FORMATTED_OUTPUT, true);
		StringWriter writer = new StringWriter();
		marshaller.marshal(currency, writer);
		saveFile(writer.toString(), fileName);
		
		return writer.toString();
	}
	
	private Object unmarshallFromFile(final String fileName) throws JAXBException {
		final Unmarshaller unmarshaller = context.createUnmarshaller();
		final File jaxbFile = new File(fileName);
		return unmarshaller.unmarshal(jaxbFile);
	}
	
	private Object unmarshallFromString(final String content) throws JAXBException {
		final StringReader reader = new StringReader(content);
		final Unmarshaller unmarshaller = context.createUnmarshaller();
		return unmarshaller.unmarshal(reader);
	}

	public void saveFile(final String content, final String fileName) {
		URL url = getClass().getResource("");
		try {

			File file = new File(fileName);

			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

			System.out.println(">>>> Saved file to: " + file.getAbsolutePath());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public StringBuilder readFile(final String fileName) throws FileNotFoundException {
		// URL url = getClass().getResource("sample.in");
		// if (url.getPath() != null) {
		// System.out.println(url.getPath());
		// }

		final StringBuilder strBuilder = new StringBuilder();
		File file = new File(fileName);
		System.out.println(">>>> Read file from: " + file.getAbsolutePath());

		try (final BufferedReader br = new BufferedReader(new FileReader(file))) {

			String currentLine;

			while ((currentLine = br.readLine()) != null) {
				strBuilder.append(currentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return strBuilder;
	}
}
