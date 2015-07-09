package com.pl.tt.practices.entities;

import javax.persistence.*;

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
