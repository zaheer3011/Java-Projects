package com.management.email;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MailManagement {

    private List<MailSystem> mailList = new ArrayList<> ();

    private Set<String> spamList = new HashSet<> (Arrays.asList("congratulation", "lottery", "winner", "prize"));

    public void storeEmail(MailSystem mailSystem) {

        try {
            String content = mailSystem.getContent();
            if(checkSpam(content))
                mailSystem.setIsSpam(true);
            else
                mailSystem.setIsSpam(false);

            mailList.add(mailSystem);
            System.out.println("Mail added Successfully....");
            System.out.println(mailSystem);
        }

        catch(Exception exe) {
            System.out.println(exe.getMessage());
        }

    }

    public void deleteEmail(int index) {

        if(isValidIndex(index)) {
            mailList.remove(index);
            System.out.println("Mail Deleted");
        }

        else {
            System.out.println("Invalid Index");
        }
    }

    public void addTag(int index, String tag) {

        if(isValidIndex(index)) {
            mailList.get(index).addTag(tag);
            System.out.println("Tag Name Added successfully");
            MailSystem mailSystem = mailList.get(index);
            System.out.println(mailSystem);
        }

        else {
            System.out.println("Invalid Index");
        }

    }

    public void showStatistics(int recent) {

        if(recent == mailList.size() || isValidIndex(recent)) {
            mailList.stream().skip(Math.max(0, mailList.size() - recent))
                    .forEach(System.out::println);
        }

        else {
            System.out.println("Invalid Index");
        }

    }

    // TO display the No Of Emails
    public int printNoOfMails() {
        return mailList.size();
    }


    public void searchMail(String query) {

       List<MailSystem> result = mailList.stream().filter(mail -> {
                  return mail.getSender().toLowerCase().contains(query) ||
                   mail.getReceiver().toLowerCase().contains(query) ||
                   mail.getSubject().toLowerCase().contains(query) ||
                   mail.getContent().toLowerCase().contains(query) ||
                   mail.getTags().stream().anyMatch(tag ->
                           tag.toLowerCase().contains(query));
       }).collect(Collectors.toList());

       if(result.isEmpty()) {
           System.out.println("Not Available");
       }

       else {
            System.out.println(result);
       }
    }

    public void wildCardSearch(String query) {

        String pattern = query.replace("*", ".*");
        List<MailSystem> result = mailList.stream().filter(mail -> {
                return mail.getSender().toLowerCase().matches(pattern) ||
                mail.getReceiver().toLowerCase().matches(pattern) ||
                mail.getSubject().toLowerCase().matches(pattern) ||
                mail.getContent().toLowerCase().matches(pattern) ||
                mail.getTags().stream().anyMatch(tag -> tag.toLowerCase().matches(pattern));
        }).collect(Collectors.toList());


        if(result.isEmpty()) {
            System.out.println("Not Available");
        }

        else {
            System.out.println(result);
        }


    }

    // To Check a Valid Index
    public boolean isValidIndex(int index) {

        return index >= 0 && index < mailList.size();
    }


    public boolean checkSpam(String content) {

        if(content == null) return false;

       for(String word : spamList) {

           if(content.toLowerCase().contains(word))
               return true;
       }

        return false;

    }
}
