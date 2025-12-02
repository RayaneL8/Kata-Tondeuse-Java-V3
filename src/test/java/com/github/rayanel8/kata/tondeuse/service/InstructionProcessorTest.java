package com.github.rayanel8.kata.tondeuse.service;

import org.junit.jupiter.api.Test;

import com.github.rayanel8.kata.tondeuse.domain.enums.Orientation;
import com.github.rayanel8.kata.tondeuse.domain.model.Pelouse;
import com.github.rayanel8.kata.tondeuse.domain.model.Position;
import com.github.rayanel8.kata.tondeuse.domain.model.Tondeuse;

import static org.junit.jupiter.api.Assertions.*;

class InstructionProcessorTest {

    @Test
    void shouldExecuteScenarioFromSubject() {

        Pelouse pelouse = new Pelouse(5, 5);
        InstructionProcessor processor = new InstructionProcessor();

        // --------------- Première tondeuse ---------------
        Tondeuse t1 = new Tondeuse(new Position(1, 2), Orientation.N);

        processor.executeInstructions(t1, pelouse, "GAGAGAGAA");

        assertEquals(1, t1.getPosition().getX());
        assertEquals(3, t1.getPosition().getY());
        assertEquals(Orientation.N, t1.getOrientation());
        
        // Résultat "1 3 N" attendu

        // --------------- Deuxième tondeuse ---------------
        Tondeuse t2 = new Tondeuse(new Position(3, 3), Orientation.E);

        processor.executeInstructions(t2, pelouse, "AADAADADDA");

        assertEquals(5, t2.getPosition().getX());
        assertEquals(1, t2.getPosition().getY());
        assertEquals(Orientation.E, t2.getOrientation());
        
        // Résultat "5 1 E" attendu
    }
}
