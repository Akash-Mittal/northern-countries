package com.api.country;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class APITest implements BASEAPI {

	@Test
	public void testIPDetails() {
		String ip[] = null;
		assertTrue(NOT_NULL.test(ip));
		String ip2[] = { "123", "313" };
		assertTrue(GREATER_THAN_MIN_IPS.test(ip2));
		assertTrue(LESS_THAN_MAX_IPS.test(ip2));
		String ip3[] = {};
		assertTrue(!GREATER_THAN_MIN_IPS.test(ip3));
		String ip4[] = { "123", "313", "2312", "1322", "1323", "12" };
		assertTrue(!LESS_THAN_MAX_IPS.test(ip4));
//		assertTrue(GREATER_THAN_LESS_THAN.test(ip));
		assertTrue(GREATER_THAN_LESS_THAN.test(ip2));
		assertTrue(!GREATER_THAN_LESS_THAN.test(ip3));
		assertTrue(!GREATER_THAN_LESS_THAN.test(ip4));
	}

}
