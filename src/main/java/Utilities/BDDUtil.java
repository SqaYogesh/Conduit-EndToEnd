package Utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class BDDUtil {
	
	protected BDDUtil() {
		
	}
	
	public static final String characters = "ABCDEFGHIJKLMNOPRSTUVXYZ";
	public static final String space = " ";

	public static String randomAutomatedComments() {
		return "Automated Comments - " + RandomStringUtils.random(Integer.parseInt(RandomStringUtils.randomNumeric(1)), characters) + " From Yogesh";
	}
	
	public static String randomAutomatedArticleTitle() {
		return "Automated Title - " + RandomStringUtils.random(Integer.parseInt(RandomStringUtils.randomNumeric(1)), characters) + " Yogesh";
	}
	
	public static String randomAutomatedArticleAbout() {
		return "This code is written by Yogesh for Testing purpose. " + RandomStringUtils.random(Integer.parseInt(RandomStringUtils.randomNumeric(1)), characters)
		+ space + RandomStringUtils.random(Integer.parseInt(RandomStringUtils.randomNumeric(1)), characters);
	}
	
	public static String randomAutomatedArticle() {
		return "This Article is published by Yogesh for Testing purpose. " + RandomStringUtils.random(Integer.parseInt(RandomStringUtils.randomNumeric(1)), characters)
		+ space + RandomStringUtils.random(Integer.parseInt(RandomStringUtils.randomNumeric(1)), characters)
		+ space + RandomStringUtils.random(Integer.parseInt(RandomStringUtils.randomNumeric(1)), characters)
		+ space + RandomStringUtils.random(Integer.parseInt(RandomStringUtils.randomNumeric(1)), characters)
		+ space + RandomStringUtils.random(Integer.parseInt(RandomStringUtils.randomNumeric(1)), characters)
		+ space + RandomStringUtils.random(Integer.parseInt(RandomStringUtils.randomNumeric(1)), characters)
		+ space + RandomStringUtils.random(Integer.parseInt(RandomStringUtils.randomNumeric(1)), characters)
		+ space + RandomStringUtils.random(Integer.parseInt(RandomStringUtils.randomNumeric(1)), characters)
		+ space + RandomStringUtils.random(Integer.parseInt(RandomStringUtils.randomNumeric(1)), characters);
	}
	
	public static String randomAutomatedTags() {
		return "Selenium, Cucumber BDD, Conduit Automation";
	}
}
