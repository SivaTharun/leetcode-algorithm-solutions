package com.strings.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 93.Restore IP Addresses
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

	For example:
	Given "25525511135",

	return ["255.255.11.135", "255.255.111.35"]. (Order does not matter) 
 * 
 * @author SivaTharun
 *
 */
public class RestoreIPAddresses {

	public static void main(String[] args) {

		String s = "25525511135";
		
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		List<String> t = new ArrayList<>();
		/*getValidIpAddress(result, s, 0, t);
		for(ArrayList<String> temp:result) {
			System.out.println(temp);
		}*/
		t= getValidIp(s);
		System.out.println(t);
	}
	
	//time complexity-O(4^n)-->since there are 4 choices for each integer before '.'(but we are avoiding all the cases except for one for each integer)
	//space complexity-same as above
	static void getValidIpAddress(ArrayList<ArrayList<String>> finalResult,String s,int startPos,ArrayList<String> t) {
		if(t.size()>=4&&startPos!=s.length())
			return;
		
		if(t.size()+s.length()-startPos+1<4)
			return;
		
		if(t.size()==4&&startPos==s.length()) {
			ArrayList<String> temp = new ArrayList<String>(t);
			finalResult.add(temp);
			return;
		}
		for(int i=1;i<=3;i++) {
			if(startPos+i>s.length())
				break;
			String sub = s.substring(startPos,startPos+i);
			if(i>1&&sub.charAt(0)=='0')
				break;
			if(Integer.valueOf(sub)>255)
				break;
			t.add(sub);
			getValidIpAddress(finalResult,s,startPos+i,t);
			//to remove the extra element in list if t.size()>4 for the recursion call,remove the last element in the array list
			t.remove(t.size()-1);
		}
		
	}
	
	//non recursive solution
	static List<String> getValidIp(String s) {
		List<String> ret = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<4;i++)
		for(int j=1;j<4;j++)
		for(int k=1;k<4;k++)
		for(int z=1;z<4;z++)
		{
			if(i+j+k+z==s.length()) {
				int n1= Integer.parseInt(s.substring(0,i));
				int n2=Integer.parseInt(s.substring(i,i+j));
				int n3=Integer.parseInt(s.substring(j,j+k));
				int n4=Integer.parseInt(s.substring(i+j+k));
				if(n1<=255&&n2<=255&&n3<=255&&n3<=255){
					sb.append(n1).append('.').append(n2).append('.').append(n3).append('.').append(n4);
				if(sb.length()==s.length()+3)
					ret.add(sb.toString());
				}
				//deleting previous valid entry to make room for next entry
				sb.delete(0, sb.length());
			}
		}
		return ret;
		
	}
	
	//combinations problem which can be solved with the help of recursion and back tracking
	/*static ArrayList<String> getValidIpAddresses(String s) {

		ArrayList<String> al = new ArrayList<>();
		//null check
		if(s.length()==0||s.equals(""))
		return al;
		int startPos=0;
		int segment =1 ;
		String current = "";
		 validIpAddressHelper(s,al,startPos,segment,current);
		 return al;
	}
	
	static void validIpAddressHelper(String s,ArrayList<String> al,int startPosition,int segmnent,String current) {
		
		if(startPosition>=s.length())
			return;
		if(segmnent==4) {
			String temp=s.substring(startPosition);
			if(temp.length()+1+current.length()==s.length()+3) {
			if(isValidIp(temp)) {
				al.add(current+"."+temp);
				return;
				}
			}
			}
		
		//check for position of segment
		for(int i=1;i<4&&startPosition+i<s.length();i++) {
			String temp=s.substring(startPosition,startPosition+i);
		if(segmnent==1) {
			if(isValidIp(temp)) {
				validIpAddressHelper(s, al, startPosition+i, segmnent++, temp);
			}
		}else {
			if(isValidIp(temp)) {
				validIpAddressHelper(s, al, startPosition+i, segmnent++, current + "."+temp);
			}
		}
		}
		return;
	}
	
	static boolean isValidIp(String s) {
		if(s==null || s.length()>3)
			return false;
		if(s.length()>1&&s.charAt(0)=='0')
			return false;
		int num = Integer.parseInt(s);
		if(num>=0&&num<=255) {
		return true;
		}
		return false;
		
	}*/
}
