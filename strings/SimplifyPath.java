package com.strings.practice;

import java.util.Stack;

/**
 * 71. Simplify Path 
 * Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
 	
 	Corner Cases:

    Did you consider the case where path = "/../"?
    In this case, you should return "/".
    Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
    In this case, you should ignore redundant slashes and return "/home/foo".
 *
 */
public class SimplifyPath {

	public static void main(String[] args) {
		
		String path ="/home//foo/";
		System.out.println(simplifyPath(path));
	}
	
	/**
	 * Time Compleity-O(n)
	 * Space Complexity-O(n)-->for the explicit stack
	 * 
	 * If the substring equals to '.', simply bypass it because it means the under the current path
If the substring equals to '..', pop the stack
If the substring equals to 'abc', push it into the stack. 
	 */
	static String simplifyPath(String path) {
		
		if(path==null||path.length()==0)
			return "";
		 
		int start=0;
		int end=0;
		//skip the first / value
		int i=0;
		Stack<String> StringStack = new Stack<>();
		while(i<=path.length()) {
			//skip the first /
			while(i<path.length()&&path.charAt(i)=='/') {
				i++;
			}
			start = i;
			//corner case if the path is only '//'
			if(i==path.length()) {
				break;
			}
			//get the next character value before '/'
			while(i<path.length()&&path.charAt(i)!='/') {
				i++;
			}
			end=i;
			String temp =path.substring(start,end);
			if(temp.equals("..")) {
				if(!StringStack.isEmpty()) {
					StringStack.pop();
				}
			}else if(!temp.equals(".")) {
				StringStack.push(temp);
			}	
		}
		if(StringStack.isEmpty()) 
			return "/";
		StringBuilder sb = new StringBuilder();
		//as stack follows LIFO algo construct a array with the element in the same order.
		//use for each loop to use the same behaviour of stack
		String[] stackArray = StringStack.toArray(new String[StringStack.size()]);
		for(String temp:stackArray) {
			sb.append("/");
			sb.append(temp);
		}
		
		return sb.toString();
	}

}
