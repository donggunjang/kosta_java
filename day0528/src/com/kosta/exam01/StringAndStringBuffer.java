package com.kosta.exam01;

public class StringAndStringBuffer {
	public static void pro(String data) {
		System.out.println(data+"를 처리 했습니다.");
	}
	
	public static void main(String[] args) {
		StringBuffer cmd = new StringBuffer();
		cmd.append("insert ");
		cmd.append("into ");
		cmd.append("member ");
		cmd.append("values (");
		cmd.append("tiger");
		cmd.append(",'010-1234-5678'");
		cmd.append("'서울')");
		System.out.println(cmd);
		pro(cmd.toString());	//StirngBuffer를 String으로 변환 해야 한다.
	}
	
}
