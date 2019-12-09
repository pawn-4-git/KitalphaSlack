/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package message.response;

import java.util.List;

/**
 *
 * @author Pawn
 */
public class GetMessageResponse {
    private boolean ok;
    private List<SlackMessage> messages;

    /**
     * @return the ok
     */
    public boolean isOk() {
        return ok;
    }

    /**
     * @param ok the ok to set
     */
    public void setOk(boolean ok) {
        this.ok = ok;
    }

    /**
     * @return the messages
     */
    public List<SlackMessage> getMessages() {
        return messages;
    }

    /**
     * @param messages the messages to set
     */
    public void setMessages(List<SlackMessage> messages) {
        this.messages = messages;
    }
    
}
