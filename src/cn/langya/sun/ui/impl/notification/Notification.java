package cn.langya.sun.ui.impl.notification;

public class Notification {
    private String title;
    private String content;
    private NotificationType type;

    public Notification(String title, String content, NotificationType type) {
        this.title = title;
        this.content = content;
        this.type = type;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }
}
