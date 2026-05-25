package com.management.email;

import java.util.List;
import java.util.ArrayList;

public class MailSystem {

    private String sender;
    private String receiver;
    private String subject;
    private String content;
    private String label;

    private boolean isSpam;

    private List<String> tags;

    public MailSystem(String sender, String receiver, String subject, String content) {

        this.sender = sender;
        this.receiver = receiver;
        this.subject = subject;
        this.content = content;

        this.tags = new ArrayList <> ();
    }

    public String getSender() { return sender; }

    public String getReceiver() { return receiver; }

    public String getSubject() { return subject; }

    public String getContent() { return content; }

    public void setIsSpam(boolean spam) { this.isSpam = spam; }

    public List<String> getTags() { return tags; }

    public void addTag(String tag) {
        if(!tags.contains(tag))
            tags.add(tag);
    }

    public void removeTag(String tag) {
        if(tags.contains(tag))
            tags.remove(tag);
    }

    @Override
    public String toString() {
        return '\n' + "Sender : " + sender + '\n' + "Receiver : " + receiver + '\n' + "Subject : " + subject + '\n'
                + "Content : " + content + '\n' + "Tag : " + tags + '\n' + "IsSpam : " + isSpam + '\n';
    }


}
