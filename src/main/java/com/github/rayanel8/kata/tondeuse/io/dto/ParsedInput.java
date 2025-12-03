package com.github.rayanel8.kata.tondeuse.io.dto;

import java.util.List;

import com.github.rayanel8.kata.tondeuse.domain.model.Pelouse;


/**
 * Immutable structure representing all data parsed from the input file:
 * <ul>
 *   <li>the lawn dimensions ({@link Pelouse})</li>
 *   <li>the list of mowers with their initial configuration ({@link MowerData})</li>
 * </ul>
 *
 * This record is produced by {@link com.github.rayanel8.kata.tondeuse.io.FileParser}
 * and consumed by the application to run the mower simulation.
 */
public record ParsedInput(Pelouse pelouse, List<MowerData> mowers) {}
