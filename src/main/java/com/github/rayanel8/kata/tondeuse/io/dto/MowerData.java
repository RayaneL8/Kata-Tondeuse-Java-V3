package com.github.rayanel8.kata.tondeuse.io.dto;

import com.github.rayanel8.kata.tondeuse.domain.enums.Orientation;
import com.github.rayanel8.kata.tondeuse.domain.model.Position;

public record MowerData(Position position, Orientation orientation, String instructions) {}
