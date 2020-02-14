import java.util.*;

public class GuitarString {
   private Queue<Double> ringBuffer; 
   
   public static final double DECAY_FACTOR = 0.996; 
   

   public GuitarString(double frequency) {
      int desiredCapacityN = (int) Math.round(StdAudio.SAMPLE_RATE / frequency);
      if (frequency <= 0 || desiredCapacityN < 2) {
         throw new IllegalArgumentException();
      }
      ringBuffer = new LinkedList<Double>();;
      for (int i = 0; i < desiredCapacityN; i++) {
         ringBuffer.add(0.0);
      }
   }
   
 
   public GuitarString(double[] init) {
      if (init.length < 2) {
         throw new IllegalArgumentException();
      }
      ringBuffer = new LinkedList<Double>();;
      for (int i = 0; i < init.length; i++) {
         ringBuffer.add(init[i]);
      }
   }
   

   public void pluck() {
      for (int i = 0; i < ringBuffer.size(); i++) {
         double rand = Math.random() - 0.5;
         ringBuffer.add(rand);
         ringBuffer.remove();
      }
   }
   

   public void tic() {
      double front = ringBuffer.remove();
      double next = ringBuffer.peek();
      double update = ((front + next) / 2) * DECAY_FACTOR;
      ringBuffer.add(update);
   }

   public double sample() {
      return ringBuffer.peek();
   }
}