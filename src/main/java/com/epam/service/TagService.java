package com.epam.service;

import com.epam.entity.impl.Tag;

import java.util.List;

/**
 * The {@link Tag} specific service layer
 * that extends the {@link Service} interface
 * with additional specialized methods.
 */
public interface TagService extends Service<Tag> {

    /**
     * Finds all the tags {@link Tag} in the
     * database that are bound to the given
     * {@link com.epam.entity.impl.GiftCertificate} id
     * and returns them all as a {@link List}.
     *
     * @param id a certificate's id
     *
     * @return an empty {@link List} or filled with the results
     */
    List<Tag> findByGiftId(Long id);

    /**
     * Finds all the tags {@link Tag} in the
     * database that are bound to the given
     * {@link com.epam.entity.impl.GiftCertificate} name
     * and returns them all as a {@link List}.
     *
     * @param name a certificate's name
     *
     * @return an empty {@link List} or filled with the results
     */
    List<Tag> findByGiftName(String name);
}