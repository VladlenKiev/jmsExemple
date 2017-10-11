package com.company.activemq.sender;

/**
 * Interface {@code Sender} initialize send method.
 *
 * @author V.Mankivskiy
 * @see com.company.activemq.reciever.app.Main
 * @since 1.0.2
 * @date 06.09.2017
 */
public interface Sender {

    public void sendMessage(String msg);
}
