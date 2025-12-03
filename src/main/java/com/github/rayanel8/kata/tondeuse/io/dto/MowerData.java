package com.github.rayanel8.kata.tondeuse.io.dto;

import com.github.rayanel8.kata.tondeuse.domain.enums.Orientation;
import com.github.rayanel8.kata.tondeuse.domain.model.Position;


/**
 * Immutable data structure representing the initial configuration of a mower
 * as extracted from the input file.
 * <p>
 * It contains:
 * <ul>
 *   <li>its starting {@link Position}</li>
 *   <li>its initial {@link Orientation}</li>
 *   <li>the raw instruction sequence to execute</li>
 * </ul>
 *
 * Used by the {@code FileParser} to transfer parsed data to the application layer.
 */
public record MowerData(Position position, Orientation orientation, String instructions) {}
