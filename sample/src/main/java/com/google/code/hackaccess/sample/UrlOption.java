package com.google.code.hackaccess.sample;

import java.io.IOException;

/**
 * ���o�Ώۂ�PDF���w�肵�܂�
 *
 */
public class UrlOption {
	// TODO �ȉ��̒萔���A�ݒ�t�@�C������ǂݍ��ނ悤�ɕύX����
	static String SOURCE_URL = "http://www.mext.go.jp/a_menu/saigaijohou/syousai/1304001.htm";
	static String CHAR_SET = "UTF-8";
	static String XPATH_EXPRESSION = "//a/@href";
	static String TARGET_MATCH_EXPRESSION = "/component/a_menu/other/detail/__icsFiles/afieldfile/";
	static String PREFIX_URL = "http://www.mext.go.jp";

	/**
	 * ���o�Ώ�URL��Ԃ�
	 * 
	 * @param args ��2�����ȍ~�̃R�}���h���C������
	 * @return 
	 * @throws Exception 
	 */
	
	public static String getUrl(String[] args) throws Exception {
		String url = null;
	
		if (args != null){
			url = getOptionUrl(args);
		}
		
		if (url == null){
			url = getFukushimaUrl();
		}
	
		return url;
	}
	
	/**
	 * �R�}���h���C���̈����Ŏw�肳�ꂽ���o�Ώ�URL��Ԃ�
	 * 
	 * @param args ��2�����ȍ~�̃R�}���h���C������
	 * @return ���o�Ώ�URL
	 */
	private static String getOptionUrl(String[] args) throws Exception {
		String url = null;

		for( int i=0; i<args.length; i++ )
		{
			if( args[i].equals( "-url" ) )
			{
				i++;
				if( i >= args.length )
				{
					throw new IOException("URL is not specified");
				}
				url = args[i];
			}
		}
		
		return url;
	}


	/**
	 * ������1�y�ё�2���q�͔��d�����ӂ̃��j�^�����O�J�[��p�����Œ葪��_�ɂ������Ԑ��ʗ��̑��茋�ʂ̍ŐV��URL��Ԃ�
	 * 
	 * @param args �R�}���h���C���̈���(<command>�����)
	 * @return ���o�Ώ�URL
	 * @throws Exception 
	 */
	private static String getFukushimaUrl() throws Exception {
		String srcUrl = SOURCE_URL;
		String charSet = CHAR_SET;
		String xpathExpression = XPATH_EXPRESSION;
		String targetMatchExpression = TARGET_MATCH_EXPRESSION;
		String prefixUrl = PREFIX_URL;
		
		UrlResolver resolver = new UrlResolver(srcUrl, charSet, xpathExpression, targetMatchExpression, prefixUrl);
		String url = resolver.getLatestTargetUrl();
		
		return url;
	}
}
