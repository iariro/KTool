package ktool.string.test;

import java.text.*;
import junit.framework.*;
import ktool.string.*;

public class DateCollectionTest
	extends TestCase
{
	public void testFromCsv1()
		throws ParseException
	{
		Assert.assertEquals(
			"2014/01/01",
			DateCollection.fromCsv("2014/01/01").toShortString());
	}

	public void testFromCsv2()
		throws ParseException
	{
		Assert.assertEquals(
			"2014/01/01-2014/01/02",
			DateCollection.fromCsv("2014/01/01,2014/01/02").toShortString());
	}

	public void testFromCsv3()
		throws ParseException
	{
		Assert.assertEquals(
			"2014/01/01-2014/01/03",
			DateCollection.fromCsv("2014/01/01,2014/01/02,2014/01/03").toShortString());
	}

	public void testFromCsv4()
		throws ParseException
	{
		Assert.assertEquals(
			"2014/01/01,2014/01/03",
			DateCollection.fromCsv("2014/01/01,2014/01/03").toShortString());
	}

	public void testFromCsv5()
		throws ParseException
	{
		Assert.assertEquals(
			"2014/01/01-2014/01/02,2014/01/04",
			DateCollection.fromCsv("2014/01/01,2014/01/02,2014/01/04").toShortString());
	}

	public void testFromCsv6()
		throws ParseException
	{
		Assert.assertEquals(
			"2014/01/01-2014/01/03,2014/01/05",
			DateCollection.fromCsv("2014/01/01,2014/01/02,2014/01/03,2014/01/05").toShortString());
	}

	public void testFromCsv7()
		throws ParseException
	{
		Assert.assertEquals(
			"2014/01/01-2014/01/03,2014/01/05-2014/01/07",
			DateCollection.fromCsv("2014/01/01,2014/01/02,2014/01/03,2014/01/05,2014/01/06,2014/01/07").toShortString());
	}

	public void testFromCsv8()
		throws ParseException
	{
		Assert.assertEquals(
			"2013/12/31-2014/01/01",
			DateCollection.fromCsv("2013/12/31,2014/01/01").toShortString());
	}

	public void testFromHyphenAndComma1()
		throws ParseException
	{
		DateCollection dateCollection = DateCollection.fromHyphenAndComma("2014/04/09");
		Assert.assertEquals(1, dateCollection.size());
		Assert.assertEquals("2014/04/09", dateCollection.get(0));
	}

	public void testFromHyphenAndComma2()
		throws ParseException
	{
		DateCollection dateCollection = DateCollection.fromHyphenAndComma("2014/04/08-2014/04/09");
		Assert.assertEquals(2, dateCollection.size());
	}

	public void testFromHyphenAndComma3()
		throws ParseException
	{
		DateCollection dateCollection = DateCollection.fromHyphenAndComma("2014/04/01-2014/04/03,2014/04/09");
		Assert.assertEquals(4, dateCollection.size());
		Assert.assertEquals("2014/04/01", dateCollection.get(0));
		Assert.assertEquals("2014/04/02", dateCollection.get(1));
		Assert.assertEquals("2014/04/03", dateCollection.get(2));
		Assert.assertEquals("2014/04/09", dateCollection.get(3));
	}
}
