package casopracticotres;

public class Dividir{
	private int a;
	private int b;

	public Dividir(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public int dividir() {
		if(b==0) {
			return 0;
		}
		return a/b;
	}
}
