package com.github.rayanel8.kata.tondeuse.domain.enums;

/**
 * Enumeration of the possible instructions a mower can execute:
 * <ul>
 * <li>{@code G} - rotate left (90° counterclockwise)</li>
 * <li>{@code D} - rotate right (90° clockwise)</li>
 * <li>{@code A} - move forward one step in the current orientation</li>
 * </ul>
 */

public enum Instruction {
	G, // Gauche
	D, // Droite
	A  // Avancer
}
