package comportement;

import lejos.hardware.motor.Motor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;



//la methode "takeControl" de ce programme renvoie vrai � la m�thode "action" afin de reprendre le contr�le du robot mais
//laisse un timing au programme "DetecteurUltraSon" et "DetecteurCollision" la priorit�
//Il a pour fonction principal de faire avancer le robot


public class MarcheAvant implements Behavior {
	//DifferentialPilot robot;
	DifferentialPilot robot= new DifferentialPilot(5.6F,13.0F,Motor.A,Motor.B,true);
	
	public MarcheAvant(DifferentialPilot p){
		this.robot=p;
	}
	
	
	public boolean takeControl() {
		
		// Tous les 200 ms le programme renvoie vrai afin de reprendre le contr�le du robot mais
		//laisse entrain temps le programme BehaviorProximity le soin de s'executer 
		
		Delay.msDelay(200);
		System.out.println("TRUE");
		return true;
	}

	@Override
	public void action() {
		
		//V�rifie si le moteur est � l'arr�t puis avance durant 200 ms
		// backward en raison de mes capteurs  mont�s � l'arri�re et non � l'avant
		
		if(! robot.isMoving())robot.backward();
		
		System.out.println("J'AVANCE");
		
		Delay.msDelay(200);
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		
		robot.stop();
	}

}
