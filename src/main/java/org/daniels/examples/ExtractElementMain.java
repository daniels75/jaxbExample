package org.daniels.examples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ExtractElementMain {
	
	private static final String XML_FILE_EXAMPLE = "extr_example.xml";
	
	public static void main(String[] args) throws Exception {
		final ExtractElementMain main = new ExtractElementMain();
		final String content = main.readFile(XML_FILE_EXAMPLE).toString();
		
		System.out.println(content);
		
		System.out.println("Extracted from XML: " + main.extractElementFromContent(content, "Currency"));
	}

	protected String extractElementFromContent(final String content, final String elementName) throws Exception{
		final Element rootElement = createRootElementForContent(content);
		return getStringElement(elementName, rootElement);
	}
	
	
	protected Element createRootElementForContent(final String content)
			throws ParserConfigurationException, SAXException, IOException {
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		final DocumentBuilder builder = factory.newDocumentBuilder();
		final Document document = builder.parse(new InputSource(new StringReader(content)));
		final Element rootElement = document.getDocumentElement();
		return rootElement;
	}
	
	protected String getStringElement(String tagName, Element element) {
        NodeList list = element.getElementsByTagName(tagName);
        if (list != null && list.getLength() > 0) {
            NodeList subList = list.item(0).getChildNodes();

            if (subList != null && subList.getLength() > 0) {
                return subList.item(0).getNodeValue();
            }
        }

        return null;
    }
	
	
	public StringBuilder readFile(final String fileName) throws FileNotFoundException {

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
