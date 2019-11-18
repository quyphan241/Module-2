package Model;

public class Login {
    private int id;
    private String name;
    private byte authority;
    public Login() {
    }

    public Login(int id, String name, byte authority) {
        this.id = id;
        this.name = name;
        this.authority = authority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAuthority() {
        return authority;
    }

    public void setAuthority(byte authority) {
        this.authority = authority;
    }
}
