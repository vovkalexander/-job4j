package ru.job4j.lsp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Food.
 * @author Vovk Alexander  vovk.ag747@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class Food {
    /**
     * Field - activate object of SimpleDateFormat class.
     */
    private final SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
    /**
     * Field - store link for object of  String.
     */
    private String name;
    /**
     * Field - store link for object of Date.
     */
    private Date expireDate;
    /**
     * Field - store link for object of Date.
     */
    private Date createDate;
    /**
     * Field - store link for object of Double.
     */
    private Double price;
    /**
     * Field - store link for object of Double.
     */
    private Double discount;
    /**
     * Constructor for activation fields.
     */

    public Food(String name, String expireDate, String createDate, Double price, Double discount) throws ParseException {
        this.name = name;
        this.expireDate = myFormat.parse(expireDate);
        this.createDate = myFormat.parse(createDate);
        this.price = price;
        this.discount = discount;
    }
    /*
     * The method returns  expire date of food objects.
     * @return expireDate- field class Date.
     */

    public Date getExpireDate() {
        return this.expireDate;
    }
    /*
     * The method returns  create date of food objects.
     * @return createDate - field class Date.
     */

    public Date getCreateDate() {
        return this.createDate;
    }
    /*
     * The method returns number which is use period from current date.
     * @return num - number class Integer.
     */

    public Integer dateDifference()  {
        int num = (int) (100 - (expireDate.getTime() - System.currentTimeMillis()) * 100 / (expireDate.getTime() - createDate.getTime()));
        return num;
    }
    /*
     * The method sets up discount of product.
     * @param - discount of product.
     */

    public void setDiscount(Double discount) {
        this.price = this.price - (this.price * discount);
    }
    /*
     * The method returns  price of product.
     * @return - price of product.
     */

    public Double getPrice() {
        return this.price;
    }
    /*
     * The method returns  discount of product.
     * @return - discount of product.
     */

    public Double getDiscount() {
        return this.discount;
    }
    /*
     * The method returns  name of product.
     * @return - name of product.
     */

    public String getName() {
       return this.name;
    }
}


