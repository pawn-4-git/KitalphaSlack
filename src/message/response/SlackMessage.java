/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package message.response;

/**
 *
 * @author Pawn
 */
public class SlackMessage {
    private String botId;
    private String type;
    private String text;
    private String user;
    private String ts;
    private String team;
    
    private BotProfile botProfile;

    /**
     * @return the botId
     */
    public String getBotId() {
        return botId;
    }

    /**
     * @param botId the botId to set
     */
    public void setBotId(String botId) {
        this.botId = botId;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the ts
     */
    public String getTs() {
        return ts;
    }

    /**
     * @param ts the ts to set
     */
    public void setTs(String ts) {
        this.ts = ts;
    }

    /**
     * @return the team
     */
    public String getTeam() {
        return team;
    }

    /**
     * @param team the team to set
     */
    public void setTeam(String team) {
        this.team = team;
    }

    /**
     * @return the botProfile
     */
    public BotProfile getBotProfile() {
        return botProfile;
    }

    /**
     * @param botProfile the botProfile to set
     */
    public void setBotProfile(BotProfile botProfile) {
        this.botProfile = botProfile;
    }
    
    
    
}
