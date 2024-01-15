package ejercicio2;

public class Hora {
	
	private int segundo;
	private int minuto;
	private int hora;

	public Hora() {

	}

	public void addOneSecond() {

		if (segundo == 59) {
			segundo = 0;
			if (minuto == 59) {
				minuto = 0;
				if (hora == 11) {
					hora = 0;
				} else {
					hora++;
				}
			} else {
				minuto++;
			}
		} else {
			segundo++;
		}

	}

	public boolean setSegundo(int segundo) {
		if (segundo > 59 || segundo < 0) {
			return false;
		}

		this.segundo = segundo;
		return true;
	}

	public boolean setMinuto(int minuto) {
		if (minuto > 59 || minuto < 0) {
			return false;
		}

		this.minuto = minuto;
		return true;
	}

	public boolean setHora(int hora) {
		if (hora > 11 || hora < 0) {
			return false;
		}

		this.hora = hora;
		return true;
	}
	
	public int getSegundo() {
		return segundo;
	}
	
	public int getHora() {
		return hora;
	}
	
	public int getMinuto() {
		return minuto;
	}
	
	@Override
	public String toString() {
		return "[" + hora + ": " + minuto + ": " + segundo + "]";
	}
	
}
