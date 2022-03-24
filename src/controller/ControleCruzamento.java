package controller;

import java.util.concurrent.Semaphore;

public class ControleCruzamento extends Thread{

	private int id;
	private Semaphore semaforo;
	private static int pos = 1;
	
	
	public ControleCruzamento(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;
				
	}
	
	@Override
	public void run() {
		
		cruza();
		
		try {
			semaforo.acquire();
			segue();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			semaforo.release();
		}

	}
	
	public void cruza() {
		
		switch (id) {
		case 1:
		System.out.println("Carro #" + id + " precisa subir");
		break;
		case 2:
		System.out.println("Carro #" + id + " precisa ir para a direita");
		break;
		case 3:
		System.out.println("Carro #" + id + " precisa descer");
		break;
		case 4:
		System.out.println("Carro #" + id + " precisa ir para a esquerda");
		break;
		}
	}
	
	public void segue() {
		
		System.out.println("Carro #" + id + " seguiu viagem em " + pos + "º");
		pos++;
	}

}
