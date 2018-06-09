package numtowords;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NTWAppTest {
	
	private NTWApp app;
	
	@Before
	public void setup() throws Exception{
		app = new NTWApp();
	}

	@Test
	public void testIsNumeric() {
		Assert.assertTrue(app.isNumeric("0"));
		Assert.assertTrue(app.isNumeric("10"));
		Assert.assertFalse(app.isNumeric("a"));
		Assert.assertFalse(app.isNumeric("0a"));
		Assert.assertFalse(app.isNumeric("A0"));
		Assert.assertFalse(app.isNumeric("-0"));
		Assert.assertFalse(app.isNumeric("0.5"));
	}

	@Test
	public void process20To100Test() {
		Assert.assertTrue("Twenty One".equals(app.process20To100(21).trim()));
	}
	@Test
	public void process1To19Test() {
		Assert.assertTrue("Nineteen".equals(app.process1To19("19").trim()));
	}
	
	@Test
	public void getWordsForPosTest() {
		Assert.assertTrue(app.getWordsForPos(3, true).trim().equals("Hundred"));
	}
	@Test
	public void numToEnglishTest() {
		Assert.assertTrue(app.numToEnglish("100").trim().equals("One Hundred"));
		Assert.assertTrue(app.numToEnglish("10").trim().equals("Ten"));
		Assert.assertTrue(app.numToEnglish("101").trim().equals("One Hundred One"));
		Assert.assertTrue(app.numToEnglish("111").trim().equals("One Hundred Eleven"));
		Assert.assertTrue(app.numToEnglish("1110").trim().equals("One Thousand One Hundred Ten"));
		Assert.assertTrue(app.numToEnglish("1111").trim().equals("One Thousand One Hundred Eleven"));
		Assert.assertTrue(app.numToEnglish("123456789").trim().equals("One Hundred Twenty Three Million "
				+ "Four Hundred Fifty Six Thousand Seven Hundred Eighty Nine" + 
				""));
		Assert.assertTrue(app.numToEnglish("1234567890123").trim().equals("One Trillion Two Hundred "
				+ "Thirty Four Billion Five Hundred Sixty Seven Million Eight Hundred Ninety Thousand "
				+ "One Hundred Twenty Three"));
		Assert.assertTrue(app.numToEnglish("0").trim().equals("Zero"));
		Assert.assertTrue(app.numToEnglish("13").trim().equals("Thirteen"));
		Assert.assertTrue(app.numToEnglish("85").trim().equals("Eighty Five"));
		Assert.assertTrue(app.numToEnglish("5237").trim().equals("Five Thousand Two Hundred Thirty Seven"));
		Assert.assertTrue(app.numToEnglish("100001").trim().equals("One Hundred Thousand One"));
	}
	@Test
	public void executeTest() {
		String s = "10000001";
		InputStream is = new ByteArrayInputStream(s.getBytes());
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		System.setIn(is);
		app.execute();
		Assert.assertTrue( outContent.toString().trim().contains("Ten Million One"));
		System.setOut(System.out);
		System.setIn(System.in);
	}
	@Test
	public void executeTest2() {
		String s = "10000001a";
		InputStream is = new ByteArrayInputStream(s.getBytes());
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		System.setIn(is);
		app.execute();
		Assert.assertTrue( outContent.toString().trim().contains("is not a valid number. Please enter a number."));
		System.setOut(System.out);
		System.setIn(System.in);
		
	}
}
