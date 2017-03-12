package com.strings.practice;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

	public static void main(String[] args) {
		
		String ransom ="aa";
		String magazine ="aab";
		System.out.println(ransomNote(magazine, ransom));
	}
	
	static boolean ransomNote(String ransom,String magazine) {
		if(ransom.isEmpty()&&magazine.isEmpty())return true;
		if(ransom.length()<magazine.length())return false;
		if(ransom.equals("")&&magazine.equals(""))return true;
		Map<Character,Integer> characterMap = new HashMap<>();
		int count=0;
		for(char ransomCharacter:ransom.toCharArray()) {
			if(characterMap.containsKey(ransomCharacter)) 
			{
				 count = characterMap.get(ransomCharacter);
				characterMap.put(ransomCharacter, count+1);
			}
				else {
					characterMap.put(ransomCharacter, 1);
				}
		}
		int magazineCharCount=0;
		for(char magazineCharacter:magazine.toCharArray()) {
			if(characterMap.containsKey(magazineCharacter)) {
				magazineCharCount = characterMap.get(magazineCharacter);
				if(magazineCharCount>0)
				characterMap.put(magazineCharacter, magazineCharCount-1);
				if(magazineCharCount==0)
					return false;
			}else {
				return false;
			}
		}
		return true;
	}

}
