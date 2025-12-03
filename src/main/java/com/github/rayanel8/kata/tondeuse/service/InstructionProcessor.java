package com.github.rayanel8.kata.tondeuse.service;

import com.github.rayanel8.kata.tondeuse.domain.model.Pelouse;
import com.github.rayanel8.kata.tondeuse.domain.model.Tondeuse;

/**
 * Service responsible for executing a sequence of movement instructions on a
 * given {@link Tondeuse}.
 * <p>
 * Each instruction is interpreted and applied in order:
 * <ul>
 * <li>{@code G} - rotate the mower 90° to the left</li>
 * <li>{@code D} - rotate the mower 90° to the right</li>
 * <li>{@code A} - move the mower one step forward</li>
 * </ul>
 * The mower will only advance if the resulting position remains inside the
 * limits of the {@link Pelouse}.
 * </p>
 *
 * This processor contains no parsing logic; it receives already validated
 * domain objects and applies the corresponding instructions to mutate the state
 * of the mower.
 */
public class InstructionProcessor {

	public void executeInstructions(Tondeuse tondeuse, Pelouse pelouse, String instructions) {

		for (char instruction : instructions.toCharArray()) {

			switch (instruction) {
			case 'G':
				tondeuse.rotateLeft();
				break;

			case 'D':
				tondeuse.rotateRight();
				break;

			case 'A':
				tondeuse.moveForward(pelouse);
				break;

			default:
				throw new IllegalArgumentException("Unknown instruction: " + instruction);
			}
		}
	}
}