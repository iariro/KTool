package ktool.datetime.test;

import java.text.*;
import java.util.*;
import junit.framework.*;
import ktool.datetime.*;

/**
 * DateTime クラスのテスト
 *
 * $Id: KDateTimeTest.java,v 1.4 2009/10/08 12:19:20 kumagai Exp $
 */
public class DateTimeTest
	extends TestCase
{
	public void testKDateTime1()
	{
		DateTime datetime = new DateTime(2009, 8, 21, 12, 34, 56);

		assertEquals(2009, datetime.getYear());
		assertEquals(8, datetime.getMonth());
		assertEquals(21, datetime.getDay());
		assertEquals(12, datetime.getHour());
		assertEquals(34, datetime.getMinute());
		assertEquals(56, datetime.getSecond());
	}

	public void testKDateTime2()
	{
		DateTime datetime =
			new DateTime(
				new Date((
					14477 * 86400 - 32400 +
					(((12 * 60) + 34) * 60 + 56)) * 1000L));

		assertEquals(2009, datetime.getYear());
		assertEquals(8, datetime.getMonth());
		assertEquals(21, datetime.getDay());
		assertEquals(12, datetime.getHour());
		assertEquals(34, datetime.getMinute());
		assertEquals(56, datetime.getSecond());
	}

	public void testKDateTime3()
	{
		DateTime datetime =
			new DateTime(new DateTime(2009, 8, 21, 12, 34, 56));

		assertEquals(2009, datetime.getYear());
		assertEquals(8, datetime.getMonth());
		assertEquals(21, datetime.getDay());
		assertEquals(12, datetime.getHour());
		assertEquals(34, datetime.getMinute());
		assertEquals(56, datetime.getSecond());
	}

	public void testKDateTime4()
	{
		try
		{
			new DateTime((DateTime)null);
			fail();
		}
		catch(NullPointerException exception)
		{
		}
	}

	public void testKDateTime5()
	{
		TimeZone timezone = TimeZone.getTimeZone("GMT");
		System.out.println(timezone.getDisplayName());
		DateTime datetime = new DateTime(1970, 1, 1, 0, 0, 0, timezone);
		System.out.println(datetime.toFullString());
	}

	public void testSet()
	{
		DateTime datetime2 =
			new DateTime(new DateTime(2009, 8, 21, 12, 34, 56));

		DateTime datetime = new DateTime();

		datetime.set(datetime2);

		assertEquals(2009, datetime.getYear());
		assertEquals(8, datetime.getMonth());
		assertEquals(21, datetime.getDay());
		assertEquals(12, datetime.getHour());
		assertEquals(34, datetime.getMinute());
		assertEquals(56, datetime.getSecond());
	}

	public void testCompareTo1()
	{
		DateTime datetime1 = new DateTime(2009, 8, 21, 12, 34, 55);
		DateTime datetime2 = new DateTime(2009, 8, 21, 12, 34, 56);

		assertTrue(datetime1.compareTo(datetime2) < 0);
	}

	public void testCompareTo2()
	{
		DateTime datetime1 = new DateTime(2009, 8, 21, 12, 34, 56);
		DateTime datetime2 = new DateTime(2009, 8, 21, 12, 34, 56);

		assertTrue(datetime1.compareTo(datetime2) == 0);
	}

	public void testCompareTo3()
	{
		DateTime datetime1 = new DateTime(2009, 8, 21, 12, 34, 56);
		DateTime datetime2 = new DateTime(2009, 8, 21, 12, 34, 55);

		assertTrue(datetime1.compareTo(datetime2) > 0);
	}

	public void testDiff1()
	{
		DateTime datetime1 = new DateTime(2009, 9, 4, 7, 0, 0);
		DateTime datetime2 = new DateTime(2009, 8, 10, 7, 0, 0);

		assertEquals(600, datetime1.diff(datetime2).getHour());
	}

	public void testDiff2()
	{
		DateTime datetime1 = new DateTime(2009, 1, 1, 1, 34, 56);
		DateTime datetime2 = new DateTime(2008, 12, 31, 12, 34, 56);

		assertEquals(13, datetime1.diff(datetime2).getHour());
	}

	public void testDiff()
	{
		DateTime datetime1 = new DateTime(2009, 1, 21, 0, 0, 0);
		DateTime datetime2 = new DateTime(2009, 1, 1, 0, 0, 0);

		assertEquals(24 * 20, datetime1.diff(datetime2).getHour());
	}

	public void testToString()
	{
		assertEquals(
			"2009/08/21 12:34:56",
			new DateTime(2009, 8, 21, 12, 34, 56).toFullString());
	}

	public void testConstruct1()
		throws ParseException
	{
		assertEquals(
			"2012/09/16 00:00:00",
			DateTime.parseDateString("2012/09/16").toFullString());
	}

	public void testSetDay()
		throws ParseException
	{
		DateTime dateTime = DateTime.parseDateString("2012/09/16");

		dateTime.setDay(1);

		assertEquals("2012/09/01 00:00:00", dateTime.toFullString());

		dateTime.add(TimeSpan.createByDay(1));

		assertEquals("2012/09/02 00:00:00", dateTime.toFullString());
	}

	public void testSetMonth()
		throws ParseException
	{
		DateTime dateTime = DateTime.parseDateString("2012/09/16");

		dateTime.setMonth(1);

		assertEquals("2012/01/16 00:00:00", dateTime.toFullString());
	}

	public void testAdd1()
	{
		DateTime datetime =
			new DateTime(new DateTime(2009, 8, 21, 12, 34, 56));

		datetime.add(new TimeSpan(1000 * 86400 * 5));
		assertEquals(2009, datetime.getYear());
		assertEquals(8, datetime.getMonth());
		assertEquals(26, datetime.getDay());
		assertEquals(12, datetime.getHour());
		assertEquals(34, datetime.getMinute());
		assertEquals(56, datetime.getSecond());
	}

	public void testAddDay()
		throws ParseException
	{
		DateTime date = DateTime.parseDateString("2015/11/11");

		date.addDay(1);
		assertEquals("2015/11/12", date.toString());
		date.addDay(20);
		assertEquals("2015/12/02", date.toString());
	}
}
