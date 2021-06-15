package server.hotelreservation.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ratings")
@Data
public class Rating {

    @Id
    @Column(name = "rating_id")
    private long ratingId;

    @Column(name = "value")
    private double value;

    @Column(name = "comment")
    private String comment;

    public Rating(long ratingId, double value, String comment) {
        this.ratingId = ratingId;
        this.value = value;
        this.comment = comment;
    }

    public Rating() {
    }
}
