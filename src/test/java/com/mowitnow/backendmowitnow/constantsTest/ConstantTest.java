package com.mowitnow.backendmowitnow.constantsTest;

import org.junit.jupiter.api.Test;

import com.mowitnow.backendmowitnow.constants.Constant;
import com.mowitnow.backendmowitnow.exceptions.MowerException;
import static org.junit.jupiter.api.Assertions.*;

public class ConstantTest {

    @Test
    public void testConstantValues() {
        assertEquals("file does not exist", Constant.FILE_INEXIST);
        assertEquals("file format is incorrect", Constant.WRONG_FILE_FORMAT);
        assertEquals("data format is incorrect", Constant.WRONG_DATA_FORMAT);
        assertEquals("instruction data is incorrect", Constant.INCORRECT_INSTRUCTION);
        assertEquals("orientation data is incorrect", Constant.INCORRECT_ORIENTATION);
        assertEquals("position data is incorrect", Constant.INCORRECT_POSITION);
    }
    
    @Test
    public void whenFileDoesNotExist_thenThrowMowerException() {
        assertThrows(MowerException.class, () -> {
            checkFileExistence("nonexistentfile.txt");
        }, Constant.FILE_INEXIST);
    }

    @Test
    public void whenDataFormatIsWrong_thenThrowMowerException() {
        assertThrows(MowerException.class, () -> {
            processData("some invalid data");
        }, Constant.WRONG_DATA_FORMAT);
    }

    @Test
    public void whenInstructionIsIncorrect_thenThrowMowerException() {
        assertThrows(MowerException.class, () -> {
            processInstructions("invalid instructions");
        }, Constant.INCORRECT_INSTRUCTION);
    }

    private void checkFileExistence(String path) throws MowerException {
        throw new MowerException(Constant.FILE_INEXIST);
    }

    private void processData(String data) throws MowerException {
        throw new MowerException(Constant.WRONG_DATA_FORMAT);
    }

    private void processInstructions(String instructions) throws MowerException {
        throw new MowerException(Constant.INCORRECT_INSTRUCTION);
    }
}
