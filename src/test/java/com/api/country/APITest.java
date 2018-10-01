package com.api.country;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

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

	@Test
	public void testIsNortherCountry() {
		BigDecimal latitude = null;
		assertTrue(NOT_NULL.test(latitude));
		latitude = BigDecimal.ONE;
		assertTrue(IFLATITUDEINNORTHERN.test(latitude));
		latitude = BigDecimal.ZERO;
		assertTrue(IFLATITUDEINNORTHERN.test(latitude));
		latitude = new BigDecimal("90");
		assertTrue(IFLATITUDEINNORTHERN.test(latitude));
		latitude = new BigDecimal("45");
		assertTrue(IFLATITUDEINNORTHERN.test(latitude));
		latitude = new BigDecimal("-1");
		assertTrue(!IFLATITUDEINNORTHERN.test(latitude));
		latitude = new BigDecimal("-1333");
		assertTrue(!IFLATITUDEINNORTHERN.test(latitude));
		latitude = new BigDecimal("90.1");
		assertTrue(!IFLATITUDEINNORTHERN.test(latitude));
		latitude = new BigDecimal("100");
		assertTrue(!IFLATITUDEINNORTHERN.test(latitude));
		latitude = new BigDecimal("10000000");
		assertTrue(!IFLATITUDEINNORTHERN.test(latitude));
		latitude = new BigDecimal(
				"100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
		assertTrue(!IFLATITUDEINNORTHERN.test(latitude));

	}

}
