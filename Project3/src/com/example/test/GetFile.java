/* CSCE 315 - Fall 2013
 * Contributors - Team G
 * Wesley Tang
 * Sidian Wu
 * Violeta Torres
 * Alejandro Vega
 * Grace Coffman
*/

package com.example.test;

public class GetFile {

	private static Data data = new Data();
	
	public static void setData(Data _d) {
		data = _d;
	}
	
	public static Data getData() {
		return data;
	}
	
	public static void print() {
		for (Row s : data.getArray()) {
			System.out.println(s.getIndex());
			System.out.println(s.getBranch());
			System.out.println(s.getX());
			System.out.println(s.getY());
			System.out.println(s.getZ());
			System.out.println(s.getRadius());
			System.out.println(s.getSecondIndex());
		}
	}
	
}
	
	
	
	
	
	
	
	
	