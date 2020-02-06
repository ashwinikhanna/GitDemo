package com.sqtl.selenium;

import java.io.FileInputStream;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.channels.ReadPendingException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLParsing {
	static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		System.out.println("login name= " + getObjectData("login", "login_id"));
		System.out.println("password= " +  getObjectData("login", "password"));
		System.out.println("login button= " + getObjectData("login", "login"));
		

	} //main
	
	public static String getObjectData(String PageElementTagName, String ElementName) throws ParserConfigurationException, SAXException, IOException {
		String 	XMLFile_ObjectData = "./src/actitime.xml";	
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		org.w3c.dom.Document document = builder.parse(new File(XMLFile_ObjectData));
		Element root = 	document.getDocumentElement();			
					
		NodeList departments =	root.getElementsByTagName("page");
		for(int i=0; i<departments.getLength(); i++) {
			Element department = (Element)departments.item(i);						
			String department1 = department.getAttribute("name");					
			
					if (department1.equals(PageElementTagName))	{
						NodeList groups = department.getElementsByTagName("uiobject");								
							for(int j=0; j<groups.getLength(); j++) {
								Element group = (Element)groups.item(j);
								String department2 = group.getAttribute("name");
								
								if (department2.equals(ElementName)){
									root.normalize();
									String body = group.getFirstChild().getNodeValue();			
																				
									return body;
									
									}			
								}
					}
			}
		return null;
	}

} //class
