package application.domain.model;
public record Review(String id,Customer customer,Product product,int rating,String comment) { public Review {if(rating<1||rating>5)throw new IllegalArgumentException("Rating must be 1..5");} }
