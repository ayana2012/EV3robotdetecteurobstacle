package comportement;


import lejos.robotics.SampleProvider;
import lejos.robotics.filter.AbstractFilter;



public class CapteurPhysique extends AbstractFilter {
	
	private float[] sample;
	
	
	public CapteurPhysique(SampleProvider source) {
		
		super(source );
		
		sample = new float[sampleSize];
	    
	  }
	

	  public   float mesure() {
		  
		  float X = 0f;
		  

		  for(int i=0;i<sampleSize;i++) {
			  
		  
	    	source.fetchSample(sample, 0);
	
	    	  X=sample[i];
	        
	        
		  }
		  
		  return X;
	  }
	  
	  
}
