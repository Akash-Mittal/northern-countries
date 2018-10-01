package com.api.country;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

import com.api.country.exception.ValidationException;

public class APITest implements BASEAPI {

	@Test
	public void testValidIPList() {
		String ip2[] = { "123", "313" };
		assertTrue(CHECK_IF_IPS_IS_GREATER_THAN_0_LESS_THAN_5.test(ip2));
	}

	@Test(expected = ValidationException.class)
	public void testNullIPList() {
		String ip[] = null;
		assertTrue(CHECK_IF_IPS_IS_GREATER_THAN_0_LESS_THAN_5.test(ip));
	}

	@Test(expected = ValidationException.class)
	public void testIPDetailsWhenArrayIsEmpty() {
		String ip3[] = {};
		CHECK_IF_IPS_IS_GREATER_THAN_0_LESS_THAN_5.test(ip3);

	}

	@Test(expected = ValidationException.class)
	public void testIPDetailsWhenArraySizeIsMoreThanFize() {
		String ip4[] = { "123", "313", "2312", "1322", "1323", "12" };
		CHECK_IF_IPS_IS_GREATER_THAN_0_LESS_THAN_5.test(ip4);
	}

	@Test
	public void testIsNortherCountry() {
		BigDecimal latitude = null;
		latitude = BigDecimal.ONE;
		assertTrue(CHECKIFLATITUDEINNORTHERN.test(latitude));
		latitude = BigDecimal.ZERO;
		assertTrue(CHECKIFLATITUDEINNORTHERN.test(latitude));
		latitude = new BigDecimal("90");
		assertTrue(CHECKIFLATITUDEINNORTHERN.test(latitude));
		latitude = new BigDecimal("37.38600"); // For US
		assertTrue(CHECKIFLATITUDEINNORTHERN.test(latitude));
		latitude = new BigDecimal("-1");
		assertTrue(!CHECKIFLATITUDEINNORTHERN.test(latitude));
		latitude = new BigDecimal("-1333");
		assertTrue(!CHECKIFLATITUDEINNORTHERN.test(latitude));
		latitude = new BigDecimal("90.1");
		assertTrue(!CHECKIFLATITUDEINNORTHERN.test(latitude));
		latitude = new BigDecimal("100");
		assertTrue(!CHECKIFLATITUDEINNORTHERN.test(latitude));
		latitude = new BigDecimal("10000000");
		assertTrue(!CHECKIFLATITUDEINNORTHERN.test(latitude));
		latitude = new BigDecimal(
				"100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
		assertTrue(!CHECKIFLATITUDEINNORTHERN.test(latitude));

	}

}
