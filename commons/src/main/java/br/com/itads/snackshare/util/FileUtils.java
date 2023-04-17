package br.com.itads.snackshare.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * @author marioromeu
 * @email mario.romeu@gmail.com
 *
 */
@Component
public class FileUtils {

	@Value("${snackshare.tmp.dir}")
	private String tempDir;
	
	/**
	 * 
	 */
	private FileOutputStream outputStream;	
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	public File byteArrayConverterToQrCodeImage(byte[] array, String fileName, String fileExtension) {

		File outputFile = null;
		
		try {
			
			File directory = new File(tempDir);
			
			outputFile = File.createTempFile(fileName, fileExtension, directory);
			
			outputStream = new FileOutputStream(outputFile);

		    outputStream.write(array);
		    
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return outputFile;
	}
	
}
