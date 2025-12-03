package com.github.rayanel8.kata.tondeuse.io;

import com.github.rayanel8.kata.tondeuse.domain.enums.Orientation;
import com.github.rayanel8.kata.tondeuse.domain.model.Pelouse;
import com.github.rayanel8.kata.tondeuse.domain.model.Position;
import com.github.rayanel8.kata.tondeuse.io.dto.MowerData;
import com.github.rayanel8.kata.tondeuse.io.dto.ParsedInput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileParser {

	private static final int FIRST_MOWER_LINE = 1;

	private static final int LINES_PER_MOWER = 2;

	private static final int INDEX_POSITION_X = 0;
	private static final int INDEX_POSITION_Y = 1;
	private static final int INDEX_ORIENTATION = 2;

	/**
	 * Parses an input file describing the lawn dimensions and the initial
	 * configuration of each mower (position, orientation and instruction list).
	 * <p>
	 * Expected file format:
	 * <ul>
	 * <li>First line: the lawn dimensions {@code maxX maxY}</li>
	 * <li>Then, for each mower:</li>
	 * <li>Line N: initial position and orientation {@code x y O}</li>
	 * <li>Line N+1: instruction string</li>
	 * </ul>
	 * <p>
	 * For each mower, its position, orientation and instruction sequence are
	 * extracted and stored so they can be processed later by the simulation logic.
	 *
	 * @param fileName the path to the input file to be parsed
	 * @return a {@link ParsedInput} object containing:
	 *         <ul>
	 *         <li>the lawn dimensions</li>
	 *         <li>a list of {@link MowerData} objects describing each mower</li>
	 *         </ul>
	 *         d
	 */
	public ParsedInput parse(String fileName) throws IOException {
		List<String> lines = Files.readAllLines(Path.of(fileName));

		// Lecture de la première ligne du fichier (c-à-d dimensions de la pelouse)
		String[] dimensionsAsString = lines.get(0).split(" ");
		final int maxX = Integer.parseInt(dimensionsAsString[0]);
		final int maxY = Integer.parseInt(dimensionsAsString[1]);
		Pelouse pelouse = new Pelouse(maxX, maxY);

		List<MowerData> mowers = new ArrayList<>();

		// Lecture des données de chaque tondeuse (2 lignes par tondeuse)
		for (int i = FIRST_MOWER_LINE; i < lines.size(); i += LINES_PER_MOWER) {
			final int positionLineNumber = i;
			final int instructionsLineNumber = i + 1;

			// Lecture de la position initiale de la tondeuse
			String[] positionAsString = lines.get(positionLineNumber).split(" ");

			final int positionX = Integer.parseInt(positionAsString[INDEX_POSITION_X]);
			final int positionY = Integer.parseInt(positionAsString[INDEX_POSITION_Y]);

			Position position = new Position(positionX, positionY);

			// Orientation initiale
			Orientation orientation = Orientation.valueOf(positionAsString[INDEX_ORIENTATION]);

			// Lecture des instructions de déplacement
			String instructions = lines.get(instructionsLineNumber).trim();

			// Stockage des données avant process des instructions
			mowers.add(new MowerData(position, orientation, instructions));
		}

		return new ParsedInput(pelouse, mowers);
	}
}
