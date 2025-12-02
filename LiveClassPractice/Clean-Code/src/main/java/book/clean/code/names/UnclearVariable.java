package book.clean.code.names;

public class UnclearVariable {

	public static void main(String[] args) {

		UnclearVariable uv = new UnclearVariable();
//		uv.printGuessStatistics('R',1 );
		GuessStatisticsMessage gs = new GuessStatisticsMessage();
		String print = gs.make('R', 0);
		System.out.println(print);

	}

//	public void printGuessStatistics(char candidates, int count) {
//		String number;
//		String verb;
//		String pluralModifier;
//
//		if (count == 0) {
//			number = "0";
//			verb = "are";
//			pluralModifier = "s";
//		} else if (count == 1) {
//			number = "1";
//			verb = "is";
//			pluralModifier = "";
//		} else {
//			number = Integer.toString(count);
//			verb = "are";
//			pluralModifier = "s";
//		}
//		String guessMessage = String.format("There %s %s %s%s", verb, number, candidates, pluralModifier);
//		System.out.println(guessMessage);
//	}

}

class GuessStatisticsMessage {
	private String number;
	private String verb;
	private String pluralModifier;

	public String make(char candidates, int count) {

		createPluralDependentMessageParts(count);
		return String.format("There %s %s %c%s", number, verb, candidates, pluralModifier);
	}

	private void createPluralDependentMessageParts(int count) {
		if (count == 0) {
			thereAreNoLetters();
		} else if (count == 1) {
			thereIsOneLetter();
		} else {
			thereAreManyLetters(count);
		}
	}

	private void thereAreManyLetters(int count) {
		number = Integer.toBinaryString(count);
		verb = "are";
		pluralModifier = "s";
	}

	private void thereIsOneLetter() {
		number = "One";
		verb = "is";
		pluralModifier = "";
	}

	private void thereAreNoLetters() {
		number = "No";
		verb = "Are";
		pluralModifier = "s";
	}
}
