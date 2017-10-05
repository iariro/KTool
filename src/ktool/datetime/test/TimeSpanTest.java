package ktool.datetime.test;

import java.text.ParseException;

import junit.framework.TestCase;
import ktool.datetime.DateTime;
import ktool.datetime.TimeSpan;

public class TimeSpanTest
	extends TestCase
{
	public void test1()
	{
		TimeSpan timespan = new TimeSpan(123456789l);

		assertEquals(123456789, timespan.getTotalMillisecond());
	}

	public void test2() throws ParseException
	{
		TimeSpan timespan = new TimeSpan("12:34:56");

		assertEquals(12, timespan.getHour());
		assertEquals(34, timespan.getMinute());
		assertEquals(56, timespan.getSecond());
	}

	public void test3()
	{
		TimeSpan timespan = new TimeSpan(12, 34, 56);

		assertEquals(12, timespan.getHour());
		assertEquals(34, timespan.getMinute());
		assertEquals(56, timespan.getSecond());
	}

	public void test4()
	{
		TimeSpan timespan = new TimeSpan(12, 34, 56);

		assertEquals("12:34:56", timespan.toString());
	}

	public void test5()
	{
		TimeSpan timespan = new TimeSpan(12, 34, 56);

		assertEquals(0, timespan.getMillisecond());
	}

	public void test6()
	{
		TimeSpan timespan = new TimeSpan(1000 * 86400);

		assertEquals(86400, timespan.getTotalSecond());
	}

	public void testCompare1()
	{
		TimeSpan timespan1 = new TimeSpan(12, 34, 56);
		TimeSpan timespan2 = new TimeSpan(12, 34, 56);

		assertTrue(timespan1.compare(timespan2) == 0);
	}

	public void testCompare2()
	{
		TimeSpan timespan1 = new TimeSpan(12, 34, 56);
		TimeSpan timespan2 = new TimeSpan(12, 33, 56);

		assertTrue(timespan1.compare(timespan2) > 0);
	}

	public void testCompare3()
	{
		TimeSpan timespan1 = new TimeSpan(12, 34, 56);
		TimeSpan timespan2 = new TimeSpan(12, 35, 56);

		assertTrue(timespan1.compare(timespan2) < 0);
	}

	public void testDiff1()
	{
		TimeSpan timespan1 = new TimeSpan(12, 34, 56);
		TimeSpan timespan2 = new TimeSpan(12, 33, 56);

		assertEquals(60, timespan1.diff(timespan2).getTotalSecond());
	}

	public void testDiff2()
	{
		TimeSpan timespan1 = new TimeSpan(12, 34, 56);
		TimeSpan timespan2 = new TimeSpan(12, 35, 56);

		assertEquals(-60, timespan1.diff(timespan2).getTotalSecond());
	}

	public void testDiff3() throws ParseException
	{
		DateTime datetime1 = DateTime.parseDateTimeString("2017/10/05 11:22:33");
		DateTime datetime2 = DateTime.parseDateTimeString("2017/10/05 22:33:44");
		TimeSpan timespan = datetime1.diff(datetime2);
		assertEquals(-(3600 * 11 + 60 * 11 + 11), timespan.getTotalSecond());
		assertEquals("-11:11:11", timespan.toString());
	}
}
