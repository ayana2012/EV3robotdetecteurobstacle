package comportement;



import lejos.hardware.motor.Motor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.RotateMoveController;
import lejos.robotics.subsumption.Behavior;

// Ce programme détecte un obstacle à une distance de 40 cm s'arrête, recule et tourne de 80 degrés



public class DetecteurUltraSon implements Behavior {
	
	
	CapteurPhysique us;
	
	DifferentialPilot robot= new DifferentialPilot(5.6F,13.0F,Motor.A,Motor.B,true);
	
	public DetecteurUltraSon ( CapteurPhysique us, RotateMoveController p){
		
		this.us=us;
		this.robot=(DifferentialPilot) p;
		
	}
	@Override
	public boolean takeControl() {
		
			float dist = us.mesure()*100;
			System.out.println(dist);
			return (dist<40);		
		
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
		robot.travel(20f);
		System.out.println("Recule de : -20 cm");
		robot.rotate(80f);
		System.out.println("Rotation de : 80 degres");
	}

	@Override
	public void suppress() {
		// TODO Auto-generated method stub
		robot.stop();
		System.out.println("STOP");
	}

}
