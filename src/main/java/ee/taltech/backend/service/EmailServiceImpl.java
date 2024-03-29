package ee.taltech.backend.service;

import ee.taltech.backend.model.order.ClientOrder;
import ee.taltech.backend.model.order.OrderMeal;
import ee.taltech.backend.model.order.OrderProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;

@Component
public class EmailServiceImpl {

    @Autowired
    private JavaMailSender emailSender;
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    public void sendSimpleMessage(ClientOrder clientOrder) {
        emailSender.send(constructSimpleMailMessage(clientOrder));
    }

    public SimpleMailMessage constructSimpleMailMessage(ClientOrder clientOrder) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("taltechdonalds@gmail.com");
        message.setTo(clientOrder.getEmail());
        message.setSubject("TalTech Donald's Order Confirmation");
        message.setText(constructEmail(clientOrder).toString());
        return message;
    }

    public StringBuilder constructEmail(ClientOrder clientOrder) {
        StringBuilder text = new StringBuilder("Thank you for you order!\n \nOrder:\n \n");
        for (OrderProduct orderProduct : clientOrder.getOrderProducts()) {
            text.append(orderProduct.getName()).append(", price:").append(df2.format(orderProduct.getPrice())).append("€\n");
            if (orderProduct.getRemovedIngredients().length() != 0) {
                text.append("\nRemoved ingredients: ").append(orderProduct.getRemovedIngredients());
            }
            text.append("\n \n");
        }
        for (OrderMeal orderMeal : clientOrder.getOrderMeals()) {
            text.append(orderMeal.getName()).append(", price:").append(df2.format(clientOrder.getPrice())).append("€\n");
            for (OrderProduct orderProduct : orderMeal.getOrderProducts()) {
                text.append(orderProduct.getName());
                if (orderProduct.getRemovedIngredients().length() != 0) {
                    text.append("\nRemoved ingredients: ").append(orderProduct.getRemovedIngredients());
                }
                text.append("\n");
            }
            text.append("\n");
        }
        text.append("Order price:").append(df2.format(clientOrder.getPrice())).append("€\n");
        text.append("Pick-up location: ").append(clientOrder.getLocation().getAddress());
        return text;
    }
}
