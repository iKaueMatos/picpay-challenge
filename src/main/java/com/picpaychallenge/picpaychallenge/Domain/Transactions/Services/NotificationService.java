package com.picpaychallenge.picpaychallenge.Domain.Transactions.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.picpaychallenge.picpaychallenge.Application.DTO.Transaction.NotificationDTO;
import com.picpaychallenge.picpaychallenge.Persistence.Entity.UsersEntity;

@Service
public class NotificationService {
    
    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(UsersEntity usersEntity, String message) throws Exception {
        String email = usersEntity.getEmail();
        NotificationDTO notificationRequest = new NotificationDTO(email, message);
        
        ResponseEntity<String> notificationResponse = restTemplate.postForEntity("http://o4d9z.mocklab.io/notify", notificationRequest, String.class);

        if (!(notificationResponse.getStatusCode() == HttpStatus.OK)) {
            throw new Exception("Serviço de notificação esta fora do ar!");
        }
    }
}
