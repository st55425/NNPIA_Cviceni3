package cz.upce.nnpia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class EmailService {

    @Autowired
    private CounterService counterService;

    private String email;


    public boolean isValid(){
        String regex = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return  matcher.matches();
    }

    public String getInfo() {
        if (email == null || email.isEmpty()){
            return "";
        }
        if (isValid()){
            counterService.addSubscribersCount();
            return "Registrace proběhla úspěšně, newsletter bude zasílán na email " + email;
        }
        else {
            return  "Je mi líto email  " + email + " není validní";
        }
    }

    public void setEmail(String email) {
        if (!email.isEmpty())
            this.email = email;
    }
}
