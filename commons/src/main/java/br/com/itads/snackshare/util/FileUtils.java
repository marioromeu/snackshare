package br.com.itads.snackshare.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
public class FileUtils {

	/**
	 * 
	 */
	private static FileOutputStream outputStream;	
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	public static File byteArrayConverterToQrCodeImage(byte[] array, String fileName, String fileExtension) {

		File outputFile = null;
		
		try {
			
			outputFile = File.createTempFile(fileName, fileExtension);
			
			outputStream = new FileOutputStream(outputFile);

		    outputStream.write(array);
		    
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return outputFile;
	}
	
}
