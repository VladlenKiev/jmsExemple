package com.company.activemq.reciever.app;

import com.company.activemq.reciever.Receiver;
import com.company.activemq.reciever.impl.ReceiverImpl;
import com.company.activemq.sender.Sender;
import com.company.activemq.sender.impl.SenderImpl;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Class {@code Main} is enter point for App.
 *
 * @author V.Mankivskiy
 * @see com.company.activemq.reciever.app.Main
 * @since 1.0.2
 * @date 06.09.2017
 */
public class Main {
    public static void main(String[] args) {


        Receiver receiver = new ReceiverImpl();
        Sender sender = new SenderImpl();
        sender.sendMessage("Hello!");
        //sender.sendMessage("How are you?");
        //sender.sendMessage("You will come?");

        receiver.receiveMessage();



        try {


            // Create a ConnectionFactory
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("vm://localhost");

            // Create a Connection
            Connection connection = connectionFactory.createConnection();
            connection.start();

            // Create a Session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create the destination (Topic or Queue)
            Destination destination = session.createQueue("TEST.FOO");

            // Create a MessageProducer from the Session to the Topic or Queue
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            // Create a messages
            String text = "Hello world! From: ";
            TextMessage message = session.createTextMessage(text);

            // Tell the producer to send the message
            System.out.println("Sent message: "+ message.hashCode() + " : " + Thread.currentThread().getName());
            producer.send(message);

            // Clean up
            session.close();
            connection.close();

        }catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
        }
    }
}
