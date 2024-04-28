package com.mowitnow.backendmowitnow;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mowitnow.backendmowitnow.exceptions.DataFormatException;
import com.mowitnow.backendmowitnow.exceptions.MowerException;
import com.mowitnow.backendmowitnow.parser.MowerDataParser;
import com.mowitnow.backendmowitnow.services.MowerOperation;
import com.mowitnow.backendmowitnow.utils.MowerUtils;

public class MainController {
	protected static List<String> resultsList;

	public static void main(String... args) {
		MainController instance = new MainController();
		int result = instance.run(args);
		if (result != 0) {
			System.err.println("An error occurred during execution.");
		}
	}

	public int run(String... args) {
		if (args.length < 1) {
			System.out.println("Please provide the file path as an argument.");
			return 1;
		}

		String filePath = args[0];
		File file = new File(filePath);
		if (!file.exists()) {
			System.out.println("The specified file does not exist: " + filePath);
			return 1;
		}

		try {
			resultsList = launch(file);
			resultsList.forEach(System.out::println);
			return 0;
		} catch (Exception e) {
			System.err.println("Error during execution: " + e.getMessage());
			return 1;
		}
	}

	private List<String> launch(File file) throws MowerException, IOException {
		List<String> positionsList = new ArrayList<>();
		try (Scanner scanner = new Scanner(file)) {
			if (!scanner.hasNextLine()) {
				throw new DataFormatException("The file is emplty");
			}
			String lawnData = scanner.nextLine().trim();
			MowerDataParser parser = new MowerDataParser();
			parser.setLawn(lawnData);

			while (scanner.hasNextLine()) {
				String mowerData = scanner.nextLine().trim();
				if (!scanner.hasNextLine()) {
					throw new DataFormatException("Mower data without instruction");
				}
				String instructions = scanner.nextLine().trim();
				parser.setMower(mowerData);
				parser.setInstructions(instructions);
				positionsList.add(launchFromParser(parser));
			}
		}
		return positionsList;
	}

	private String launchFromParser(MowerDataParser parser) throws MowerException {
		MowerOperation mowerOperation = new MowerOperation();

		mowerOperation.setPelouse(MowerUtils.getLawnInfo(parser.getLawn()));
		mowerOperation.setPositionTondeuse(MowerUtils.getMowerInfo(parser.getMower()));
		mowerOperation.setListeInstruction(MowerUtils.getInstructionsInfo(parser.getInstructions()));

		mowerOperation.executerInstructions();

		return mowerOperation.toString();
	}

}
