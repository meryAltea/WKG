package br.com.wkgcosmeticos.controller;

import br.com.wkgcosmeticos.entidades.FileUpload;
import br.com.wkgcosmeticos.entidades.Produto;
import br.com.wkgcosmeticos.helper.FileHelper;
import br.com.wkgcosmeticos.repository.FileUploadRepository;
import br.com.wkgcosmeticos.repository.ProdutoRepository;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class FileController {

    @Autowired
    FileUploadRepository repository;
    @Autowired
    ProdutoRepository produtoRepository;


    /**
     * Faz Upload de arquivo
     *
     * @param request
     * @param produtoId id do produto a ser vinculo a imagem
     * @return o imagen recem enviada para inclusão na lista de imagem na tela
     */
    @PostMapping(value = "/upload/{id}")
    public ResponseEntity<FileUpload> uploadFile(MultipartHttpServletRequest request, @PathVariable("id") Integer produtoId) {

        Produto produto = produtoRepository.findOne(produtoId);

        FileUpload fileUpload=null;
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
                 fileUpload = new FileUpload(filename, bytes, mimeType, produto);

                //Salvando no diretorio

                FileHelper.uploadImage(bytes, filename);

                //Salvando no banco
                repository.save(fileUpload);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(fileUpload , HttpStatus.OK);
    }


    /**
     * Busca todos os registros de imagens e antes de exibir na tela,
     * acessa o arquivo fisico da imagem  na pasta e gera e transfornam a imagem em  byte[]
     * para inclusao no objeto fileUpload na propriedade file, sendo assim gerado no json
     * @return
     */
    @GetMapping(value = "/imagens/{produtoId}")
    public Collection<FileUpload> buscarTodos(@PathVariable("produtoId") Integer produtoId) {
        //busca todos registro no banco sem image, apenas com nome da imagem
        List<FileUpload> lista = repository.buscarPorProdutoId(produtoId);


        for (FileUpload fileUpload : lista) {
            try {
                fileUpload.setFile(FileHelper.imagenToByte(fileUpload.getFileName()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }

    /**
     * Remove do registro no banco e também da pasta fisica arquivo
     * @param id
     */
    @DeleteMapping(value = "/imagens/{id}")
    public void excluir(@PathVariable Integer id) {

        FileUpload file = repository.findOne(id);
        FileHelper.remove(file.getFileName());

        //Removendo do banco
        repository.delete(id);

    }



}
