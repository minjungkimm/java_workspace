package com.ss.gui;

import javax.swing.JButton;

public class ArrayTest {
	//자바를 포함한 대부분의 응용프로그램
	//에서는 배열 선언시 반드시 그 크기를 명시해야 한다!!

	public static void main(String[] args) {
		JButton[] arr = new JButton[3];
		arr[0]=new JButton("버튼1");
		arr[1]=new JButton("버튼2");
		arr[2]=new JButton("버튼3");
		
		for(int i=0; i<arr.length; i++){
			System.out.println(arr[i].getText());
			
		}
	}
}
