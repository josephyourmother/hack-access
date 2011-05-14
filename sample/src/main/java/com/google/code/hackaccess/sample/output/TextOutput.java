package com.google.code.hackaccess.sample.output;

import java.io.FileInputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;


/**
 * �v���[���e�L�X�g�`���ŏo�͂��܂�
 *
 */
public class TextOutput implements Output {

	private final String charSet;

	/**
	 * �R���X�g���N�^
	 * 
	 * @param charSet �o�͂���HTML�̕����R�[�h
	 */
	public TextOutput(final String charSet) {
		this.charSet = charSet;
	}

	/**
	 * �w�肳�ꂽPDF�̓��e���A�v���[���e�L�X�g�`���ŏo�͂���
	 * 
	 * @param url �o�͑Ώۂ�PDF��URL
	 * @throws Exception 
	 */
	public void output(String url) throws Exception {
		FileInputStream pdfStream = null;
		PDDocument document = null;

		try {
			document = PDDocument.load(new URL(url));

			PDFTextStripper stripper = new PDFTextStripper(this.charSet);
			stripper.setSortByPosition( true );

			System.out.println(stripper.getText(document));
		} catch (Exception e) {
			throw e;
		} finally {
			if (pdfStream != null) {
				pdfStream.close();
			}
			if (document != null) {
				document.close();
			}
		}
	}

}
