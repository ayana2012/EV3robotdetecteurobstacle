package comportement;

import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.sensor.SensorModes;
import lejos.robotics.SampleProvider;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;


public class Navigation {

	
	
	// Programme principal
	
	public static void main(String[] args) {
		
		SensorModes sensor = new EV3UltrasonicSensor (SensorPort.S1);
		SampleProvider distance = sensor.getMode(0);
		CapteurPhysique us=new CapteurPhysique(distance);
		DifferentialPilot robot= new DifferentialPilot(5.6F,13.0F,Motor.A,Motor.B,true);
		
		//vitesse linéaire de 20 deg/sec"
		robot.setTravelSpeed(20);
		
		//Paramétrage de la vitesse angulaire de 40 degres/sec
		robot.setRotateSpeed(40);
		
		Behavior b1= new MarcheAvant(robot);
		Behavior b2=new DetecteurUltraSon(us,robot);
		Behavior b3=new DetecteurCollision(robot);
		 //le programme "Behaviorproximity" est prioritaire par rapport à "BehaviorForward"
		Behavior [] bArray={b1,b2,b3};
		Arbitrator arby=new Arbitrator(bArray);
		arby.start();
		
	}

	
}
