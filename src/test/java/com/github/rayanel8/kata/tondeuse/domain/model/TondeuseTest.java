package com.github.rayanel8.kata.tondeuse.domain.model;

import com.github.rayanel8.kata.tondeuse.domain.enums.Orientation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TondeuseTest {

	@ParameterizedTest
	@CsvSource({ 
		"N, W", 
		"E, N", 
		"S, E", 
		"W, S"
	})
	void rotateLeftShouldFollowCorrectOrientation(Orientation initial, Orientation expected) {
		Tondeuse tondeuse = new Tondeuse(new Position(1, 2), initial);

		tondeuse.rotateLeft();

		assertEquals(expected, tondeuse.getOrientation());
	}

	@ParameterizedTest
	@CsvSource({ 
		"N, E", 
		"E, S", 
		"S, W", 
		"W, N"
	})
	void rotateRightShouldFollowCorrectOrientation(Orientation initial, Orientation expected) {
		Tondeuse tondeuse = new Tondeuse(new Position(3, 2), initial);

		tondeuse.rotateRight();

		assertEquals(expected, tondeuse.getOrientation());
	}

	@ParameterizedTest
	@CsvSource({ 
		"N, 1, 2, 1, 3",
		"E, 1, 2, 2, 2",
		"S, 1, 2, 1, 1",
		"W, 1, 2, 0, 2"
	})
	void advanceShouldMoveOneCellForward(Orientation orientation, int startX, int startY, int expectedX,
			int expectedY) {

		Pelouse pelouse = new Pelouse(5, 5);
		Tondeuse tondeuse = new Tondeuse(new Position(startX, startY), orientation);

		tondeuse.moveForward(pelouse);

		assertEquals(expectedX, tondeuse.getPosition().getX());
		assertEquals(expectedY, tondeuse.getPosition().getY());
	}

	@ParameterizedTest
	@CsvSource({
		"N, 0, 5",
		"E, 5, 0",
		"S, 0, 0",
		"W, 0, 0"
	})
	void advanceShouldNotMoveOutsidePelouse(Orientation orientation, int startX, int startY) {
		Pelouse pelouse = new Pelouse(5, 5);
		Position initial = new Position(startX, startY);
		Tondeuse tondeuse = new Tondeuse(initial, orientation);

		tondeuse.moveForward(pelouse);

		assertEquals(initial.getX(), tondeuse.getPosition().getX());
		assertEquals(initial.getY(), tondeuse.getPosition().getY());
	}

}