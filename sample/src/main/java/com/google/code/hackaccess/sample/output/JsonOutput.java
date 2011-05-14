package com.google.code.hackaccess.sample.output;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import com.google.code.hackaccess.sample.util.StringUtil;

/**
 * JSON���o�͂��܂�
 * PDF���̃e�L�X�g��͕��@�́A�����Ȓ񋟂́w�������ӂ̌Œ葪��_�ɂ������Ԑ��ʗ��̑��茋�ʁx��p�ł�
 *
 */
public class JsonOutput implements Output {
	private int areaSize = 110;
	private String[][] points = new String[areaSize][5];
	
	private String[][] tmppoints = {
			{"1","�����s���Ȓ�","Fukushima Sugituma","37.7490987","140.4667432"},
			{"2","�����s��g��m��","Fukushima Onami","37.7585306","140.553572"},
			{"3","�ɒB�s��R���Γc�F��","Date Ryozen Ishida Hikohei","37.759424","140.7301391"},
			{"4","�ɒB�S�얓���厚�ߑ򎚐�[","Date Kawamata Turusawa","37.663122","140.5957082"},
			{"5","���n�s���쎛�O","Soma Nakano","37.790975","140.927497"},
			{"6","�쑊�n�s�����搼��","Minamisoma Kashima Nishi","37.7032212","140.9648426"},
			{"7","�쑊�n�s�����掛���{���~","Minamisoma Kashima Terauchi","37.7007408","140.9608736"},
			{"10","��{���s�j������","Nihonmatsu Harimiti","37.6011144","140.5838917"},
			{"11","��{���s���c�����c","Nihonmatsu Ota","37.569784","140.5762523"},
			{"12","�c���s�D�����D����������","Tamura Funahiki Funahiki Ozawakawasiro","37.4362001","140.5924433"},
			{"13","�c���s��t���������`","Tamura Tokiwa Nishi Mukiyakata","37.4441","140.6180266"},
			{"14","�c���s��t����t����","Tamura Tokiwa Tokiwanai","37.4400394","140.6461856"},
			{"15","�c���s��t���R������","Tamura Tokiwa Yamane Kashima","37.4512277","140.6774311"},
			{"20","�c���s�D�����V�ډ�","Tamura Funehiki Niitate","37.4925135","140.5822886"},
			{"21","�c���s�D�������","Tamura Funehiki Kamiutushi","37.5144233","140.6581236"},
			{"22","�c���s�D������ڎ���c","Tamura Funehiki Kamiutushi Ushirota","37.5139649","140.6533073"},
			{"23","�c���s�D������ڐ�����","Tamura Funehiki Minamiutushi","37.5070768","140.6239679"},
			{"31","�o�t�S�Q�]���Ó�����","Futaba Namie Tushima","37.5601452","140.7461314"},
			{"32","�o�t�S�Q�]���ԉF�؎莵�Y","Futaba Namie Akogi","37.5934916","140.7440805"},
			{"33","���n�S�ъڑ����D","Soma Iitate Nagadoro","37.6128507","140.7493794"},
			{"34","�o�t�S�Q�]���Ó��卂��","Futaba Namie Tushimao","37.5518624","140.7260468"},
			{"36","�ɒB�S�얓���R�؉���^","Date Kawamata Yamakiya Onukari","37.6111796","140.6680268"},
			{"37","�ɒB�s��R���Γc��i��","Date Ryozen Ishida Houjizawa","37.7588562","140.6875064"},
			{"38","���킫�s�l�q������ۖؓc","Iwaki Yotukura Siroiwa","37.120888","140.9517325"},
			{"39","���n�s�R������","Soma Yamakami","37.7685046","140.8579938"},
			{"41","�c���s�s�H���Ó�","Tamura Miyakoji Furumiti","37.4346756","140.7953463"},
			{"42","�c���s��t���R���x��","Tamura Tokiwa Yamane Tomioka","37.4644202","140.6658371"},
			{"43","�o�t�S�����������{�n","Futaba Kawauchi Simokawauchi Miyawata","37.3210959","140.8152722"},
			{"44","���킫�s��v����v��m�ڑ�","Iwaki Ohisa","37.178173","140.9530661"},
			{"45","�o�t�S��t���R�c�������X","Futaba Naraha","37.2440824","141.008025"},
			{"46","�ɒB�S�얓���R�؉����o�R","Date Kawamata Yamakiya Mukaideyama","37.5794174","140.7108919"},
			{"51","�c���S���쒬����V���ډ�","Tamura Ono","37.2864282","140.6240025"},
			{"52","�c���s�D�����D���n��쌴","Tamura Funehiki Funahiki Baba","37.4411634","140.5692006"},
			{"61","���n�S�ъڑ����ؑ�","Soma Iitate Yagisawa","37.6914248","140.8121305"},
			{"62","���n�S�ъڑ������t��","Soma Iitate Kusano","37.699991","140.7456179"},
			{"63","���n�S�ъڑ��񖇋�","Soma Iitate Nimaibashi","37.6923848","140.67651"},
			{"71","�o�t�S�L�쒬���k���c���","Futaba Hirono","37.2156334","140.9954551"},
			{"72","���킫�s�v�V�l���v�V�l���k�r��","Iwaki Hisanohama","37.1424509","140.9958325"},
			{"73","���킫�s�l�q��","Iwaki Yotukura","37.1088846","140.9899951"},
			{"74","���킫�s���쒬����","Iwaki Ogawa Takahagi","37.1268065","140.8451765"},
			{"75","���킫�s������X��","Iwaki Uchigomimaya","37.0501995","140.8738941"},
			{"76","�o�t�S������������n","Futaba Kawauchi Kamikawauchi Hayawata","37.3360573","140.8066007"},
			{"77","���킫�s���쒬�㏬��","Iwaki Ogawa Kamiogawa","37.134831","140.8567667"},
			{"78","�ɒB�S�얓���ߑ�","Date Kawamata Tsurusawa","37.66479859","140.5953026"},
			{"79","�o�t�S�Q�]�����Ó����[","Futaba Namie Shimotushima","37.5628146","140.7588442"},
			{"80","�쑊�n�s�����捂����","Minamisoma Haramachi Takami","37.6359705","140.9863316"},
			{"81","�o�t�S�Q�]���ԉF�ؐΏ���","Futaba Namie Akougi Ishikoya","37.58220135","140.7954597"},
			{"83","�o�t�S�Q�]���ԉF�؞���","Futaba Namie Akogi Kunugi","37.5611249","140.8169692"},
			{"84","���킫�s�O�a������","Iwaki Miwa","37.1839221","140.7165863"},
			{"85","�����s�r�䌴�h","Fukushima Arai","37.7228025","140.3854531"},
			{"86","�S�R�s��Β����E�G���","Koriyama Otuki","37.3974423","140.3289006"},
			{"87","�o�t�S����������ԃm��","Futaba Kawauchi Kamikawauchi Hananouti","37.3672103","140.7223051"},
			{"88","�����s�����u","Fukushima Hikarigaoka","37.6900638","140.47064"},
			{"89","�S�R�s�L�c��","Koriyama Toyota","37.3985321","140.3641917"},
			{"101","�ɒB�s��R����Ύ��O�m��","Date Ryozen Oishi","37.8040253","140.6395468"},
			{"102","�ɒB�s���ڒ����ڎ���","Date Tukidate","37.7360316","140.6106651"},
			{"103","�쑊�n�s�����捂���哤����","Minamisoma Haramachi Taka","37.6063946","140.9857492"},
			{"104","�o�t�S�������厚����������","Futaba Katurao","37.5038709","140.7694373"},
			{"105","�c���s�s�H���Ó������m�O","Tamura Miyakoji Furumiti Teranomae","37.431662","140.7914553"},
			{"106","���킫�s��O�������䎚���ď���","Iwaki Kawamae","37.2998966","140.7033977"},
			{"107","�쑊�n�s������n�ꎚ����","Minamisoma Haramachi Baba Nakauchi","37.6082739","140.9233714"},
			{"108","�쑊�n�s������匴�䔨","Minamisoma Haramachi Ohara","37.6621453","140.8977145"}
		};

	public JsonOutput(){
		for(int i=0; i<tmppoints.length; i++){
			int index = Integer.parseInt(tmppoints[i][0]);
			points[index] = tmppoints[i];
		}
	}

	/**
	 * �w�肳�ꂽPDF�̓��e���AJSON�ŏo�͂���
	 * 
	 * @param url ���o�Ώۂ�PDF��URL
	 * @throws Exception 
	 */
	public void output(String url) throws Exception {

		List<Map<String,String>>[] dataList = new ArrayList[areaSize];
		for(int i=0; i<areaSize; i++){
			dataList[i] = new ArrayList<Map<String, String>>();
		}
		
		PDDocument document = null;
		try {
			document = PDDocument.load(new URL(url));
		
			PDFTextStripper stripper = new PDFTextStripper();
			stripper.setSortByPosition( true );
			String text = stripper.getText(document);
			text = StringUtil.zenkakuNumToHankaku(text);
			
			java.util.Date d = new java.util.Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			
			String[] lines = text.split("\n");
			for(int i=0; i<lines.length; i++){
				lines[i] = lines[i].trim();
				if(lines[i].indexOf("����G���A �y")==0){
					lines[i] = lines[i].replaceAll("\\*2", "");
					lines[i] = lines[i].replaceAll("�i.*�j", "");
					
					String regex = "����G���A �y(\\d+)�z.*(\\d+)��(\\d+)��\\s*(\\d+)��(\\d+)��\\s*([\\d\\.]+).*";
					Pattern p = Pattern.compile(regex);
					
					Matcher m = p.matcher(lines[i]);
					if (m.find()){
						int area = Integer.parseInt(m.group(1));
						String month = m.group(2);
						String day = m.group(3);
						String hour = m.group(4);
						String min = m.group(5);
						float value = Float.parseFloat(m.group(6));
						
			   			Map<String, String> datamap = new HashMap<String, String>();
						datamap.put("datetime", getDateString(null, month, day, hour, min));
						datamap.put("value", value+"");
						dataList[area].add(datamap);
					}
				
				}
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (document != null) {
				document.close();
			}
		}
		
		for(int i=0; i<areaSize; i++){
			if(dataList[i].size() != 0 && points[i][0] != null){
				System.out.println("["+points[i][0]+"] = "+points[i][1]);
				System.out.println(dataList[i].toString());
			}
		}
	}
	
	private static String getDateString(String year, String month, String day, String time, String min){
		if(year == null){
			java.util.Date d = new java.util.Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			year = String.valueOf(cal.get(Calendar.YEAR));
		}
		if(month.length() == 1){
			month = "0"+month;
		}
		if(day.length()==1){
			day = "0"+day;
		}
		if(time.length()==1){
			time = "0"+time;
		}
		if(min == null){
			min = "00";
		}
		return year+"-"+month+"-"+day+" "+time+":"+min;
	}
}
