package less5service;

public class Content {

    private final long id;
    private final String content;
    private final Integer age;

    public Content(long id, String content, Integer age) {
        this.id = id;
        this.content = content;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Integer getAge() {
        return age;
    }
}
