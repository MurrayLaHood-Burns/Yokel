package com.localyokel.yokel;

import android.support.annotation.NonNull;

import com.localyokel.yokel.ListItems.PackageContent;
import com.localyokel.yokel.ListItems.PackageContent.PackageItem;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.net.URL;
import java.net.URLConnection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by 7201363 on 3/25/2017.
 */

public class XmlParser {

    public PackageItem[] parsePackages()
    {

        PackageItem[] packageItems = null;

        try {
            URL url = new URL("http://104.198.36.229/XML/package.xml");//your xml url
            URLConnection conn = url.openConnection();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(conn.getInputStream());

            NodeList nodes = doc.getElementsByTagName("Package");//tag from xml file
            packageItems = new PackageItem[nodes.getLength()];

            for (int i = 0; i < nodes.getLength(); i++) {

                PackageItem packageItem = new PackageItem();

                Element element = (Element) nodes.item(i);
                NodeList title = element.getElementsByTagName("Name");//item within the tag
                Element line = (Element) title.item(0);

                packageItem.name = line.getTextContent();

                title = element.getElementsByTagName("Description");//item within the tag
                line = (Element) title.item(0);

                packageItem.description = line.getTextContent();

                title = element.getElementsByTagName("Ingredients");//item within the tag
                line = (Element) title.item(0);

                packageItem.ingredients = line.getTextContent();

                title = element.getElementsByTagName("Price");//item within the tag
                line = (Element) title.item(0);

                packageItem.price = line.getTextContent();

                packageItems[i] = packageItem;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return packageItems;
    }
}
