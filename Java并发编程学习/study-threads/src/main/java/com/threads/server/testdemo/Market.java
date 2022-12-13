package com.threads.server.testdemo;

/**
 * @author 枫伦
 * @DESCRIPTION
 * @create 2021/5/21 2:52 下午
 */
public class Market {
    String company;
    String country;

    public Market(String company, String country) {
        this.company = company;
        this.country = country;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
