package br.com.wkgcosmeticos.controller;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import br.com.wkgcosmeticos.entidades.FileUpload;
import br.com.wkgcosmeticos.entidades.Produto;
import br.com.wkgcosmeticos.repository.FileUploadRepository;
import br.com.wkgcosmeticos.repository.ProdutoRepository;

@RestController
@RequestMapping(value="/admin")
public class FileController {

	@Autowired
	FileUploadRepository repository;
	@Autowired
	ProdutoRepository produtoRepository;
	
	@RequestMapping(
            value = "/upload",
            method = RequestMethod.POST
        )
        public ResponseEntity uploadFile(MultipartHttpServletRequest request ) {
		int produtoId=Integer.parseInt(request.getParameter("produtoId"));
			Produto produto = produtoRepository.findOne(produtoId);
			
            try {
            	
            	//  request.getFileNames() =   {"Foto1", "Foto2"} 
                Iterator<String> keys = request.getFileNames();

                while (keys.hasNext()) {
                    //Nome
                	String key = keys.next();
                    
                	//Bytes 
                    MultipartFile file = request.getFile(key);
                    //Tipo Ex:
                    String mimeType = file.getContentType();
                    
                    //https://www.w3.org/Protocols/rfc1341/4_Content-Type.html
                    String filename = file.getOriginalFilename();
                   
                    //Dados do file
                    byte[] bytes = file.getBytes();
                    
                    //Entidade que guarda as inf da foto
                    FileUpload newFile = new FileUpload(filename, bytes, mimeType, produto);

                    //Salvando no banco
                    repository.save(newFile);
                }
            }
            catch (Exception e) {
                return new ResponseEntity<>("{}", HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return new ResponseEntity<>("{}", HttpStatus.OK);
        }
	
	//Listagem de imagens
	
	@RequestMapping(value="/imagens", method=RequestMethod.GET)
	public Collection<FileUpload> buscarTodos(){
 		return repository.findAll();
 	}
	//Exclusão de imagens
	
	@RequestMapping(value = "/imagens/{id}", method= RequestMethod.DELETE)
	public void excluir(@PathVariable Integer id){
		repository.delete(id);
	}
	
	// Download a file
    @RequestMapping(
        value = "/download",
        method = RequestMethod.GET
    )
    public ResponseEntity downloadFile(@RequestParam("fileName") String fileName) {

        FileUpload fileUpload = repository.findByFileName(fileName);

        // No file found based on the supplied filename
        if (fileUpload == null) {
            return new ResponseEntity<>("{}", HttpStatus.NOT_FOUND);
        }

        // Generate the http headers with the file properties
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-disposition", "attachment; filename=" + fileUpload.getFileName());

        // Split the mimeType into primary and sub types
        String primaryType, subType;
        try {
            primaryType = fileUpload.getMimeType().split("/")[0];
            subType = fileUpload.getMimeType().split("/")[1];
        }
            catch (IndexOutOfBoundsException | NullPointerException ex) {
            return new ResponseEntity<>("{}", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        headers.setContentType( new MediaType(primaryType, subType) );

        return new ResponseEntity<>(fileUpload.getFile(), headers, HttpStatus.OK);
    }
    

	// Download a file
    @RequestMapping(
        value = "/download/{id}",
        method = RequestMethod.GET
    )
    public ResponseEntity downloadFile(@PathVariable("id") Integer id) {

        FileUpload fileUpload = repository.findOne(id);

        // No file found based on the supplied filename
        if (fileUpload == null) {
            return new ResponseEntity<>("{}", HttpStatus.NOT_FOUND);
        }

        // Generate the http headers with the file properties
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-disposition", "attachment; filename=" + fileUpload.getFileName());

        // Split the mimeType into primary and sub types
        String primaryType, subType;
        try {
            primaryType = fileUpload.getMimeType().split("/")[0];
            subType = fileUpload.getMimeType().split("/")[1];
        }
            catch (IndexOutOfBoundsException | NullPointerException ex) {
            return new ResponseEntity<>("{}", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        headers.setContentType( new MediaType(primaryType, subType) );

        return new ResponseEntity<>(fileUpload.getFile(), headers, HttpStatus.OK);
    }
	
	
	

}
