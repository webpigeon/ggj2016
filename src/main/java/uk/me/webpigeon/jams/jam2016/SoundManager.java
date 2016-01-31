package uk.me.webpigeon.jams.jam2016;

import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

/**
 * This is the sound manager
 * 
 * He is busy at the moment
 * 
 * Partying and whatnot
 * 
 * Please leave a message after the ...
 * @author piers
 *
 */
public class SoundManager {
	private String backgroundFileName = "Ritual_Commute_Game_OST (1).aiff";

	private Clip backgroundMusic;
	
	public SoundManager() {
		try{
			backgroundMusic = AudioSystem.getClip();
			InputStream is = SoundManager.class.getClassLoader().getResourceAsStream(backgroundFileName);
			AudioInputStream sample = AudioSystem.getAudioInputStream(is);
			backgroundMusic.open(sample);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void startBackground(){
		backgroundMusic.loop(Integer.MAX_VALUE);
	}
}
