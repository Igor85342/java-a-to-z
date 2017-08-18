package ru.moskalets.generic.task2;

/**
 * Base class for objects in the repository.
 * @author Igor Moskalets
 * @since 18.08.2017
 */
public abstract class Base {
    private String id;
    public Base(String id){
        this.id =id;
    }
    /**
     * This method returns the value of the field "Id".
     * @return String.
     */
    public String getId(){
        return this.id;
    }
    /**
     * This method populates the value of the Id field.
     * @param String id.
     */
    public void setId(String id){
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Base base = (Base) o;

        return id != null ? id.equals(base.id) : base.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
