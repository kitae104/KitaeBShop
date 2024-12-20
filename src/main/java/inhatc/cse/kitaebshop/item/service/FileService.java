package inhatc.cse.kitaebshop.item.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
@Slf4j
public class FileService {

    public String uploadFile(String uploadPath, String originalFileName,
                             byte[] fileData) throws IOException {

        UUID uuid = UUID.randomUUID();
        String ext = originalFileName.substring(originalFileName.lastIndexOf("."), originalFileName.length());
        String savedFileName = uuid.toString() + ext;
        String fileUploadFullPath = uploadPath + "/" + savedFileName;

        FileOutputStream fos = new FileOutputStream(fileUploadFullPath);
        fos.write(fileData);
        fos.close();
        return savedFileName;
    }

    public void deleteFile(String filePath) {
        File deleteFile = new File(filePath);
        if(deleteFile.exists()){
            deleteFile.delete();
            log.info("파일을 삭제 했습니다.");
        } else {
            log.info(filePath + "파일이 존재하지 않습니다.");
        }

    }
}
