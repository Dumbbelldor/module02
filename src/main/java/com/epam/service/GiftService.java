package com.epam.service;

import com.epam.entity.impl.GiftCertificate;
import com.epam.util.sorting.impl.GiftSqlSorting;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The {@link GiftCertificate} specific service layer
 * that extends the {@link Service} interface
 * with additional specialized methods.
 */
@Component
public interface GiftService extends Service<GiftCertificate> {

    /**
     * Finds all the certificates {@link GiftCertificate}
     * in the database that are bound to the given
     * {@link com.epam.entity.impl.Tag} id
     * and returns them all as a {@link List}.
     *
     * @param id a tag's id
     *
     * @return an empty {@link List} or filled with the results
     */
    List<GiftCertificate> findByTagId(Long id);

    /**
     * Finds all the certificates {@link GiftCertificate}
     * in the database that are bound to the given
     * {@link com.epam.entity.impl.Tag} id
     * and returns them all as a {@link List}.
     * <p>
     * Sorts the result by the given rule, passed through
     * {@link GiftSqlSorting} constant.
     *
     * @param id a tag's id
     * @param param a sorting parameter
     *
     * @return an empty {@link List} or filled with the results
     */
    List<GiftCertificate> findByTagId(Long id, GiftSqlSorting param);

    /**
     * Finds all the certificates {@link GiftCertificate}
     * in the database that are bound to the given
     * {@link com.epam.entity.impl.Tag} name
     * and returns them all as a {@link List}.
     *
     * @param name a tag's name
     *
     * @return an empty {@link List} or filled with the results
     */
    List<GiftCertificate> findByTagName(String name);

    /**
     * Finds all the certificates {@link GiftCertificate}
     * in the database that are bound to the given
     * {@link com.epam.entity.impl.Tag} name
     * and returns them all as a {@link List}.
     * <p>
     * Sorts the result by the given rule, passed through
     * {@link GiftSqlSorting} constant.
     *
     * @param name a tag's name
     * @param param a sorting parameter
     *
     * @return an empty {@link List} or filled with the results
     */
    List<GiftCertificate> findByTagName(String name, GiftSqlSorting param);

    /**
     * Finds all the certificates {@link GiftCertificate}
     * in the database that contain the given part of the
     * certificate's name, then returns them all as a {@link List}.
     *
     * @param part a {@link String} that should be part of the name
     *
     * @return an empty {@link List} or filled with the results
     */
    List<GiftCertificate> findByPartialName(String part);

    /**
     * Finds all the certificates {@link GiftCertificate}
     * in the database that contain the given part of the
     * certificate's name, then returns them all as a {@link List}.
     * <p>
     * Sorts the result by the given rule, passed through
     * {@link GiftSqlSorting} constant.
     *
     * @param part a {@link String} that should be part of the name
     * @param param a sorting parameter
     *
     * @return an empty {@link List} or filled with the results
     */
    List<GiftCertificate> findByPartialName(String part, GiftSqlSorting param);

    /**
     * Finds all the certificates {@link GiftCertificate}
     * in the database that contain the given part of the
     * certificate's description, then returns them all as a {@link List}.
     *
     * @param part a {@link String} that should be part of the description
     *
     * @return an empty {@link List} or filled with the results
     */
    List<GiftCertificate> findByPartialDesc(String part);

    /**
     * Finds all the certificates {@link GiftCertificate}
     * in the database that contain the given part of the
     * certificate's description, then returns them all as a {@link List}.
     * <p>
     * Sorts the result by the given rule, passed through
     * {@link GiftSqlSorting} constant.
     *
     * @param part a {@link String} that should be part of the description
     * @param param a sorting parameter
     *
     * @return an empty {@link List} or filled with the results
     */
    List<GiftCertificate> findByPartialDesc(String part, GiftSqlSorting param);

    /**
     * Bounds the {@link com.epam.entity.impl.Tag} to the
     * {@link GiftCertificate} by creating a new record in the
     * database.
     * <p>
     * The tag will be found by its name and the certificate
     * by its id.
     * <p>
     * If a non-existent tag is passed, then a new one will be
     * created and bound.
     *
     * @param certId a certificate's id
     * @param name a tag's name
     *
     * @return true if operation was successful
     */
    boolean addTagToCertificate(Long certId, String name);
}
