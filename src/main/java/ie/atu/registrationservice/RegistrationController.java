package ie.atu.registrationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RegistrationController {

    private NotificationServiceClient notificationServiceClient;
    @Autowired
    public RegistrationController(NotificationServiceClient notificationServiceClient) {
        this.notificationServiceClient = notificationServiceClient;
    }
    @PostMapping("/confirm")
    public String confirmDetails(@RequestBody UserDetails userDetails) {
        String message = String.format("Details received for %s, email %s",
                                        userDetails.getName(), userDetails.getEmail());
        return message;
    }

    @PostMapping("/SendNotification")
    public String notify(@RequestBody UserDetails userDetails) {
        String message = notificationServiceClient.sendNotification(userDetails);
        return message;
    }

}
