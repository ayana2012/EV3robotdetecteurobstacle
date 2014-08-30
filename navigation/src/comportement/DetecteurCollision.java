package comportement;

import lejos.hardware.Sound;
import lejos.hardware.motor.Motor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.RotateMoveController;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;

//cette méthode est prioritaire sur toutes car il permet de détecter une évetuelle collision du robot

public class DetecteurCollision implements Behavior {

	boolean isUpToSpeed = false;
	DifferentialPilot robot= new DifferentialPilot(5.6F,13.0F,Motor.A,Motor.B,true);
	
	
	public DetecteurCollision(RotateMoveController p){
		robot = (DifferentialPilot) p;
		Motor.A.setStallThreshold(10, 100);
		Motor.B.setStallThreshold(10, 100);
	}
	
	public boolean takeControl() {
		
		// detecte si le moteur est bloqué
		if (Motor.A.isStalled()||Motor.B.isStalled()){
			System.out.println("Moteur a l arret");
			Delay.msDelay(200);
			//le programme sort de la boucle et se rend dans la methode "action"
			return true;
			
		} else
		
		return false;
	}

	
	public void action() {
		
		Sound.twoBeeps();
		System.out.println("Ok je ne suis plus bloque!");
		//Rappelez vous les capteurs sont montés à l'arriere alors je luis demande 
		//de reculer et de tourner dans l'autre sens
		robot.travel(75);
		robot.rotate(-80);
	}

	
	public void suppress() {
		
		robot.stop();
	}

}
