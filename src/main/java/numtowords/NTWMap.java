package numtowords;

import java.util.HashMap;

public class NTWMap {
	private HashMap<String, String> map;
	
	/**
	 * returns the map object
	 * @return
	 */
	public HashMap<String, String> getMap() {
		return map;
	}

	public NTWMap() {
		map = new HashMap<String, String>();
		map.put("0", " Zero");
		map.put("1", " One");
		map.put("2", " Two");
		map.put("3",  " Three");
		map.put("4", " Four");
		map.put("5", " Five");
		map.put("6",  " Six");
		map.put("7", " Seven");
		map.put("8", " Eight");
		map.put("9",  " Nine");
		map.put("10", " Ten");
		map.put("11", " Eleven");
		map.put("12",  " Twelve");
		map.put("13", " Thirteen");
		map.put("14", " Fourteen");
		map.put("15",  " Fifteen");
		map.put("16", " Sixteen");
		map.put("17", " Seventeen");
		map.put("18",  " Eighteen");
		map.put("19", " Nineteen");
		map.put("20", " Twenty");
		map.put("30",  " Thirty");
		map.put("40",  " Forty");
		map.put("50",  " Fifty");
		map.put("60",  " Sixty");
		map.put("70",  " Seventy");
		map.put("80",  " Eighty");
		map.put("90",  " Ninety");
		map.put("100",  " One Hundred");
		map.put("1000",  " One Thousand");
		map.put("10000",  " Ten Thousand");
		map.put("100000",  " One Hundred Thousand");
		map.put("1000000",  " One Million");
		map.put("100000000",  " One Hundred Million");
		map.put("1000000000",  " One Billion");
		map.put("1000000000000",  " One Triillion");
		map.put("00",  " Hundred");
		map.put("000",  " Thousand");
		map.put("0000",  " Thousand");
		map.put("00000",  " Hundred Thousand");
		map.put("000000",  " Million");
		map.put("00000000",  " Hundred Million");
		map.put("000000000",  " Billion");
		map.put("000000000000",  " Trillion");
	}

}
