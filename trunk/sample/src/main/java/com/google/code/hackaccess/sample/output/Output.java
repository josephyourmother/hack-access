package com.google.code.hackaccess.sample.output;


/**
 * �o�̓C���^�[�t�F�[�X
 *
 */
public interface Output {

	/**
	 * �w�肳�ꂽPDF�̓��e��ҏW���āA�o�͂���
	 * 
	 * @param url �o�͑Ώۂ�PDF��URL
	 * @throws Exception 
	 */
	public void output(String url) throws Exception;
	
}
