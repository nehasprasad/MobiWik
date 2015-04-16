package com.example.android.mobiwik;

import com.parse.ParseFile;

public class Mobile {

    String Name, Price, Brand,Camera,Memory,RAM,Weight;
    ParseFile image;

    Mobile () {

    };

    public Mobile(String name, ParseFile n, String brand, String price,String camera,String memory,String ram,String weight) {
        Name = name;
        this.image = n;
        Brand = brand;
        this.Price = price;
        Camera=camera;
        Memory=memory;
        RAM=ram;
        Weight=weight;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ParseFile getImage() {
        return image;
    }

    public void setImage(ParseFile image) {
        this.image = image;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        this.Price = price;
    }
    public String getCamera() {
        return Camera;
    }

    public void setCamera(String camera) {
        Camera = camera;
    }
    /*public String getMemory() {
        return Memory;
    }

    public void setMemory(String memory) {
        Memory = memory;
    }
    public String getRAM() {
        return RAM;
    }

    public void setRAM(String ram) {
        RAM = ram;
    }
    /*
    public String getWeight() {
        return Weight;
    }

    public void setWeight(String weight) {
        Weight = weight;
    }*/
}

/*import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

@ParseClassName("Mobile")
    public class Mobile extends ParseObject {
    public ParseFile getImage(){
        return getParseFile("Image");
    }

    public void setImage(ParseFile image){
        put("Image", image);
    }

     public String getName() {

         return getString("Name");
        }
     public void setName(String name) {
            put("Name", name);
        }

    public String getBrand() {

        return getString("Brand");
    }
    public void setBrand(String brand) {

        put("Brand", brand);
    }

    public String getPrice() {
         return getString("Price");
     }
    public void setPrice(String price) {
            put("Price", price);
    }
    public String getCamera() {
        return getString("Camera");
    }
    public void setCamera(String camera){
        put("Camera",camera);
    }
    public String getMemory() {
        return getString("Memory");
    }
    public void setMemory(String memory) {
        put("Memory", memory);
    }
    public String getRAM() {
        return getString("RAM");
    }
    public void setRAM(String ram) {
        put("RAM", ram);
    }

    public String getWeight() {
        return getString("Weight");
    }
    public void setWeight(String weight) {
        put("Weight", weight);
    }

        public static ParseQuery<Mobile> getQuery(){
            return ParseQuery.getQuery(Mobile.class);
        }

        @Override
        public String toString(){
            return getString("Name")+ "\n" +getString("Brand")+ "\n" +getString("Price")+"\n"+getString("Camera")+"\n"+getString("Memory")+"\n" +getString("RAM")+"\n"+getString("Weight");
        }
    }*/




