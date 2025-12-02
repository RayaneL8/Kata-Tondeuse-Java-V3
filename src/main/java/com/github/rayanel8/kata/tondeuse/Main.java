package com.github.rayanel8.kata.tondeuse;

import com.github.rayanel8.kata.tondeuse.domain.model.Tondeuse;
import com.github.rayanel8.kata.tondeuse.service.InstructionProcessor;
import com.github.rayanel8.kata.tondeuse.io.FileParser;
import com.github.rayanel8.kata.tondeuse.io.dto.MowerData;
import com.github.rayanel8.kata.tondeuse.io.dto.ParsedInput;

public class Main {

    public static void main(String[] args) throws Exception {

        String fileName = (args.length > 0)
                ? args[0]
                : "input.txt"; 

        FileParser parser = new FileParser();
        ParsedInput data = parser.parse(fileName);

        InstructionProcessor processor = new InstructionProcessor();

        for (MowerData mower : data.mowers()) {
            Tondeuse tondeuse = new Tondeuse(mower.position(), mower.orientation());
            processor.executeInstructions(tondeuse, data.pelouse(), mower.instructions());
            
            System.out.print(tondeuse.getPosition().getX() + " ");
            System.out.print(tondeuse.getPosition().getY() + " ");
            System.out.print(tondeuse.getOrientation() + " ");
        }
    }
}
