package br.com.wkgcosmeticos.helper;


import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHelper {


    private static final String UPLOAD_PATH = "/Users/mac/Documents/dev/merilym_WKG/src/main/resources/static/produtos";

    /**
     * @param fileName
     */
    public static void uploadImage(byte[] bytes, String fileName) {

        try {
            Path pathFile = Paths.get(UPLOAD_PATH + "/" + fileName);

            //Saving the file
            Files.write(pathFile, bytes);

        } catch (Exception e) {

            throw new RuntimeException("The API can't save the image", e);

        }

    }


    public static void remove(String fileName) {

        try {
            Path pathFile = Paths.get(UPLOAD_PATH + "/" + fileName);
            Files.delete(pathFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] imagenToByte(String nomeImagem) throws IOException {

        // Set headers
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);

        Path pathFile = Paths.get(UPLOAD_PATH + "/" + nomeImagem);

        InputStream inputStream = Files.newInputStream(pathFile);


        byte[] byteArray = IOUtils.toByteArray(inputStream);

        return byteArray;


    }

}
