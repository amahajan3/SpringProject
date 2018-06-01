package in.codertechnologies.repository.utils;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtils {
	
	
	private static final double CHECK_FOR_ZERO = 0;
	private static final double CHECK_FOR_FLOAT_ZERO = 0.00;
	
	public static boolean validateForNullObject(Object obj) {

		if (obj != null) {
			return true;
		}
		return false;
	}
	
	public static boolean validateStringForNullSize(String string) {
		if (string != null && !"".equals(string.trim())) {
			return true;
		}
		return false;

	}
	
	public static boolean validateForZero(double value){
		if ((validateForNullObject(value)) &&
				value != CommonUtils.CHECK_FOR_ZERO) {
			return true;
		}
		return false;
	}
	
	public static boolean validateForZeroForBigdecimal(BigDecimal value){
		if ((validateForNullObject(value)) &&
				(value.doubleValue() != CommonUtils.CHECK_FOR_FLOAT_ZERO)){
			return true;
		}
		return false;
	}

	/**
	 *
	 * @param value
	 * @return
	 */
	public static boolean validateForZero(int value){
		if ((validateForNullObject(value)) &&
				value != CommonUtils.CHECK_FOR_ZERO) {
			return true;
		}
		return false;
	}

	public static boolean validateForZero(long value){
		if ((validateForNullObject(value)) &&
				value != CommonUtils.CHECK_FOR_ZERO) {
			return true;
		}
		return false;
	}
	
	public static boolean validateCollectionForNullSize(Collection set){

		if((validateForNullObject(set)) && set.size() > 0){
			return true;
		}

		return false;
	}

	/**
	 *
	 * @param set
	 * @return
	 */
	public static boolean validateMapForNullSize(Map dataMap){

		if((validateForNullObject(dataMap)) &&
				dataMap.size() > 0){
			return true;
		}

		return false;
	}
	
	public static BigDecimal convertAmountToTwoDecimalAmount(BigDecimal bigDecimal) {
		BigDecimal temp = BigDecimal.valueOf(0.0);
		temp = bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP);
		return temp;
	}
	
	public static boolean validateForBlankChar(char character) {

		if (character != '\u0000' && character != ' ' ) {
			return true;
		}
		return false;
	}
	public static boolean validateForBlankChar(Character obj) {

		if(obj != null && obj instanceof Character){
			if (obj.charValue() != '\u0000' && obj.charValue()!= ' ') {
				return true;
			}
			return false;
		}
		return false;
	}
	
	public static boolean isContainsUsername(String password,String username){
		Pattern pattern = Pattern.compile(username,Pattern.CASE_INSENSITIVE);
		//Pattern pattern = Pattern.compile("\\s+", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(password);
		if(matcher.find()){
			return true;
		}else {
			return false;
		}
	}
	public static boolean isContainsCaps(String password,long no){
		String patternStr = "[A-Z]";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(password);
		int count =0;
		while(matcher.find()){
			count++;
		}
		if(count>=no){
			return true;
		}else {
			return false ;
		}
	}
	public static boolean isContainsDigit(String password,long no){
		String patternStr = "[0-9]";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(password);
		int count =0;
		while(matcher.find()){
			count++;
		}
		if(count>=no){
			return true;
		}else {
			return false ;
		}
	}
	public static boolean isContainsSpecialChars(String password,long no){
		String patternStr = "[@!#$%^?.&*()_+|-}\\><{',;:]";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(password);
		int count =0;
		while(matcher.find()){
			count++;
		}
		if(count>=no){
			return true;
		}else {
			return false ;
		}
	}
	public static String replaceSpecialChar(String str){
		String replacedValue=str;
		if(str.indexOf("'") != -1){
			replacedValue = str.replaceAll("'", "\\\\'");
		}
		if(str.indexOf("(") != -1){
			replacedValue = str.replaceAll("\\(", "\\\\(");
		}
		if(str.indexOf(")") != -1){
			replacedValue = str.replaceAll("\\)", "\\\\)");
		}
		if(str.indexOf("{") != -1 ){
			replacedValue = str.replace("\\{", "\\\\{");
		}
		if(str.indexOf("}") != -1){
			replacedValue = str.replace("\\}", "\\\\}");
		}
		if(str.indexOf("[") != -1){
			replacedValue = str.replaceAll("\\[", "\\\\[");
		}
		if(str.indexOf("]") != -1){
			replacedValue = str.replaceAll("\\]", "\\\\]");
		}
		if(str.indexOf("&") != -1){
			replacedValue = str.replaceAll("&", "\\\\&");
		}
		if(str.indexOf("@") != -1){
			replacedValue = str.replaceAll("@", "\\\\@");
		}
		if(str.indexOf("!") != -1){
			replacedValue = str.replaceAll("!", "\\\\!");
		}
		if(str.indexOf("*") != -1){
			replacedValue = str.replaceAll("\\*", "\\\\*");
		}
		if(str.indexOf("^") != -1){
			replacedValue = str.replaceAll("\\^", "\\\\^");
		}
		if(str.indexOf("+") != -1){
			replacedValue = str.replaceAll("\\+", "\\\\+");
		}
		return replacedValue;
	}
}
