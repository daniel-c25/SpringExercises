package uploaddownload;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Paths;
@Service
public class UploadService {
    static String filePath;

    public String  postPicture(MultipartFile file) throws IOException {
            file.transferTo(Paths.get("C:\\Users\\Alfre\\Desktop\\LaDirectorySeria" + file.getOriginalFilename()));
            filePath = "C:\\Users\\Alfre\\Desktop\\LaDirectorySeria" + file.getOriginalFilename();
            return "file saved successfully !!! ";

    }
    
    public ResponseEntity<Resource> downloadPicture() {
        FileSystemResource file = new FileSystemResource(filePath);
        return new ResponseEntity<>(file, HttpStatus.OK);
    }
}