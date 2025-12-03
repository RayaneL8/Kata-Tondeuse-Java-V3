package com.github.rayanel8.kata.tondeuse.io;

import com.github.rayanel8.kata.tondeuse.domain.enums.Orientation;
import com.github.rayanel8.kata.tondeuse.domain.model.Pelouse;
import com.github.rayanel8.kata.tondeuse.io.dto.MowerData;
import com.github.rayanel8.kata.tondeuse.io.dto.ParsedInput;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class FileParserTest {

	@Test
	void shouldParseInputFileCorrectly() throws Exception {

		FileParser parser = new FileParser();
		String filePath = Paths.get("src", "test", "resources", "input.txt").toString();

		ParsedInput parsed = parser.parse(filePath);

		Pelouse pelouse = parsed.pelouse();
		assertEquals(5, pelouse.getMaxX());
		assertEquals(5, pelouse.getMaxY());

		// Tondeuse 1
		MowerData t1 = parsed.mowers().get(0);
		assertEquals(1, t1.position().getX());
		assertEquals(2, t1.position().getY());
		assertEquals(Orientation.N, t1.orientation());
		assertEquals("GAGAGAGAA", t1.instructions());

		// Tondeuse 2
		MowerData t2 = parsed.mowers().get(1);
		assertEquals(3, t2.position().getX());
		assertEquals(3, t2.position().getY());
		assertEquals(Orientation.E, t2.orientation());
		assertEquals("AADAADADDA", t2.instructions());
	}
}
