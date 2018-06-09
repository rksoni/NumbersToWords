package numtowords;

import java.util.Scanner;

public class NTWApp {
	private NTWMap map;

	public NTWApp() {
		map = new NTWMap();
	}
	/**
	 * this is the entry point for the application
	 */
	public void execute() {
		Scanner sn = new Scanner(System.in);
		String str = "";
		System.out.print("Enter a number : ");
		while(sn.hasNext()) {
			str = sn.nextLine();
			System.out.println("----------------------------------");
			if(isNumeric(str)) {
				System.out.println(str +" :"+numToEnglish(str));
			} else {
				System.out.println(str + " is not a valid number. Please enter a number.");
			}
			System.out.println("----------------------------------");
			System.out.print("Enter a number : ");
		}
		sn.close();
	}
	/**
	 * Main method that starts the application
	 * @param args
	 */
	public static void main(String[] args) {
		NTWApp nw = new NTWApp();
		nw.execute();
	}

	/**
	 * check if the string is a number
	 * 
	 * @param str
	 * @return true/false
	 */
	public boolean isNumeric(String str) {
		
		return str.matches("\\d+");
	}

	/**
	 * breaks a number into smaller number and converts into 
	 * english words
	 * @param num
	 * @return words
	 */
	public String numToEnglish(String num) {
		// if this number is already in the map then return without any effort
		if(map.getMap().containsKey(num)) {
			return map.getMap().get(num);
		}
		StringBuilder sb = new StringBuilder();
		int factor = 2;
		int i = 0;
		int counter = 0;
		int len = num.length();
		boolean prevSkipped = false;
		// we break the string into tokens i.e. 12345
		// take 45 first, then 3 then 12 or 2 if the number is 2345
		// convert the tokens one by one and insert into the string builder
		while(counter < len) {
			String sub = num.substring(len-counter-factor, len-counter);
			counter = counter + factor;
			if(!sub.equals("0") && !sub.equals("00")) {
				sb.insert(0, getWordsForPos(counter, prevSkipped));
				sb.insert(0, getWordsForNum(sub));
				prevSkipped = false;
			} else {
				prevSkipped = true;
			}
			i++;
			if(i % 2 == 0 && (len-counter > 1)) {
				factor = 2;
			}else {
				factor = 1;
			}
		}
		return sb.toString();
	}

	/**
	 * This converts a positional value to word
	 * 
	 * @param pos
	 * @param prevSkipped
	 * @return
	 */
	public String getWordsForPos(int pos, boolean prevSkipped) {
		switch(pos) {
		case 6:
			if(prevSkipped) {
				return map.getMap().get("00000");
			} else {
				return map.getMap().get("00");
			}
		case 3:
		case 9:
		case 12:
			return map.getMap().get("00");
		case 4:
		case 5:
			return map.getMap().get("000");
		case 7:
		case 8:
			return map.getMap().get("000000");
		case 10:
		case 11:
			return map.getMap().get("000000000");
		case 13:
			return map.getMap().get("000000000000");
		default :
			return "";

		}
	}

	/**
	 * This converts a number to word
	 * @param s
	 * @return
	 */
	public String getWordsForNum(String s) {
		// remove leading zeroes
		if(s.startsWith("0")) {
			s = s.replaceFirst("^0+(?!$)", "");
		}
		// check if the numbers is between 1 and 19 inclusive
		// also if it is a multiplication of 10
		// if not we break it further for example 45 will be 40 + 5
		int num = Integer.parseInt(s);
		String str = "";
		if(num < 20 || num % 10 == 0) {
			return process1To19(s);
		} else {
			str = process20To100(num);
		}
		return str;
	}
	public String process1To19(String s) {
		return map.getMap().get(s);
	}
	/**
	 * This breaks down the number between 20 to 100 further
	 * and converts into words
	 * @param num
	 * @return string vaue of the number
	 */
	public String process20To100(int num) {
		int subMod = num % 10;
		int subDiv = num / 10;
		String str = map.getMap().get(String.valueOf(subDiv * 10));
		str += map.getMap().get(String.valueOf(subMod));
		return str;
	}
}
