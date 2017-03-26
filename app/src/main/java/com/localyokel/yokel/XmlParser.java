package com.localyokel.yokel;

import android.support.annotation.NonNull;

import com.localyokel.yokel.ListItems.OrderContent;
import com.localyokel.yokel.ListItems.OrderContent.OrderItem;
import com.localyokel.yokel.ListItems.PackageContent;
import com.localyokel.yokel.ListItems.PackageContent.PackageItem;
import com.localyokel.yokel.ListItems.GrowerContent.GrowerItem;

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

    public OrderContent.OrderItem[] parseOrders()
    {
        OrderContent.OrderItem[] items = null;

        try {
            URL url = new URL("http://104.198.36.229/XML/order.xml");//your xml url
            URLConnection conn = url.openConnection();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(conn.getInputStream());

            NodeList nodes = doc.getElementsByTagName("Order");//tag from xml file
            items = new OrderItem[nodes.getLength()];

            for (int i = 0; i < nodes.getLength(); i++) {

                OrderItem item = new OrderItem();

                Element element = (Element) nodes.item(i);
                NodeList title = element.getElementsByTagName("PackageName");//item within the tag
                Element line = (Element) title.item(0);

                item.packageName = line.getTextContent().trim();

                title = element.getElementsByTagName("Summary");//item within the tag
                line = (Element) title.item(0);

                item.summary = line.getTextContent().trim();

                title = element.getElementsByTagName("DeliveryDate");//item within the tag
                line = (Element) title.item(0);

                item.deliveryDate = line.getTextContent().trim();

                title = element.getElementsByTagName("Price");//item within the tag
                line = (Element) title.item(0);

                item.price = line.getTextContent().trim();

                items[i] = item;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return items;
    }


    public GrowerItem[] parseGrowers()
    {
        GrowerItem[] items = null;

        try {
            URL url = new URL("http://104.198.36.229/XML/grower.xml");//your xml url
            URLConnection conn = url.openConnection();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(conn.getInputStream());

            NodeList nodes = doc.getElementsByTagName("Grower");//tag from xml file
            items = new GrowerItem[nodes.getLength()];

            for (int i = 0; i < nodes.getLength(); i++) {

                GrowerItem item = new GrowerItem();

                Element element = (Element) nodes.item(i);
                NodeList title = element.getElementsByTagName("Name");//item within the tag
                Element line = (Element) title.item(0);

                item.name = line.getTextContent().trim();

                title = element.getElementsByTagName("Description");//item within the tag
                line = (Element) title.item(0);

                item.description = line.getTextContent().trim();

                title = element.getElementsByTagName("Produce");//item within the tag
                line = (Element) title.item(0);

                item.produces = line.getTextContent().trim();

                title = element.getElementsByTagName("Location");//item within the tag
                line = (Element) title.item(0);

                item.location = line.getTextContent().trim();

                items[i] = item;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return items;
    }
}
