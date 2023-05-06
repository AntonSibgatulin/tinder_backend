package ru.antonsibgatulin.tinder_backend.include.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.antonsibgatulin.tinder_backend.include.email.Email;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

@Data
@Entity
@Getter
@Setter
public class TokenUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;



    @ManyToOne
    @JoinColumn(name = "email_id")
    private Email email;


    public TokenUser() {
    }

    public TokenUser(Email email){
        this.email = email;
        generateToken();
    }

    public void generateToken(){
        this.code = encryptPassword("["+System.currentTimeMillis()+"] [USER] [AUTH] ["+System.currentTimeMillis()+"]");
    }

    private static String encryptPassword(String password)
    {
        String sha1 = "";
        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(password.getBytes("UTF-8"));
            sha1 = byteToHex(crypt.digest());
        }
        catch(NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch(UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        return sha1;
    }

    private static String byteToHex(final byte[] hash)
    {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
}
