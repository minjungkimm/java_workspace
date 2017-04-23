package xml;

import java.util.Vector;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler{
	int count=0;
	Model model;
	Vector vec= new Vector();
	
	public Handler(Model model) {
		this.model=model;
	}
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("문서 시작");
		
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//발견한 태그
		System.out.println("<"+qName+">");
		//System.out.println("\""+qName+"\":");
		model.columnName.add(qName);
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.println(new String(ch,start,length));
		vec.add(new String(ch,start,length));
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("</"+qName+">");
		model.data.add(vec);
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("담겨진 총 데이터는?"+model.data.size());
		System.out.println("문서 끝");
		
	}
	
}
