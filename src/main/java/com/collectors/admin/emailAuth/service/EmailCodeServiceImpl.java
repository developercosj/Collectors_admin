package com.collectors.admin.emailAuth.service;

import java.util.Random;

import com.collectors.admin.emailAuth.interfaces.EmailCodeService;
import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailCodeServiceImpl implements EmailCodeService {

    // private final Logger logger = LogManager.getLogger(EmailServiceImpl.class);

    @Autowired
    JavaMailSender emailSender;
    public static final String ePw = createKey();

    // MIME(Multipurpose Internet Mail Extensions) : 전자 우편을 위한 인터넷 표준 포맷
    @Override
    public String sendSimpleMessage(String to)throws Exception {
        MimeMessage message = createMessage(to);
        try{
            emailSender.send(message);
        }catch(MailException es){
            es.printStackTrace();
            throw new IllegalArgumentException();
        }
        return ePw;
    }

    private MimeMessage createMessage(String to)throws Exception{
        // logger.debug("보내는 대상 : " + to);
        // logger.debug("인증 번호 : " + ePw );
        MimeMessage  message = emailSender.createMimeMessage();

        // To
        message.addRecipients(Message.RecipientType.TO, to);
        // 제목
        message.setSubject("이메일 인증 테스트");

        String msgg="";
        msgg+= "<div style='margin:20px;'>";
        msgg+= "<h1> 안녕하세요 collectors 어드민 가입 인증 번호입니다. </h1>";
        msgg+= "<br>";
        msgg+= "<p> 아래 코드를 복사해 입력해주세요 <p>";
        msgg+= "<br>";
        msgg+= "<p> 감사합니다. <p>";
        msgg+= "<br>";
        msgg+= "<div align='center' style='border:1px solid black; font-family:verdana';>";
        msgg+= "<h3 style='color:blue;'>회원가입 인증 코드입니다.</h3>";
        msgg+= "<div style='font-size:130%'>";
        msgg+= "CODE : <strong>";
        msgg+= ePw + "</strong><div><br/> ";
        msgg+= "</div>";
        message.setText(msgg, "utf-8", "html");//내용
        message.setFrom(new InternetAddress("developercosj@gmail.com","Collectors"));//보내는 사람

        return message;
    }

    public static String createKey() {
        StringBuffer key = new StringBuffer();
        Random rnd = new Random();

        for (int i = 0; i < 8; i++) { // 인증코드 8자리
            int index = rnd.nextInt(3); // 0~2 까지 랜덤

            switch (index) {
                case 0:
                    key.append((char) ((int) (rnd.nextInt(26)) + 97));
                    //  a~z
                    break;
                case 1:
                    key.append((char) ((int) (rnd.nextInt(26)) + 65));
                    //  A~Z
                    break;
                case 2:
                    key.append((rnd.nextInt(10)));
                    // 0~9
                    break;
            }
        }
        return key.toString();
    }


}
