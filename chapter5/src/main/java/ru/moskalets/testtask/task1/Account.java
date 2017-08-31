package ru.moskalets.testtask.task1;

/**
 * The class stores information about the account name and its value.
 * author Igor Moskalets
 * Since 15.06.2017
 */
public class Account {
    /**
     * Account details.
     */
    private String requisites;
    /**
     * The amount of the invoice.
     */
    private Double value;
    /**
     * Constructor.
     * @param requisites This requisites.
     * @param value This value.
     */
    public Account(String requisites, Double value) {
        this.requisites = requisites;
        this.value = value;
    }
    /**
     * Return this value.
     * @return Double.
     */
    public Double getValue() {
        return this.value;
    }
    /**
     * Add value.
     * @param value This value.
     */
    public void setValue(Double value) {
        this.value = value;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        if (requisites != null ? !requisites.equals(account.requisites) : account.requisites != null) {
            return false;
        }
        return value != null ? value.equals(account.value) : account.value == null;
    }

    @Override
    public int hashCode() {
        int result = requisites != null ? requisites.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
