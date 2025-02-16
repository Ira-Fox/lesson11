package com.example.domain;

public class Product{
    private Integer id;
    private String name;
    private String description;
    private Float price;

    public Product (int id, String name, String description, float price){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product (String name, String description, float price){
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setPrice(float price){
        this.price = price;
    }

    public float getPrice(){
        return price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        
        result = prime * result + ((description == null) ?0 : description.hashCode());
        result = prime * result + ((id == null) ?0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((price == null) ?0: price.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Product other = (Product) obj;

        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;

        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;

        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;

        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;

        return true;
    }

    @Override
    public String toString(){
        return "id: " + id + ";  name: " + name + ";  description: " + description + ";  price: " + price;
    }
}