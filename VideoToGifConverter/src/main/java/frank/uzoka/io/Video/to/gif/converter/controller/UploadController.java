package frank.uzoka.io.Video.to.gif.converter.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
public class UploadController {


    @Value("${multipart.location}")
    private String location;

    @RequestMapping(value = "/upload", method = RequestMethod.POST,produces = MediaType.IMAGE_GIF_VALUE)
    public String upload(@RequestPart("file") MultipartFile file,
                         @RequestParam("start")int start,
                         @RequestParam("end")int end,
                         @RequestParam("speed")int speed,
                         @RequestParam("repeat")boolean repeat) throws Exception{

        File videoFile = new File(location + "/" + System
                .currentTimeMillis() + ".mp4");

        file.transferTo(videoFile);

        return "";


    }
}
