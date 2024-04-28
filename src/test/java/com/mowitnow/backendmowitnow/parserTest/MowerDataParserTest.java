package com.mowitnow.backendmowitnow.parserTest;

import org.junit.jupiter.api.Test;

import com.mowitnow.backendmowitnow.exceptions.DataFormatException;
import com.mowitnow.backendmowitnow.exceptions.InvalidInstructionException;
import com.mowitnow.backendmowitnow.parser.MowerDataParser;
import static org.junit.jupiter.api.Assertions.*;

public class MowerDataParserTest {

    @Test
    public void testSetPelouse_ValidFormat_ShouldNotThrowException() {
        MowerDataParser parser = new MowerDataParser();
        assertDoesNotThrow(() -> parser.setLawn("5 5"));
    }

    @Test
    public void testSetPelouse_InvalidFormat_ShouldThrowDataFormatException() {
        MowerDataParser parser = new MowerDataParser();
        assertThrows(DataFormatException.class, () -> parser.setLawn("5 z"));
    }

    @Test
    public void testSetTondeuse_ValidFormat_ShouldNotThrowException() {
        MowerDataParser parser = new MowerDataParser();
        assertDoesNotThrow(() -> parser.setMower("1 2 N"));
    }

    @Test
    public void testSetTondeuse_InvalidFormat_ShouldThrowDataFormatException() {
        MowerDataParser parser = new MowerDataParser();
        assertThrows(DataFormatException.class, () -> parser.setMower("1 N 2"));
    }

    @Test
    public void testSetInstructions_ValidFormat_ShouldNotThrowException() {
        MowerDataParser parser = new MowerDataParser();
        assertDoesNotThrow(() -> parser.setInstructions("AADAADADDA"));
    }

    @Test
    public void testSetInstructions_InvalidFormat_ShouldThrowInvalidInstructionException() {
        MowerDataParser parser = new MowerDataParser();
        assertThrows(InvalidInstructionException.class, () -> parser.setInstructions("AAXA"));
    }
}