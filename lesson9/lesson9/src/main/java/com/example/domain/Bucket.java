package com.example.domain;
import java.util.*;

public class Bucket{
    private Integer id;
    private Integer userId;
    private Integer productId;
    private Date purchaseDate;

    public Bucket(int id, int userId, int productId, Date purchaseDate){
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.purchaseDate = purchaseDate;
    }
    public Bucket(int userId, int productId, Date purchaseDate){
        this.userId = userId;
        this.productId = productId;
        this.purchaseDate = purchaseDate;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public int getUserId(){
        return userId;
    }

    public void setProductId(int productId){
        this.productId = productId;
    }

    public int getProductId(){
        return productId;
    }

    public void setPurchaseDate(Date purchaseDate){
        this.purchaseDate = purchaseDate;
    }

    public Date getPurchaseDate(){
        return purchaseDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        
        result = prime * result + ((userId == null) ?0 : userId.hashCode());
        result = prime * result + ((id == null) ?0 : id.hashCode());
        result = prime * result + ((productId == null) ? 0 : productId.hashCode());
        result = prime * result + ((purchaseDate == null) ?0: purchaseDate.hashCode());
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

        Bucket other = (Bucket) obj;

        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;

        if (productId == null) {
            if (other.productId != null)
                return false;
        } else if (!productId.equals(other.productId))
            return false;

        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;

        if (purchaseDate == null) {
            if (other.purchaseDate != null)
                return false;
        } else if (!purchaseDate.equals(other.purchaseDate))
            return false;

        return true;
    }

    @Override 
    public String toString(){
        return "id: " + id + ";  user id: " + userId + ";  product id: " + productId + ";  date: " + purchaseDate;
    }

}