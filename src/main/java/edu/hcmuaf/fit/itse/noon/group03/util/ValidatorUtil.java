package edu.hcmuaf.fit.itse.noon.group03.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtil {

	public static final Pattern VALID_USERNAME_REGEX = Pattern.compile("^[a-zA-Z]+[a-zA-Z\\d]+$");
	public static final Pattern VALID_DATE_REGEX = Pattern
			.compile("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$");
	public static final Pattern VALID_PHONE_REGEX = Pattern.compile("^0[\\d]{9,10}$");

	public static boolean validateUsername(String userName) {
		if (userName == null)
			return false;
		Matcher matcher = VALID_USERNAME_REGEX.matcher(userName);
		return matcher.find();
	}

	public static boolean valdiateDate(String date) {
		if (date == null)
			return false;
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate.parse(date, formatter);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static boolean validatePhone(String phone) {
		if (phone == null)
			return false;
		Matcher matcher = VALID_PHONE_REGEX.matcher(phone);
		return matcher.find();
	}

}
