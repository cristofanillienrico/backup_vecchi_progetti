package esperimenti;

public enum Switch {
	
	ON(1,"uno"),
	OFF(2,"due");
	
	private int x;
	private String stringa;
	
	private Switch(int x,String stringa) {
		this.x=x;
		this.stringa=stringa;
		
	}

	public int getX() {
		return x;
	}

	public String getStringa() {
		return stringa;
	}

	public void setStringa(String stringa) {
		this.stringa = stringa;
	}

	public void setX(int x) {
		this.x = x;
	}

	
	
}
