package app.entity;

import java.util.Objects;

public class Message {
    private int messageId;
    private int fromId;
    private String Content;
    private int toId;

    public Message(int messageId, int fromId, String content, int toId) {
        this.messageId = messageId;
        this.fromId = fromId;
        Content = content;
        this.toId = toId;
    }

    public Message(int fromId, String content, int toId) {
        this.fromId = fromId;
        Content = content;
        this.toId = toId;
    }

    public Message() {
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getFromId() {
        return fromId;
    }

    public void setFromId(int fromId) {
        this.fromId = fromId;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public int getToId() {
        return toId;
    }

    public void setToId(int toId) {
        this.toId = toId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return messageId == message.messageId && fromId == message.fromId && toId == message.toId && Content.equals(message.Content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, fromId, Content, toId);
    }
}
