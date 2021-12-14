package com.epam.util.sorting.impl;

import com.epam.util.sorting.SqlSorting;

/**
 * Stores and provides {@link com.epam.entity.impl.GiftCertificate}
 * -specific SQL sorting sub-queries which are to be
 * concatenated with the main query to sort the result of it.
 */
public enum GiftSqlSorting implements SqlSorting {

    BY_NAME_ASC("\norder by gc.name asc"),
    BY_NAME_DESC("\norder by gc.name desc"),
    BY_DATE_ASC("\norder by gc.create_date asc"),
    BY_DATE_DESC("\norder by gc.create_date desc");

    private final String order;

    GiftSqlSorting(String order) {
        this.order = order;
    }

    public String getOrder() {
        return order;
    }
}
