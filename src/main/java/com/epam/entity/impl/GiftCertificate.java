package com.epam.entity.impl;

import com.epam.entity.Entity;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * A representation of the gift_certificate
 * table in the database.
 */
public class GiftCertificate implements Entity {

    private long id;
    private String name;
    private String desc;
    private double price;
    private int duration;
    private Timestamp createDate;
    private Timestamp lastUpdateTime;

    private GiftCertificate() {}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public double getPrice() {
        return price;
    }

    public int getDuration() {
        return duration;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public Timestamp getLastUpdateTime() {
        return lastUpdateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GiftCertificate that = (GiftCertificate) o;
        return id == that.id
                && Double.compare(that.price, price) == 0
                && duration == that.duration
                && Objects.equals(name, that.name)
                && Objects.equals(desc, that.desc)
                && Objects.equals(createDate, that.createDate)
                && Objects.equals(lastUpdateTime, that.lastUpdateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, desc, price,
                duration, createDate, lastUpdateTime);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GiftCertificate{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", desc='").append(desc).append('\'');
        sb.append(", price=").append(price);
        sb.append(", duration=").append(duration);
        sb.append(", createDate=").append(createDate);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append('}');
        return sb.toString();
    }

    public static Builder newBuilder() {
        return new GiftCertificate().new Builder();
    }

    public class Builder {

        private Builder() {}

        public Builder setId(long id) {
            GiftCertificate.this.id = id;
            return this;
        }

        public Builder setName(String name) {
            GiftCertificate.this.name = name;
            return this;
        }

        public Builder setDesc(String desc) {
            GiftCertificate.this.desc = desc;
            return this;
        }

        public Builder setPrice(double price) {
            GiftCertificate.this.price = price;
            return this;
        }

        public Builder setDuration(int duration) {
            GiftCertificate.this.duration = duration;
            return this;
        }

        public Builder setCreateDate(Timestamp createDate) {
            GiftCertificate.this.createDate = createDate;
            return this;
        }

        public Builder setLastUpdateTime(Timestamp lastUpdateTime) {
            GiftCertificate.this.lastUpdateTime = lastUpdateTime;
            return this;
        }

        public GiftCertificate build() {
            return GiftCertificate.this;
        }
    }
}
