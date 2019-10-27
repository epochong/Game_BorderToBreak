package BorderToBreak;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Music{
	boolean looping=false;
	File file1=new File("12.au");
	@SuppressWarnings("deprecation")
	AudioClip sound1;
	AudioClip chosenClip;
	
	public Music() {
		try {
			sound1=Applet.newAudioClip(file1.toURL());
		}catch(MalformedURLException ex) {
			Logger.getLogger(Music.class.getName()).log(Level.SEVERE,null,ex);
		}
		
		chosenClip=sound1;
		looping=true;
		chosenClip.loop();
	}
	
	public Music(String string) {
		file1=new File(string);
		try {
			sound1=Applet.newAudioClip(file1.toURL());
		}catch(MalformedURLException ex) {
			Logger.getLogger(Music.class.getName()).log(Level.SEVERE,null,ex);
		}
		chosenClip=sound1;
		looping=true;
		chosenClip.loop();
	}
	
	public void Close() {
		chosenClip.stop();
	}
}
