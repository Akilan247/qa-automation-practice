package org.example.Collection;

public class Staff {
    private int id;
    private String name;
    private int depId;

    public Staff(int id, String name, int depId){
        this.depId=depId;
        this.id = id;
        this.name = name;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public int getDepId() {
        return depId;
    }

    public void setDepName(int depId) {
        this.depId = depId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return " Staff :" +
                "\n\tid=" + id +
                ", name='" + name + '\'' +
                ", depId=" + depId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
