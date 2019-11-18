package com.example.myapplication.core.web.entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MaterialResult implements Serializable {

        @SerializedName("name")
        private String name;

        @SerializedName("quantity")
        private String quantity;

        @SerializedName("stock")
        private String stock;

        @SerializedName("image_url")
        private String image;

        @SerializedName("price")
        private String price;

        @SerializedName("tax")
        private String tax;

        @SerializedName("shipping")
        private String shipping;

        @SerializedName("description")
        private String description;

        public String getName() {
            return name;
        }
        public String getQuantity() {
            return quantity;
        }
        public String getStock() {
            return stock;
        }
        public String getImage() {
            return image;
        }
        public String getPrice() {
            return price;
        }
        public String getTax() {
            return tax;
        }
        public String getShipping() {
            return shipping;
        }
        public String getDescription() {
            return description;
        }

        public MaterialResult response;
}
