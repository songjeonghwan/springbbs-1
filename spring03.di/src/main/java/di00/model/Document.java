package di00.model;

public class Document {
    
    private String name;
    private Type type;
    private String location;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public Document(String name, Type type, String location) {
        super();
        this.name = name;
        this.type = type;
        this.location = location;
    }
    public Document() {
        super();
    }
    @Override
    public String toString() {
        return "Document [name=" + name + ", type=" + type + ", location="
                + location + "]";
    }
    
}
