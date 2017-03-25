package com.localyokel.yokel;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by 7201363 on 3/25/2017.
 */

public class XmlParser {

    public void parse()
    {
        /*
        try {
            URL url = new URL("172.16.8.117");//your xml url
            URLConnection conn = url.openConnection();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(conn.getInputStream());

            NodeList nodes = doc.getElementsByTagName();//tag from xml file
            for (int i = 0; i < nodes.getLength(); i++) {
                Element element = (Element) nodes.item(i);
                NodeList title = element.getElementsByTagName();//item within the tag
                Element line = (Element) title.item(0);
                //phoneNumberList.add(line.getTextContent());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        */
    }
}
