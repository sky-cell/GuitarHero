public class Guitar37 implements Guitar {
	

    public static final String KEYBOARD =
        "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

    private GuitarString[] notes;
    

    private int count;
    
 
    public Guitar37() {
    	
    	notes = new GuitarString[KEYBOARD.length()];
    	
    	for (int i = 0; i < KEYBOARD.length(); i++) {
    		notes[i] = new GuitarString(440.0 * Math.pow(2.0, ((i - 24.0) / 12.0)));
    	}
    	
    }
    

    public void playNote(int pitch) {
    	int index = pitch + 24;
    	
    	if ((index < KEYBOARD.length()) & (index > 0)) {
    		notes[index].pluck();
    	}
    }
    

    public boolean hasString(char string) {
        return (KEYBOARD.indexOf(string) != -1);
    }

    public void pluck(char note) {
    	
    	if (!hasString(note)) {
    		throw new IllegalArgumentException();
    	}
    	
    	notes[KEYBOARD.indexOf(note)].pluck();
    }

	public double sample() {
		
		double sampleTotal = 0;
		
		for (int i = 0; i < notes.length; i++) {
			sampleTotal += notes[i].sample();
		}
		return sampleTotal;
	}

	public void tic() {
		for (int i = 0; i < KEYBOARD.length(); i++) {
			notes[i].tic();
		}
		count++;
	}


	public int time() {
		return count;
	}
}