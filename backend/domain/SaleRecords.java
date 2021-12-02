package com.example.bookStore.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

/** /This creates a DB oobjects for Sales in the H2 DB.
 * created 10/11/21
 */

@Entity

public class SaleRecords {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private int invoiceNumber;
    private int Customer_id;
    private String Date;
    private String Description;
    private Boolean shipped_status;

    public SaleRecords() {
    }

    public SaleRecords(Long id, int invoiceNumber, int customer_id, String date, String description, Boolean shipped_status) {
        this.id = id;
        this.invoiceNumber = invoiceNumber;
        this.Customer_id = customer_id;
        this.Date = date;
        this.Description = description;
        this.shipped_status = shipped_status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public int getCustomer_id() {
        return Customer_id;
    }

    public void setCustomer_id(int customer_id) {
        Customer_id = customer_id;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Boolean getShipped_status() {
        return shipped_status;
    }

    public void setShipped_status(Boolean shipped_status) {
        this.shipped_status = shipped_status;
    }

    @Override
    public String toString() {
        return "SaleRecords{" +
                "id=" + id +
                ", invoiceNumber=" + invoiceNumber +
                ", Customer_id=" + Customer_id +
                ", Date='" + Date + '\'' +
                ", Description='" + Description + '\'' +
                ", shipped_status=" + shipped_status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleRecords that = (SaleRecords) o;
        return invoiceNumber == that.invoiceNumber && Customer_id == that.Customer_id && Objects.equals(id, that.id) && Objects.equals(Date, that.Date) && Objects.equals(Description, that.Description) && Objects.equals(shipped_status, that.shipped_status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, invoiceNumber, Customer_id, Date, Description, shipped_status);
    }

}
