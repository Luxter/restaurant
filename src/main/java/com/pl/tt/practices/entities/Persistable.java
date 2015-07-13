package com.pl.tt.practices.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * Created by cyranl on 2015-07-09.
 */
@MappedSuperclass
public class Persistable {

    @Id
    @GeneratedValue
    protected long id;

    @Version
    protected long version;

    public Persistable() {
    }

    public long getId() {
        return id;
    }

    public long getVersion() {
        return version;
    }

}
