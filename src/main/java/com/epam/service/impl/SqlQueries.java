package com.epam.service.impl;

final class SqlQueries {

    private SqlQueries() {}

    /* =========== Gift Section =========== */

    static final String GIFT_FIND_BY_ID = """
            select *
            from gift_certificate
            where id = ?""";

    static final String GIFT_FIND_BY_NAME = """
            select *
            from gift_certificate
            where name = ?""";

    static final String GIFT_FIND_ALL = """
            select *
            from gift_certificate""";

    static final String GIFT_UPDATE = """
            update gift_certificate
            set name = ?, description = ?, price = ?, duration = ?,
            create_date = ?, last_update_time = ?
            where id = ?""";

    static final String GIFT_SAVE = """
            insert into gift_certificate
            (id, name, description, price, duration, create_date, last_update_time)
            values (?, ?, ?, ?, ?, ?, ?)""";

    static final String GIFT_FIND_BY_TAG_ID = """
            select gc.*
            from gift_tag_mapping gtm
            inner join gift_certificate gc on gc.id = gtm.gc_id
            inner join tags t on t.id = gtm.t_id
            where t.id = ?""";

    static final String GIFT_FIND_BY_TAG_NAME = """
            select gc.*
            from gift_tag_mapping gtm
            inner join gift_certificate gc on gc.id = gtm.gc_id
            inner join tags t on t.id = gtm.t_id
            where t.name = ?""";

    static final String GIFT_DELETE_BY_ID = """
            delete from gift_certificate
            where id = ?""";

    static final String GIFT_FIND_BY_PARTIAL_NAME = """
            select *
            from gift_certificate gc
            where lower(gc.name) like ?""";

    static final String GIFT_FIND_BY_PARTIAL_DESC = """
            select *
            from gift_certificate gc
            where lower(gc.description) like ?""";

    static final String GIFT_ADD_TAG_TO_CERTIFICATE = """
            do $$
            declare
                currentCerfId bigint := ?;
                currentTagName varchar := ?;
            begin
                if not exists(
                    select * from tags
                    where name = currentTagName
                    )
                then
                    insert into tags (name)
                    values (currentTagName);
                    declare
                        currentTagId bigint := (select id from tags
                                        where name = currentTagName);
                    begin
                        insert into gift_tag_mapping (gc_id, t_id)
                        values (currentCerfId, currentTagId);
                    end;
                else
                    declare
                        currentTagId bigint := (select id from tags
                                        where name = currentTagName);
                    begin
                        insert into gift_tag_mapping (gc_id, t_id)
                        values (currentCerfId, currentTagId);
                    end;
                end if;
            commit;
            end $$""";

    /* =========== Tag Section =========== */

    static final String TAG_FIND_BY_ID = """
            select *
            from tags
            where id = ?""";

    static final String TAG_FIND_BY_NAME = """
            select *
            from tags
            where name = ?""";

    static final String TAG_FIND_ALL = """
            select *
            from tags""";

    static final String TAG_UPDATE = """
            update tags
            set name = ?
            where id = ?""";

    static final String TAG_SAVE = """
            insert into tags (name)
            values (?)""";

    static final String TAG_FIND_BY_GIFT_ID = """
            select t.*
            from gift_tag_mapping gtm
            inner join tags t on t.id = gtm.t_id
            where gtm.gc_id = ?""";

    static final String TAG_FIND_BY_GIFT_NAME = """
            select t.*
            from gift_tag_mapping gtm
            inner join tags t on t.id = gtm.t_id
            inner join gift_certificate gc on gtm.gc_id = gc.id
            where gc.name = ?""";

    static final String TAG_DELETE_BY_ID = """
            delete from tags
            where id = ?""";
}
