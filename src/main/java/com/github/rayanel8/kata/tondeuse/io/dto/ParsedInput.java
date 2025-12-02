package com.github.rayanel8.kata.tondeuse.io.dto;

import java.util.List;

import com.github.rayanel8.kata.tondeuse.domain.model.Pelouse;

public record ParsedInput(Pelouse pelouse, List<MowerData> mowers) {}
