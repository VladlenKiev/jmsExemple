package com.company.activemq.sender.impl;

import com.company.activemq.sender.Sender;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Class {@code SenderImpl} initialize send method.
 *
 * @author V.Mankivskiy
 * @see com.company.activemq.reciever.app.Main
 * @since 1.0.2
 * @date 06.09.2017
 */
public class SenderImpl implements Sender{

    private ConnectionFactory factory = null;
    private Connection connection = null;
    private Session session = null;
    private Destination destination = null;
    private MessageProducer producer = null;

    public SenderImpl() {

    }

    public void sendMessage(String msg) {

        try {
            factory = new ActiveMQConnectionFactory(
                    ActiveMQConnection.DEFAULT_BROKER_URL);
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("SAMPLEQUEUE5");
            producer = session.createProducer(destination);
            TextMessage message = session.createTextMessage();
            //message.setText("Hello ...This is a sample message..sending from FirstClient");
            message.setText(msg);
            producer.send(message);
            System.out.println("Sent: " + message.getText());

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
