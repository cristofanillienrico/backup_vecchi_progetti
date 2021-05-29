package esperimenti;

public interface Interfaccia {
	
	public abstract void metodoInterfaccia();
	
	default void metodoDefault() {
		System.out.println("fddfds");
	}
	
	static void metodoStatico() {
		System.out.println("fddfds");
	}

}
