package com.example.store;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Model {
    public class Category {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("name")
        @Expose
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    public class Characteristic {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("value")
        @Expose
        private String value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

    }

    public class Example {

        @SerializedName("total")
        @Expose
        private String total;
        @SerializedName("pages")
        @Expose
        private Integer pages;
        @SerializedName("length")
        @Expose
        private Integer length;
        @SerializedName("page")
        @Expose
        private Integer page;
        @SerializedName("products")
        @Expose
        private List<Product> products = null;

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public Integer getPages() {
            return pages;
        }

        public void setPages(Integer pages) {
            this.pages = pages;
        }

        public Integer getLength() {
            return length;
        }

        public void setLength(Integer length) {
            this.length = length;
        }

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }

        public List<Product> getProducts() {
            return products;
        }

        public void setProducts(List<Product> products) {
            this.products = products;
        }

    }

    public class Product {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("vendor_code")
        @Expose
        private String vendorCode;
        @SerializedName("body")
        @Expose
        private String body;
        @SerializedName("categories")
        @Expose
        private List<Category> categories = null;
        @SerializedName("price")
        @Expose
        private Integer price;
        @SerializedName("price_old")
        @Expose
        private Integer priceOld;
        @SerializedName("count")
        @Expose
        private Integer count;
        @SerializedName("currency")
        @Expose
        private String currency;
        @SerializedName("images")
        @Expose
        private List<String> images = null;
        @SerializedName("characteristics")
        @Expose
        private List<Characteristic> characteristics = null;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getVendorCode() {
            return vendorCode;
        }

        public void setVendorCode(String vendorCode) {
            this.vendorCode = vendorCode;
        }

        public CharSequence getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public List<Category> getCategories() {
            return categories;
        }

        public void setCategories(List<Category> categories) {
            this.categories = categories;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public Integer getPriceOld() {
            return priceOld;
        }

        public void setPriceOld(Integer priceOld) {
            this.priceOld = priceOld;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public List<Characteristic> getCharacteristics() {
            return characteristics;
        }

        public void setCharacteristics(List<Characteristic> characteristics) {
            this.characteristics = characteristics;
        }

    }
}
