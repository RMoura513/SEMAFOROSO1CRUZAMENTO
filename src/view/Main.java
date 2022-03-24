package view;

import java.util.concurrent.Semaphore;

import controller.ControleCruzamento;

public class Main {

	public static void main(String[] args) {
		
		int permissao = 1;
		Semaphore semaforo = new Semaphore(permissao);
		
		
		for (int id = 1; id < 5; id++) {
			ControleCruzamento controlecruzamento = new ControleCruzamento(id, semaforo);
			controlecruzamento.start();
		}

	}

}
