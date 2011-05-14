package com.google.code.hackaccess.sample.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * �����񑀍샆�[�e�B���e�B�N���X
 *
 */
public class StringUtil {

	/**
	 * ���l�����Q��(Numeric character reference)���A���̕����ɕϊ����ĕԂ��܂�.
	 * 
	 * @param text �ϊ��O�̐��l�����Q�Ƃ��܂ޕ�����
	 * @return �ϊ���̕�����
	 */
	public static String decodeNCR(String text) {
		Pattern pattern = Pattern.compile("&#(\\d+);|&#([\\da-fA-F]+);");
		Matcher matcher = pattern.matcher(text);
		StringBuffer sb = new StringBuffer();
		Character buf;

		while(matcher.find()){
			if(matcher.group(1) != null){
				buf = new Character(
						  (char)Integer.parseInt(matcher.group(1)));
			}else{
				buf = new Character(
						  (char)Integer.parseInt(matcher.group(2), 16));
			}
			matcher.appendReplacement(sb, buf.toString());
		}

		matcher.appendTail(sb);
		
		return sb.toString();
	}

	/**
	 * �S�p�����𔼊p�����ɕϊ����܂�
	 * 
	 * @param s �S�p����
	 * @return ���p����
	 */
	public static String zenkakuNumToHankaku(final String s) {
		StringBuffer sb = new StringBuffer(s);
		for (int i = 0; i < sb.length(); i++) {
			char c = sb.charAt(i);
			if (c >= '�O' && c <= '�X') {
				sb.setCharAt(i, (char)(c - '�O' + '0'));
			}
			if (c == '�D'){
				sb.setCharAt(i, '.');
			}
		}
		return sb.toString();
	}
}
