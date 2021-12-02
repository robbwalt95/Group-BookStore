package com.example.bookStore.domain;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity

public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)



    private Long id;
    private String Company;
    private String Company_id;
    private int phoneNumber;
    private String address;

    public Vendor() {
    }


    public Vendor(Long id, String company, String company_id, int phoneNumber, String address) {
        this.id = id;
        this.Company = company;
        this.Company_id = company_id;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getCompany_id() {
        return Company_id;
    }

    public void setCompany_id(String company_id) {
        Company_id = company_id;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "id=" + id +
                ", Company='" + Company + '\'' +
                ", Company_id='" + Company_id + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendor vendor = (Vendor) o;
        return phoneNumber == vendor.phoneNumber && Objects.equals(id, vendor.id) && Objects.equals(Company, vendor.Company) && Objects.equals(Company_id, vendor.Company_id) && Objects.equals(address, vendor.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Company, Company_id, phoneNumber, address);
    }
}