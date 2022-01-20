/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yuyakambayashi.primefaces.model;

import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;

/**
 *
 * @author yuya-kambayashi
 */
public class Country implements Serializable, Comparable<Country> {

    private String name;
    private String code;

    public Country() {
    }

    public Country(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Country country = (Country) o;
        return Objects.equals(name, country.name)
                && Objects.equals(code, country.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Country o) {
        return name.compareTo(o.name);
    }
}
