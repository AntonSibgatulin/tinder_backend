package ru.antonsibgatulin.tinder_backend.controllers.files;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.antonsibgatulin.tinder_backend.dto.AuthDTO;
import ru.antonsibgatulin.tinder_backend.include.email.Email;
import ru.antonsibgatulin.tinder_backend.include.email.repository.EmailRepository;
import ru.antonsibgatulin.tinder_backend.include.error.Error;
import ru.antonsibgatulin.tinder_backend.include.files.FileUploadResponse;
import ru.antonsibgatulin.tinder_backend.include.files.FileUploadUtil;
import ru.antonsibgatulin.tinder_backend.include.system.result.Response;
import ru.antonsibgatulin.tinder_backend.include.user.image.Image;
import ru.antonsibgatulin.tinder_backend.include.user.repository.TokenUserRepository;
import ru.antonsibgatulin.tinder_backend.include.user.repository.UserRepository;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/files")
public class FIlesWorkingController {
    private final UserRepository userRepository;
    private final EmailRepository emailRepository;
    private final TokenUserRepository tokenUserRepository;

    public FIlesWorkingController(UserRepository userRepository, EmailRepository emailRepository, TokenUserRepository tokenUserRepository) {
        this.userRepository = userRepository;
        this.emailRepository = emailRepository;
        this.tokenUserRepository = tokenUserRepository;
    }


    @PostMapping("/uploadFile")
    public Response uploadFile(@Valid @RequestBody AuthDTO authDTO,
                               @RequestParam("file") MultipartFile multipartFile)
            throws IOException {

        Email email = tokenUserRepository.getTokenUserByCode(authDTO.getToken()).getEmail();
        if(email==null){
            new Response("TOKEN_INVALID", Error.TOKEN_INVALID);
        }else{
            if(email.getUser()==null){
                new Response("USER_STILL_SEND_DATA",Error.USER_STILL_SEND_DATA);
            }
        }

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        long size = multipartFile.getSize();

        String fileCode = FileUploadUtil.saveFile(fileName, multipartFile);

        FileUploadResponse responseFile = new FileUploadResponse();
        responseFile.setFileName(fileName);
        responseFile.setSize(size);
        responseFile.setDownloadUri("/downloadFile/" + fileCode);

        Response response = new Response("OK",Error.OK);
        response.setFileUploadResponse(responseFile);

        Image image = new Image("/downloadFile/" + fileCode, email.getUser().getId(),System.currentTimeMillis(),0);
        email.getUser().getImages().add(image);
        userRepository.save(email.getUser());

        return response;
    }


}
