package net.kzn.onlineshopping.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

// klasa sluzy do uploadu plikow

public class FileUploadUtility {

	private static final String ABS_PATH = "C:/Users/EZWIEKR/eclipse-workspace/Spring - Projekt/onlineshopping/src/main/webapp/assets/images/";
	// mozna tez zapisywac jako ABS_PATH = "C:\\Users\\EZWIEKR\\eclipse-workspace\\Spring - Projekt\\onlineshopping\\src\\main\\webapp\\assets\\images";
	private static String REAL_PATH = "";
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);
	
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) 
	{				
		// get the real server path
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");
		
		logger.info(REAL_PATH);
		
		// sprawdzenie czy istnieje podany folder - jesli nie nastapi utworzenie folderu
		if(!new File(ABS_PATH).exists()) {
			new File(ABS_PATH).mkdirs(); // utworzenie nowego folderu
		}
		
		if(!new File(REAL_PATH).exists()) {
			new File(REAL_PATH).mkdirs(); // utworzenie nowego folderu
		}
		
		
		
		//transfer the file to both the location
		try {
			// server upload - pod nazwa taka jak kod produktu
			file.transferTo(new File(REAL_PATH + code + ".jpg"));
			// project directory upload - pod nazwa taka jak kod produktu
			file.transferTo(new File(ABS_PATH + code + ".jpg"));
		}
		catch (IOException ex) {
			
		}
		

	}

		
	
}






