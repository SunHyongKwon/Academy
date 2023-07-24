package chap11.exam18_calendar;

import java.util.Calendar;

public class CalendarKor {
	//필드
	private Calendar calendar = Calendar.getInstance();
	
	//생성자
	
	//메소드
	public void nowKorTime() {
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int week = calendar.get(Calendar.DAY_OF_WEEK);
		String strWeek = null;
		switch(week) {
			case Calendar.MONDAY:
				strWeek = "월";
				break;
			case Calendar.TUESDAY:
				strWeek = "화";
				break;
			case Calendar.WEDNESDAY:
				strWeek = "수";
				break;
			case Calendar.THURSDAY:
				strWeek = "목";
				break;
			case Calendar.FRIDAY:
				strWeek = "금";
				break;
			case Calendar.SATURDAY:
				strWeek = "토";
				break;
			case Calendar.SUNDAY:
				strWeek = "일";
				break;
		}
		int amPm = calendar.get(Calendar.AM_PM);
		String strAmPm = null;
		if(amPm == Calendar.AM_PM) {
			strAmPm = "오전";
		}else {
			strAmPm = "오후";
		}
		int hour = calendar.get(Calendar.HOUR);
		if(hour > 12) {
			hour = hour -12;
		}
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		
		String today = year + "년 " + month + "월 " + day + "일 " + strWeek + "요일 " +
		strAmPm + " " + hour + "시 " + minute + "분 "+ second + "초"; 
		
		System.out.println(today);
	
	}
}
