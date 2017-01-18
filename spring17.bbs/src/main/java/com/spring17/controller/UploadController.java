package com.spring17.controller;

import java.io.File;
import java.io.IOException;
import java.util.*;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartFile;

import com.spring17.commons.*;
import com.spring17.model.*;
import com.spring17.repository.*;
import com.spring17.service.*;

@Controller
@RequestMapping("/upload")
public class UploadController  {

    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
    
    @Autowired
    @Qualifier("serviceboard")
	private IServiceBoard boardsrv; 
    public IServiceBoard getBoardsrv() { return boardsrv; } 
    public void setBoardsrv(IServiceBoard boardsrv) { this.boardsrv = boardsrv; } 
	
    public UploadController() {
        super();
    }


    /**
     * http://localhost/upload/uploadfile
     */
    @RequestMapping(value = "/uploadfile", method = RequestMethod.GET)
    public String uploadfile(Model model)  {

        logger.info("UploadController.uploadfile");

        return "upload/uploadfile";
    }

    /**
     * http://localhost/upload/uploadfileone
     * @throws IOException 
     * @throws IllegalStateException 
     */
    @RequestMapping(value = "/uploadfileone", method = RequestMethod.POST)
    public String uploadfileone(@ModelAttribute MultipartFile file, Model model) throws IllegalStateException, IOException  {

        logger.info("UploadController.uploadfileone");
        
        // uploadsuccess.jsp 에 출력할 파일이름.
        List<String> filelist = new ArrayList<String>();
                
        // 로컬 파일을 서버로 올리기 위한 코드
        String fileName = file.getOriginalFilename();
        String filepath = WebConstants.UPLOAD_PATH + "/" + fileName;                 
        File f = new File( filepath );                
        file.transferTo( f );

        // uploadsuccess.jsp 에 출력할 파일이름 저장
        filelist.add(fileName);
        
        // DB insert 처리를 위한 코드
        ModelAttachfile attachfile = new ModelAttachfile();
        attachfile.setFilename( f.getName() );
        attachfile.setFiletype( FilenameUtils.getExtension(fileName) ); // 확장자
        attachfile.setFilesize( (int)f.length() );
        attachfile.setArticleno( 0 );

        // DB insert 
        boardsrv.insertAttachFile(attachfile);
        
        model.addAttribute("files", filelist);
 
        return "upload/uploadsuccess";
    }
    /**
     * http://localhost/upload/uploadfilemulti
     * @throws IOException 
     * @throws IllegalStateException 
     */
    @RequestMapping(value = "/uploadfilemulti", method = RequestMethod.POST)
    public String uploadfilemulti(@ModelAttribute RepositoryFiles uploadForm, Model model) throws IllegalStateException, IOException  {

        logger.info("UploadController.uploadfilemulti");
        
        List<MultipartFile> files = uploadForm.getFiles();
        
        // uploadsuccess.jsp 에 출력할 파일이름.
        List<String> filelist = new ArrayList<String>();        
        
        if( files != null && files.size() > 0 ){
            
            for (MultipartFile file : files) {
                // 로컬 파일을 서버로 올리기 위한 코드
                String fileName = file.getOriginalFilename();
                String filepath = WebConstants.UPLOAD_PATH + "/" + fileName;                 
                File f = new File( filepath );                
                file.transferTo( f );

                // uploadsuccess.jsp 에 출력할 파일이름 저장
                filelist.add(fileName);
                
                // DB insert 처리를 위한 코드
                ModelAttachfile attachfile = new ModelAttachfile();
                attachfile.setFilename( f.getName() );
                attachfile.setFiletype( FilenameUtils.getExtension(fileName) ); // 확장자
                attachfile.setFilesize( (int)f.length() );
                attachfile.setArticleno( 0 );

                // DB insert 
                boardsrv.insertAttachFile(attachfile);
            }
        }        

        model.addAttribute("files", filelist);
 
        return "upload/uploadsuccess";
    }
    
}
