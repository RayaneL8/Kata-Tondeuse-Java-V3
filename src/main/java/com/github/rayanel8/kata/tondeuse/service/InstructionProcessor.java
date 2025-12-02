package com.github.rayanel8.kata.tondeuse.service;

import com.github.rayanel8.kata.tondeuse.domain.model.Pelouse;
import com.github.rayanel8.kata.tondeuse.domain.model.Tondeuse;

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
                    throw new IllegalArgumentException(
                            "Unknown instruction: " + instruction
                    );
            }
        }
    }
}