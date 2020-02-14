 /**  _                     _                         _ _  __       
     | |                   | |                       | (_)/ _|      
   __| | ___    _ __   ___ | |_   _ __ ___   ___   __| |_| |_ _   _ 
  / _` |/ _ \  | '_ \ / _ \| __| | '_ ` _ \ / _ \ / _` | |  _| | | |
 | (_| | (_) | | | | | (_) | |_  | | | | | | (_) | (_| | | | | |_| |
  \__,_|\___/  |_| |_|\___/ \__| |_| |_| |_|\___/ \__,_|_|_|  \__, |
                                                               __/ |
                                                              |___/ 
*
* Until I tell you to.
*/

// This program constructs a Guitar object that it allows the user to play.

public class GuitarHero {
    public static void main(String[] args) {

        Guitar g = new Guitar37(); // << this line should be the only line you ever change, and only to make different types of guitar objects

        // this is an infinite loop--user must quit the application
        for (;;) {
            // check if the user has typed a key; if so, process it   
            if (StdDraw.hasNextKeyTyped()) {
                char key = Character.toLowerCase(StdDraw.nextKeyTyped());
                if (g.hasString(key)) {
                    g.pluck(key);
                } else {
                    System.out.println("bad key: " + key);
                }
            }
            // send the result to the sound card
            StdAudio.play(g.sample());
            g.tic();
        }
    }
}