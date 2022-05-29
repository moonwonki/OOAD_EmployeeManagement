package cm_machine;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Employee  implements Serializable {
	private String name;
	private boolean working;
	private int workHour;
	private int workMin;
	private LocalDateTime  workStartTime;
	
	public Employee(String nameInput) {
		name = nameInput;
		working = false;
		workHour = 0;
		workMin = 0;
		workStartTime = null;
	}
	
	
	//직원 일 시작.
	public void workStart() {
		workStartTime = LocalDateTime.now();
		working = true;
	}
	
	//직원 일 종료.
	//일을 하지 않고 있는 직원을 퇴근처리시키면 return -1
	//정상적으로 잘 처리되었다면 return 1
	public int workFinish() {
		if (working == false) {
			return -1;
		}
		working = false;
		LocalDateTime currentTime = LocalDateTime.now();
		int hour = currentTime.getHour() - workStartTime.getHour();
		int minute = currentTime.getMinute() - workStartTime.getMinute();
		
		if (hour >= 0) {
			workHour += hour;
		}
		else {
			workHour += 24 + hour;
		}
		
		if (minute >= 0) {
			workMin += minute;
		}
		else {
			workMin += 60 + minute;
			hour -= 1;
		}
		
		workStartTime = null;
		return 1;
	}
	
	//근무시간 초기화
	public void resetWorkTime(int hour, int minute) {
		if (minute >= 60) {
			hour += minute / 60;
			minute = minute % 60;
		}
		workHour = hour;
		workMin = minute;
	}
	
	//리스트에 출력할 스트링 get
	public String getString() {
		String result = "";
		result += this.name;
		if (this.working == true) {
			result += "(출근중) / 출근 시간: ";
			result += (workStartTime.getDayOfMonth()+"");
			result += "일 ";
			result += (workStartTime.getHour()+"");
			result += "시 ";
			result += (workStartTime.getMinute()+"");
			result += "분 ";
		}
		return result;
	}
	
	public int getWorkHour() {
		return workHour;
	}
	
	public int getWorkMin() {
		return workMin;
	}
}
