package com.company.activemq.reciever.impl;

import com.company.activemq.reciever.Receiver;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Class {@code RecieverImpl} define recieving procedure method.
 *
 * @author V.Mankivskiy
 * @see com.company.activemq.reciever.Receiver
 * @since 1.0.2
 * @date 29.08.2017
 */
public class ReceiverImpl implements Receiver {
        private ConnectionFactory factory = null;
        private Connection connection = null;
        private Session session = null;
        private Destination destination = null;
        private MessageConsumer consumer = null;

        public ReceiverImpl() {
        }

    @Override
    public void receiveMessage() {
        try {
            factory = new ActiveMQConnectionFactory(
                    ActiveMQConnection.DEFAULT_BROKER_URL);
            connection = factory.createConnection();

            connection.start();
            session = connection.createSession(false, Session.DUPS_OK_ACKNOWLEDGE);
            destination = session.createQueue("SAMPLEQUEUE5");
            consumer = session.createConsumer(destination);

            //Message message = consumer.receive();
            Message message = consumer.receive();

            if (message instanceof TextMessage) {
                TextMessage text = (TextMessage) message;
                System.out.println("Message is : " + text.getText());
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }


}



