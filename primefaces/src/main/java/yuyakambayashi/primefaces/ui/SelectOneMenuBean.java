/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yuyakambayashi.primefaces.ui;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import yuyakambayashi.primefaces.model.Country;
import lombok.*;

/**
 *
 * @author yuya-kambayashi
 */
@Named(value = "selectOneMenuBean")
@SessionScoped
public class SelectOneMenuBean implements Serializable {

    @Getter
    @Setter
    private List<Country> countries;

    @Getter
    @Setter
    private Country country;

    @Getter
    @Setter
    private List<String> countryNames;

    @Getter
    @Setter
    private String countryName;

    @Getter
    @Setter
    private String selectedOption;

    @Getter
    @Setter
    private String selectedOptionOtherValue;

    @Getter
    @Setter
    private String city;

    @Getter
    @Setter
    private List<String> cities;

    /**
     * Creates a new instance of SelectOneMenuBean
     */
    public SelectOneMenuBean() {

        country = null;
        countries = null;

        init();
    }

    public void init() {
        countries = new ArrayList<Country>();
        countries.add(new Country("ANDORRA", "AD"));
        countries.add(new Country("UNITED ARAB EMIRATES", "AE"));
        countries.add(new Country("AFGHANISTAN", "AF"));
        countries.add(new Country("ANTIGUA AND BARBUDA", "AG"));
        countries.add(new Country("ANGUILLA", "AI"));
        countries.add(new Country("ALBANIA", "AL"));

        cities = new ArrayList<String>();
        cities.add("TOKYO");
        cities.add("OSAKA");
        cities.add("NAGOYA");
        cities.add("FUKUOKA");

    }
}
