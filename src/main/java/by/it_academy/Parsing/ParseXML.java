package by.it_academy.Parsing;

import by.it_academy.Weather.Weather;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class ParseXML implements ParseFiles {
    private List<Weather> weather = new ArrayList<>();
    private String name = null, description = null;
    private String location = null;
    private int temp_max = 0, temp_min = 0, humidity = 0;

    @Override
    public List<Weather> read() {
        File file = new File("Weather.xml");
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
           Document document = documentBuilder.parse(new InputSource(String.valueOf(new URL("https://raw.githubusercontent.com/MaryiaDuk/weather/master/Weather.xml"))));
            NodeList locNodeList = document.getElementsByTagName("location");
            for (int k = 0; k < locNodeList.getLength(); k++) {
                if (locNodeList.item(k).getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) locNodeList.item(k);
                    location = element.getAttribute("name");
                    NodeList placesNodeList = document.getElementsByTagName("place");
                    for (int i = 0; i < placesNodeList.getLength(); i++) {
                        if (placesNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                            Element placesElement = (Element) placesNodeList.item(i);
                            NodeList childNodes = placesElement.getChildNodes();
                            for (int j = 0; j < childNodes.getLength(); j++) {
                                if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                                    Element childElement = (Element) childNodes.item(j);
                                    switch (childElement.getNodeName()) {
                                        case "name": {
                                            name = childElement.getTextContent();
                                        }
                                        break;
                                        case "temp_max": {
                                            temp_max = Integer.valueOf(childElement.getTextContent());
                                        }
                                        break;
                                        case "temp_min": {
                                            temp_min = Integer.valueOf(childElement.getTextContent());
                                        }
                                        break;
                                        case "humidity": {
                                            humidity = Integer.valueOf(childElement.getTextContent());
                                        }
                                        break;
                                        case "description": {
                                            description = childElement.getTextContent();
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                        weather.add(new Weather(location, name, temp_max, temp_min, humidity, description));
                    }
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return weather;
    }
}