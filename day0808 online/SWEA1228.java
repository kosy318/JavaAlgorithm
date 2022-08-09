package com.day0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SWEA1228 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer answer = new StringBuffer();
		for(int t=1; t<=10; t++) {
			br.readLine();
			StringBuffer password = new StringBuffer();
			password.append(br.readLine());
			br.readLine();
			String order = br.readLine();
			
			ArrayList<String> orderArray = new ArrayList<>();
			Matcher m = Pattern.compile("I[^I]+")
							   .matcher(order);
			
			while(m.find()) {
				orderArray.add(m.group());
			}
			
			for(String str : orderArray) {
				List<String> insert = (List<String>) Arrays.asList(str.split(" "));
				
				int i = Integer.parseInt(insert.get(1));
				List<String> nums = insert.subList(3, insert.size());
				String insertString = String.join(" ", nums);
				
				password.insert(i*7, insertString + " ");
			}
			
			answer.append("#" + t + " " + password.substring(0, 70) + "\n");
		}
		System.out.println(answer);
	}
}
