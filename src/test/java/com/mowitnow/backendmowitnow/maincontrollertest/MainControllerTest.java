package com.mowitnow.backendmowitnow.maincontrollertest;

import org.junit.jupiter.api.Test;

import com.mowitnow.backendmowitnow.MainController;
import com.mowitnow.backendmowitnow.parser.MowerDataParser;
import com.mowitnow.backendmowitnow.utils.MowerUtils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

public class MainControllerTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@AfterEach
	public void restoreStreams() {
		System.setOut(originalOut);
	}

	@Test
	public void testRun_NoArguments_ShouldReturnErrorCode() {
		MainController controller = new MainController();
		int exitCode = controller.run();
		assertEquals(1, exitCode);
		assertTrue(outContent.toString().contains("Please provide the file path as an argument."));
	}

	@Test
	public void testRun_FileDoesNotExist_ShouldReturnErrorCode() {
		MainController controller = new MainController();
		int exitCode = controller.run("nonexistentfile.txt");
		assertEquals(1, exitCode);
		assertTrue(outContent.toString().contains("The specified file does not exist"));
	}

	@Test
	public void testLaunchFromParser() throws Exception {
		MowerDataParser parser = new MowerDataParser();
		parser.setLawn("5 5");
		parser.setMower("1 2 N");
		parser.setInstructions("GAGAGAGAA");

		MowerUtils.getLawnInfo("5 5");
		MowerUtils.getMowerInfo("1 2 N");
		MowerUtils.getInstructionsInfo("GAGAGAGAA");

		MainController controller = new MainController();

		Method method = MainController.class.getDeclaredMethod("launchFromParser", MowerDataParser.class);
		method.setAccessible(true);
		String result = (String) method.invoke(controller, parser);

		assertNotNull(result);
	}
}
