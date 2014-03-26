package model;

public enum Battle {

	WIN("win"), LOSS("loss"), TIE("tie"), MOVE("move"), FLAG("flag");
	
	String message; 
	
	Battle(String message) {
		this.message = message;
	}
	
	String getMessage() {
		return message;
	}
}
