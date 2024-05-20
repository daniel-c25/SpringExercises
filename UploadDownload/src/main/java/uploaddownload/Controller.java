package uploaddownload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class Controller {
@Autowired
UploadService service;

    @PostMapping(value = "/add-picture", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String addPicture(@RequestPart MultipartFile file) throws IOException {
        return service.postPicture(file);
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> getPicture () {
        return service.downloadPicture();
    }
}