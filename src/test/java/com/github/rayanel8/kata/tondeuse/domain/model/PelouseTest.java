package com.github.rayanel8.kata.tondeuse.domain.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PelouseTest {

	@Test
	void shouldStoreMaximumCoordinates() {
		Pelouse pelouse = new Pelouse(5, 7);

		assertEquals(5, pelouse.getMaxX());
		assertEquals(7, pelouse.getMaxY());
	}
}